import java.awt.Dimension;
import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

public class DBApp {
	private ArrayList<Ref> temp = new ArrayList<Ref>();
	private ArrayList<Ref> Oldtemp = new ArrayList<Ref>();

	public DBApp() {

	}

	public void init() {

	}

	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType) throws DBAppException {
		legalType(strTableName, htblColNameType);
		legalName(strTableName);
		Table t = new Table(strTableName);

		this.serializeTable(t.getFilename(), t);
		writemetadataCSV(strTableName, strClusteringKeyColumn, htblColNameType);

	}

	public void createBTreeIndex(String strTableName, String strColName) throws DBAppException {

		tableNotFound(strTableName);
		columnNotFound(strTableName, strColName);
		String tmp = getDataType(strTableName, strColName);

		BPTree tree = null;

		int nodeSize = this.getNoNodes();

		if (tmp.equals("java.lang.Integer")) {
			tree = new BPTree<Integer>(nodeSize);

		} else if (tmp.equals("java.lang.String")) {
			tree = new BPTree<String>(nodeSize);

		} else if (tmp.equals("java.lang.Double")) {
			tree = new BPTree<Double>(nodeSize);

		} else if (tmp.equals("java.lang.Boolean")) {
			tree = new BPTree<Boolean>(nodeSize);

		} else if (tmp.equals("java.util.Date")) {
			tree = new BPTree<Date>(nodeSize);

		} else if (tmp.equals("java.awt.Polygon")) {
			// tree = new BPTree<>(2);
			DBAppException e = new DBAppException("Cannot crate b+ index on a polygon type");
			throw e;

		}

		System.out.println(tree.toString());

		tree.setFileName(strTableName, strColName);

		int colIndex = this.getColumnIndex(strTableName, strColName);

		Comparable entry;
		Page p;

		ArrayList<String> pageNames = this.getPagesNames(strTableName);
		//
		for (int i = 0; i < pageNames.size(); i++) {

			p = this.deserializePage(this.getPagesNames(strTableName).get(i));

			for (int j = 0; j < p.row.size(); j++) {
				rows r = p.row.get(j);
				// if (tmp.equals("java.awt.Polygon")) {
				// polygonComparable pcom = new polygonComparable<>();
				// Polygon poly = (Polygon) r.tuples.get(colIndex);
				// pcom.p1 = poly;
				// entry = (Comparable) pcom;
				// }

				entry = (Comparable) r.tuples.get(colIndex);
				tree.insert(entry, new Ref(pageNames.get(i), j));

			}

			this.serializePage(p.getFilename(), p);

		}

		indexCSV(strTableName, strColName);
		tree.setFileName(strTableName, strColName);
		this.serializeBPTree(tree.getFileName(), tree);
	}



	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException

	{
		rows insert = createOrderedRow(strTableName, htblColNameValue);
		int index = getKeyIndex(strTableName);
		String columnName = getKeyName(strTableName);

		ArrayList<String> pg = this.getPagesNames(strTableName);
		int tsize = this.getTableSize(strTableName);
		String keyName = this.getKeyName(strTableName);
		String dataType = this.getDataType(strTableName, keyName);
		Boolean empty;
		Table t = this.deserializeTable(strTableName + ".ser");
		int x = t.pageNames.size();
		if (x == 0)
			empty = true;
		else
			empty = false;
		this.serializeTable(strTableName + ".ser", t);
		String pageName;
		int rightPosition;
		Ref position = null;
		System.err.println(hasIndex(strTableName, columnName));
		if (hasIndex(strTableName, columnName)) {

			BPTree tree = null;

			if (dataType.equals("java.awt.Polygon")) {
				tree = (RTree) this.deserializeRTree(strTableName + "," + columnName + ".ser");

			} else {
				tree = this.deserializeBPTree(strTableName + "," + columnName + ".ser");

			}

			Comparable key = this.getCell(strTableName, insert, columnName,
					this.getColumnIndex(strTableName, columnName));

			// BPTree tree = this.deserializeBPTree(strTableName + "," + columnName +
			// ".ser");
			// find position
			System.err.println("I ENTERED 2");
			int m = getMaxRows();
			position = tree.insertRef(key, m, strTableName, empty);
			pageName = position.getFileName();
			// int pageNo = this.getPageIndexinArray(pageName, strTableName);
			int pageNo = Integer.parseInt(pageName.substring(strTableName.length(), pageName.length() - 4));
			rightPosition = position.getIndexInPage();
			// then insert
			insertIntoTableTree(strTableName, htblColNameValue, pageNo, rightPosition);
			tree.insert(key, position);
			// then update bp tree
			BPTreeLeafNode leaf = tree.searchGreaterthan(key);
			if (leaf != null) {
				int treeIndex = -1;
				for (int i = 0; i < leaf.numberOfKeys; i++) {
					if (leaf.getKey(i).compareTo(key) > 0) {
						treeIndex = i;
						break;
					}
				}
				tree.updateRef(temp, treeIndex, leaf);

			}

			if (dataType.equals("java.awt.Polygon")) {
				this.serializeRTree(strTableName + "," + columnName + ".ser", (RTree) tree);

			} else {
				this.serializeBPTree(strTableName + "," + columnName + ".ser", tree);

			}

		}
//		}

		else {
			position = this.insertIntoTableOld(strTableName, htblColNameValue);
			System.err.println("I ENTERED 0");
			// i updated insert sorted to search for the right place using binary

		}
		ArrayList<String> otherColumns = otherIndex(strTableName);

		for (int i = 0; i < otherColumns.size(); i++) {
			String dataType2 = this.getDataType(strTableName, otherColumns.get(i));
			if (dataType2.equals("java.awt.Polygon")) {
				System.err.println("I ENTERED 3");
				RTree tree = this.deserializeRTree(strTableName + "," + otherColumns.get(i) + ".ser");
				Polygon p1 = (Polygon) insert.tuples.get(getColumnIndex(strTableName, otherColumns.get(i)));
				polygonComparable c1 = changePolygon(p1);
				// Comparable c1 = (Comparable) insert.tuples.get(getColumnIndex(strTableName,
				// otherColumns.get(i)));

				tree.updateRefNonKey(Oldtemp, temp);
				tree.insert(c1, position);

				this.serializeRTree(strTableName + "," + otherColumns.get(i) + ".ser", tree);
				System.err.println("i entedre poly");
			} else {
				System.err.println("I ENTERED 4");
				BPTree tree = this.deserializeBPTree(strTableName + "," + otherColumns.get(i) + ".ser");
				Comparable c = (Comparable) insert.tuples.get(getColumnIndex(strTableName, otherColumns.get(i)));
				tree.updateRefNonKey(Oldtemp, temp);
				tree.insert(c, position);

				this.serializeBPTree(strTableName + "," + otherColumns.get(i) + ".ser", tree);
			}
		}

	}

	public void updateTable(String strTableName, String strKey, Hashtable<String, Object> htblColNameValue)
			throws DBAppException {

		Set<String> keys = htblColNameValue.keySet();

		for (String key : keys) {
			checkExceptions(key, htblColNameValue.get(key).getClass().getName(), strTableName);

		}

		String primKey = this.getKeyName(strTableName);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();
			Comparable key2 = null;

			int keyIndex = this.getKeyIndex(strTableName);
			Boolean found = false;
			String keyType = "";

			while (line != null && (!(found))) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName) && info[3].equals("True")) {
					found = true;
					String tmp = info[2];
					keyType = tmp;

					if (tmp.equals("java.lang.Integer")) {
						int key = Integer.parseInt(strKey);
						key2 = (Comparable) key;

					} else if (tmp.equals("java.lang.String")) {
						String key = strKey;
						key2 = (Comparable) key;

					} else if (tmp.equals("java.lang.Double")) {
						double key = Double.parseDouble(strKey);
						key2 = (Comparable) key;

					} else if (tmp.equals("java.lang.Boolean")) {
						Boolean key = Boolean.parseBoolean(strKey);
						key2 = (Comparable) key;

					} else if (tmp.equals("java.util.Date")) {
						String date = strKey;

						try {
							Date key = new SimpleDateFormat("dd/MM/yyyy").parse(date);
							key2 = (Comparable) key;

						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else if (tmp.equals("java.awt.Polygon")) {
						Polygon p = new Polygon();
						StringTokenizer st = new StringTokenizer(strKey, "),(", false);
						// ArrayList<Integer> x = new ArrayList<Integer>();
						// ArrayList<Integer> y = new ArrayList<Integer>();
						int x;
						int y;
						while (st.hasMoreTokens()) {
							x = Integer.parseInt(st.nextToken());
							y = Integer.parseInt(st.nextToken());
							p.addPoint(x, y);
						}

						polygonComparable key = new polygonComparable();
						key.setPoly(p);
						key2 = (Comparable) key;

					}

				}
				line = br.readLine();

			}

			if (this.hasIndex(strTableName, primKey)) {
				updateHelperIndexed(key2, strTableName, primKey, htblColNameValue);
			} else {
				this.updateHelper(key2, keyIndex, strTableName, htblColNameValue, keyType);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		tableNotFound(strTableName);

		boolean flag = false;
		boolean keyisindexed = false;
		boolean otherindex = false;
		ArrayList<String> colnames = new ArrayList();
		// put colnames in this table in an arraylist
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();
			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName)) {
					// System.out.println("here");
					colnames.add(info[1]);
				}
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		// make array list of colnames in hashtable
		ArrayList<String> colnames1 = new ArrayList();
		for (int i = 0; i < colnames.size(); i++) {
			if (htblColNameValue.containsKey(colnames.get(i))) {
				colnames1.add(colnames.get(i));
			}
		}

		String keyname = this.getKeyName(strTableName);
		ArrayList<String> indexedcols_notkey = new ArrayList();

		if (hasIndex(strTableName, keyname) && colnames1.contains(keyname)) {
			keyisindexed = true;
		}
		// indexedcols_notkey --> in hashtable
		for (int j = 0; j < colnames1.size(); j++) {
			if ((hasIndex(strTableName, colnames1.get(j))) && colnames1.get(j) != keyname) {
				indexedcols_notkey.add(colnames1.get(j));
				otherindex = true;
			}
		}

		///////////////////////////////
		// ArrayList of all indexed cols in this table
		ArrayList<String> Allindexedcols = new ArrayList();
		for (int m = 0; m < colnames.size(); m++) {
			if ((hasIndex(strTableName, colnames.get(m)))) {
				Allindexedcols.add(colnames.get(m));
			}
		}
		// ArrayList of all indexed cols in hashtable
		ArrayList<String> hashtable_indexcol = new ArrayList();
		for (int z = 0; z < colnames1.size(); z++) {
			if ((hasIndex(strTableName, colnames1.get(z)))) {
				hashtable_indexcol.add(colnames1.get(z));
			}
		}
		//////////////////////////////

		// DELETING WITH HASHTABLE DOES NOT HAVE KEY OR INDEX (old delete ) and check
		// law fe index in table
		if ((hashtable_indexcol.size() == 0 || hashtable_indexcol == null)
				&& !(htblColNameValue.containsKey(keyname))) {
			Page p;

			if (Allindexedcols.size() != 0) {
				for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {
					p = this.deserializePage(this.getPagesNames(strTableName).get(i));
					for (int j = 0; j < p.row.size(); j++) {
						rows r = p.row.get(j);
						if (this.rowCheck(htblColNameValue, r, strTableName)) {

							for (int k = 0; k < Allindexedcols.size(); k++) {
								int m = getColumnIndex(strTableName, Allindexedcols.get(k));
								if ((this.getDataType(strTableName, Allindexedcols.get(k))
										.equals("java.awt.Polygon"))) {
									RTree tree2 = this
											.deserializeRTree(strTableName + "," + Allindexedcols.get(k) + ".ser");
									ArrayList searchDuplicates = tree2.searchDuplicates(
											givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
									for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
										tree2.delete(givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k1)),
												(Ref) searchDuplicates.get(k1));
									}
									this.serializeRTree(tree2.getFileName(), tree2);
								} else {

									BPTree tree = this
											.deserializeBPTree(strTableName + "," + Allindexedcols.get(k) + ".ser");
									ArrayList searchDuplicates = tree.searchDuplicates(
											givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
									for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
										tree.delete(givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k1)),
												(Ref) searchDuplicates.get(k1));
									}
									this.serializeBPTree(tree.getFileName(), tree);
								}
							}

							p.row.remove(r);

							j--;

							flag = true;
						}

					}

					if (p.row.size() == 0) {
						this.deletePageFromArray(strTableName, p.getFilename());
						File file = new File(p.getFilename());
						file.delete();
						i--;
						flag = true;
						System.out.println("done");
						// t.decPages();
					}
					this.serializePage(p.getFilename(), p);

				}

			} else {

				for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {

					p = this.deserializePage(this.getPagesNames(strTableName).get(i));

					for (int j = 0; j < p.row.size(); j++) {
						rows r = p.row.get(j);
						if (this.rowCheck(htblColNameValue, r, strTableName)) {

							p.row.remove(r);

							j--;

							flag = true;
						}

					}

					if (p.row.size() == 0) {
						this.deletePageFromArray(strTableName, p.getFilename());
						File file = new File(p.getFilename());
						file.delete();
						i--;
						flag = true;
						System.out.println("done");
						// t.decPages();
					}
					this.serializePage(p.getFilename(), p);
				}
			}
		}

		// DELETING WITH HASHTABE HAS KEY BUT NO INDEX (binary search) and check law fe
		// index in table
		else if ((hashtable_indexcol.size() == 0 || hashtable_indexcol == null)
				&& (htblColNameValue.containsKey(keyname))) {
			Page p;
			if (Allindexedcols.size() != 0) {
				if (this.getDataType(strTableName, keyname).equals("java.awt.Polygon")) {

					for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {
						p = this.deserializePage(this.getPagesNames(strTableName).get(i));
						int firstocc = this.binarySearchHassanPoly(
								(polygonComparable) givevalue(strTableName, htblColNameValue, keyname), strTableName);
						if (firstocc == -1) {
							System.out.println(" " + "what you're deleting doesnot exist");
						} else {
							for (int j = firstocc; j < p.row.size(); j++) {
								if (firstocc == -1) {
									System.out.println(" " + "what you're deleting doesnot exist");
								}
								rows r = p.row.get(j);

								if (this.rowCheck(htblColNameValue, r, strTableName)) {

									for (int k = 0; k < Allindexedcols.size(); k++) {
										int m = getColumnIndex(strTableName, Allindexedcols.get(k));
										if ((this.getDataType(strTableName, Allindexedcols.get(k))
												.equals("java.awt.Polygon"))) {
											RTree tree2 = this.deserializeRTree(
													strTableName + "," + Allindexedcols.get(k) + ".ser");
											ArrayList searchDuplicates = tree2.searchDuplicates(
													givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
											for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
												tree2.delete(
														givevalue2(strTableName, r.tuples.get(m),
																Allindexedcols.get(k1)),
														(Ref) searchDuplicates.get(k1));
											}
											this.serializeRTree(tree2.getFileName(), tree2);
										} else {

											BPTree tree = this.deserializeBPTree(
													strTableName + "," + Allindexedcols.get(k) + ".ser");
											ArrayList searchDuplicates = tree.searchDuplicates(
													givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
											for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
												tree.delete(
														givevalue2(strTableName, r.tuples.get(m),
																Allindexedcols.get(k1)),
														(Ref) searchDuplicates.get(k1));
											}
											this.serializeBPTree(tree.getFileName(), tree);
										}
									}

									p.row.remove(r);

									j--;

									flag = true;
								}
							}
							if (p.row.size() == 0) {
								this.deletePageFromArray(strTableName, p.getFilename());
								File file = new File(p.getFilename());
								file.delete();
								i--;
								// t.decPages();
							}
							this.serializePage(p.getFilename(), p);

						}
					}
				} else {
					for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {
						p = this.deserializePage(this.getPagesNames(strTableName).get(i));
						int firstocc = binarySearchHassan(givevalue(strTableName, htblColNameValue, keyname),
								strTableName);
						if (firstocc == -1) {
							System.out.println(" " + "what you're deleting doesnot exist");
						} else {
							for (int j = firstocc; j < p.row.size(); j++) {
								if (firstocc == -1) {
									System.out.println(" " + "what you're deleting doesnot exist");
								}
								rows r = p.row.get(j);

								if (this.rowCheck(htblColNameValue, r, strTableName)) {

									for (int k = 0; k < Allindexedcols.size(); k++) {
										int m = getColumnIndex(strTableName, Allindexedcols.get(k));
										if ((this.getDataType(strTableName, Allindexedcols.get(k))
												.equals("java.awt.Polygon"))) {
											RTree tree2 = this.deserializeRTree(
													strTableName + "," + Allindexedcols.get(k) + ".ser");
											ArrayList searchDuplicates = tree2.searchDuplicates(
													givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
											for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
												tree2.delete(
														givevalue2(strTableName, r.tuples.get(m),
																Allindexedcols.get(k1)),
														(Ref) searchDuplicates.get(k1));
											}
											this.serializeRTree(tree2.getFileName(), tree2);
										} else {

											BPTree tree = this.deserializeBPTree(
													strTableName + "," + Allindexedcols.get(k) + ".ser");
											ArrayList searchDuplicates = tree.searchDuplicates(
													givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
											for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
												tree.delete(
														givevalue2(strTableName, r.tuples.get(m),
																Allindexedcols.get(k1)),
														(Ref) searchDuplicates.get(k1));
											}
											this.serializeBPTree(tree.getFileName(), tree);
										}
									}

									p.row.remove(r);

									j--;

									flag = true;
								}
							}
							if (p.row.size() == 0) {
								this.deletePageFromArray(strTableName, p.getFilename());
								File file = new File(p.getFilename());
								file.delete();
								i--;
								// t.decPages();
							}
							this.serializePage(p.getFilename(), p);

						}
					}
				}
			}

			else {
				if (this.getDataType(strTableName, keyname).equals("java.awt.Polygon")) {
					for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {

						p = this.deserializePage(this.getPagesNames(strTableName).get(i));

						int firstocc = this.binarySearchHassanPoly(
								(polygonComparable) this.givevalue(strTableName, htblColNameValue, keyname),
								strTableName);

						if (firstocc == -1) {
							System.out.println(" " + "what you're deleting doesnot exist");
						} else {
							for (int j = firstocc; j < p.row.size(); j++) {
								if (firstocc == -1) {
									System.out.println(" " + "what you're deleting doesnot exist");
								}

								rows r = p.row.get(j);

								if (this.rowCheck(htblColNameValue, r, strTableName)) {

									p.row.remove(r);

									j--;
									flag = true;
								}
							}
							if (p.row.size() == 0) {
								this.deletePageFromArray(strTableName, p.getFilename());
								File file = new File(p.getFilename());
								file.delete();
								i--;
								// t.decPages();
							}
							this.serializePage(p.getFilename(), p);

						}
					}
				}

				else {
					for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {

						p = this.deserializePage(this.getPagesNames(strTableName).get(i));

						int firstocc = binarySearchHassan(givevalue(strTableName, htblColNameValue, keyname),
								strTableName);

						if (firstocc == -1) {
							System.out.println(" " + "what you're deleting doesnot exist");
						} else {
							for (int j = firstocc; j < p.row.size(); j++) {
								if (firstocc == -1) {
									System.out.println(" " + "what you're deleting doesnot exist");
								}

								rows r = p.row.get(j);

								if (this.rowCheck(htblColNameValue, r, strTableName)) {

									p.row.remove(r);

									j--;
									flag = true;
								}
							}
							if (p.row.size() == 0) {
								this.deletePageFromArray(strTableName, p.getFilename());
								File file = new File(p.getFilename());
								file.delete();
								i--;
								// t.decPages();
							}
							this.serializePage(p.getFilename(), p);

						}
					}
				}

			}
		}
//FEEEEEEEE INDEXXXXXXXXXXXXXXXXXXXXXX delete el fel hashtable then check law fe other index in table
		else if ((hashtable_indexcol.size() != 0)) {
			Page p;

			if (Allindexedcols.size() == 0) {

				for (int i = 0; i < hashtable_indexcol.size(); i++) {

					if (this.getDataType(strTableName, hashtable_indexcol.get(i)).equals("java.awt.Polygon")) {
						RTree tree = this.deserializeRTree(strTableName + "," + hashtable_indexcol.get(i) + ".ser");
						for (int h = 0; h < this.getPagesNames(strTableName).size(); h++) {

							if (tree.search(
									givevalue(strTableName, htblColNameValue, hashtable_indexcol.get(i))) == null) {
								flag = false;
							} else {
								p = this.deserializePage(tree
										.search(givevalue(strTableName, htblColNameValue, hashtable_indexcol.get(i)))
										.getPage());
								for (int j = 0; j < p.row.size(); j++) {
									rows r = p.row.get(j);

									if (this.rowCheck(htblColNameValue, r, strTableName)) {

										for (int k = 0; k < hashtable_indexcol.size(); k++) {
											int m = getColumnIndex(strTableName, hashtable_indexcol.get(k));

											RTree tree2 = this.deserializeRTree(
													strTableName + "," + hashtable_indexcol.get(k) + ".ser");
											tree2.delete(
													givevalue2(strTableName, r.tuples.get(m),
															hashtable_indexcol.get(k)),
													tree2.search(givevalue2(strTableName, r.tuples.get(m),
															hashtable_indexcol.get(k))));
											this.serializeRTree(tree2.getFileName(), tree2);
											// fe index taniiiii

											p.row.remove(r);

											j--;

											flag = true;
										}

									}

									if (p.row.size() == 0) {
										this.deletePageFromArray(strTableName, p.getFilename());
										File file = new File(p.getFilename());
										file.delete();
										h--;
										flag = true;
										System.out.println("done");
										// t.decPages();
									}
									this.serializePage(p.getFilename(), p);

								}

							}
						}

					} else {

						BPTree tree = this.deserializeBPTree(strTableName + "," + hashtable_indexcol.get(i) + ".ser");

						for (int h = 0; h < this.getPagesNames(strTableName).size(); h++) {
							if (tree.search(
									givevalue(strTableName, htblColNameValue, hashtable_indexcol.get(i))) == null) {
								flag = false;
							} else {
								p = this.deserializePage(tree
										.search(givevalue(strTableName, htblColNameValue, hashtable_indexcol.get(i)))
										.getPage());
								for (int j = 0; j < p.row.size(); j++) {

									rows r = p.row.get(j);

									if (this.rowCheck(htblColNameValue, r, strTableName)) {

										for (int k = 0; k < hashtable_indexcol.size(); k++) {
											int m = getColumnIndex(strTableName, hashtable_indexcol.get(k));

											BPTree tree2 = this.deserializeBPTree(
													strTableName + "," + hashtable_indexcol.get(k) + ".ser");
											tree2.delete(
													givevalue2(strTableName, r.tuples.get(m),
															hashtable_indexcol.get(k)),
													tree2.search(givevalue2(strTableName, r.tuples.get(m),
															hashtable_indexcol.get(k))));
											// tree2.searchDuplicates(givevalue2(strTableName, r.tuples.get(m),
											// hashtable_indexcol.get(k)));
											/// tree2.deleteAllRefs(this.filteredref(strTableName, htblColNameValue,
											// givevalue2(strTableName, r.tuples.get(m), hashtable_indexcol.get(k)),
											// hashtable_indexcol.get(i)), givevalue2(strTableName, r.tuples.get(m),
											// hashtable_indexcol.get(k)) );
											// tree2.deleteAllRefs(this.filteredref(strTableName, htblColNameValue,
											// givevalue2(strTableName, r.tuples.get(m), hashtable_indexcol.get(k))
											// ,hashtable_indexcol.get(i) , givevalue2(strTableName, r.tuples.get(m),
											// hashtable_indexcol.get(k))));
											this.serializeBPTree(tree2.getFileName(), tree2);

											// fe index taniiiii

											p.row.remove(r);

											j--;

											flag = true;
										}

									}

									if (p.row.size() == 0) {
										this.deletePageFromArray(strTableName, p.getFilename());
										File file = new File(p.getFilename());
										file.delete();
										h--;
										flag = true;
										System.out.println("done");
										// t.decPages();
									}
									this.serializePage(p.getFilename(), p);

								}

							}
						}

					}

				}
			}

			else if (Allindexedcols.size() != 0) {
				// for(int w=0;w<Allindexedcols.size();w++){
				for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {
					p = this.deserializePage(this.getPagesNames(strTableName).get(i));
					for (int j = 0; j < p.row.size(); j++) {
						rows r = p.row.get(j);
						if (this.rowCheck(htblColNameValue, r, strTableName)) {

							for (int k = 0; k < Allindexedcols.size(); k++) {
								int m = getColumnIndex(strTableName, Allindexedcols.get(k));
								if ((this.getDataType(strTableName, Allindexedcols.get(k))
										.equals("java.awt.Polygon"))) {
									RTree tree2 = this
											.deserializeRTree(strTableName + "," + Allindexedcols.get(k) + ".ser");
									ArrayList searchDuplicates = tree2.searchDuplicates(
											givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
									for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
										tree2.delete(givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k1)),
												(Ref) searchDuplicates.get(k1));
									}
									this.serializeRTree(tree2.getFileName(), tree2);
								} else {

									BPTree tree = this
											.deserializeBPTree(strTableName + "," + Allindexedcols.get(k) + ".ser");
									ArrayList searchDuplicates = tree.searchDuplicates(
											givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)));
									if (searchDuplicates != null) {
										for (int k1 = 0; k1 < searchDuplicates.size(); k1++) {
											tree.delete(
													givevalue2(strTableName, r.tuples.get(m), Allindexedcols.get(k)),
													(Ref) searchDuplicates.get(k1));
										}
									}
									this.serializeBPTree(tree.getFileName(), tree);
								}
							}

							p.row.remove(r);

							j--;

							flag = true;
						}

					}

					if (p.row.size() == 0) {
						this.deletePageFromArray(strTableName, p.getFilename());
						File file = new File(p.getFilename());
						file.delete();
						i--;
						flag = true;
						System.out.println("done");
						// t.decPages();
					}
					this.serializePage(p.getFilename(), p);

				}

			}

		}

		if (flag == false) {

			throw new DBAppException("deleting a record that does not exit!");

		}
	}

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {

		if (arrSQLTerms.length == 0)
			throw new DBAppException("Must have at least 1 entries in SQLTerms array in order to operate");

		if (strarrOperators != null && strarrOperators.length + 1 != arrSQLTerms.length)
			throw new DBAppException(
					"incorrect number of entires in the arrays\n The number of strarroperators must be less than the number of SQLTerms by 1");

		Vector result = new Vector();

		String strTableName = arrSQLTerms[0].get_strTableName();
		String strColName;
		String strOperator;
		Object objValue;
		Vector resultTables = new Vector();

		// exception handling
		for (int i = 0; i < arrSQLTerms.length; i++) {
			if ((arrSQLTerms[i].get_strTableName()).compareTo(strTableName) != 0)
				throw new DBAppException("Joins are not supported, so you must select from the same table");

			tableNotFound(arrSQLTerms[i].get_strTableName());
			columnNotFound(arrSQLTerms[i].get_strTableName(), arrSQLTerms[i].get_strColumnName());
			legalOperator(arrSQLTerms[i].get_strOperator());

		}

		for (int i = 0; i < strarrOperators.length; i++) {
			if (arrSQLTerms.length == 1)
				throw new DBAppException("Must have at least two entries in SQLTerms array in order to operate");

			legalstrarrOperators(strarrOperators[i]);
		}

		for (int i = 0; i < arrSQLTerms.length; i++) {

			strTableName = arrSQLTerms[i].get_strTableName();
			strColName = arrSQLTerms[i].get_strColumnName();
			strOperator = arrSQLTerms[i].get_strOperator();
			objValue = arrSQLTerms[i].get_objValue();

			// parsing objValue
			Comparable conditionValue = null;
			String tmp = getDataType(strTableName, strColName);

			conditionValue = this.givevalueSelect(strTableName, objValue, strColName);

			int colIndex = getColumnIndex(strTableName, strColName);
			Vector currentResult = new Vector();

			Boolean isPolygon = false;
			if (this.getDataType(strTableName, strColName).equals("java.awt.Polygon"))
				isPolygon = true;

			if (hasIndex(strTableName, strColName)) {
				BPTree tree = null;

				if (isPolygon) {
					tree = (RTree) this.deserializeRTree(strTableName + "," + strColName + ".ser");

				} else {
					tree = this.deserializeBPTree(strTableName + "," + strColName + ".ser");

				}

				String s = tree.toString();

				BPTreeLeafNode l;
				Ref r;
				rows row;

				switch (strOperator) {

				case ">":
					// what if the condition value isnt in the treeee
					l = tree.searchGreaterthan(conditionValue);

					while (l != null) {

						for (int k = 0; k < l.getNumberOfKeys(); k++) {
							if (l.getKey(k).compareTo(conditionValue) > 0) {

								r = l.getRecord(k);

								row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
								currentResult.add(row);

								if (l.getOverflow(k) != null) {
									Vector overflow = l.getOverflow(k);
									for (int j = 0; j < overflow.size(); j++) {
										r = (Ref) overflow.get(j);
										row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
										currentResult.add(row);

									}
								}

							}

						}

						l = l.getNext();
					}

					// code block
					break;
				case ">=":
					// what if the condition value isnt in the treeee

					if (isPolygon) {
						l = tree.searchGreaterEqualPoly(conditionValue);

					}

					else
						l = tree.searchGreaterEqual(conditionValue);

					while (l != null) {

						for (int k = 0; k < l.getNumberOfKeys(); k++) {
							if (l.getKey(k).compareTo(conditionValue) >= 0
									|| l.getKey(k).compareTo(conditionValue) == -2) {

								r = l.getRecord(k);
								row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
								currentResult.add(row);

								if (l.getOverflow(k) != null) {
									Vector overflow = l.getOverflow(k);
									for (int j = 0; j < overflow.size(); j++) {
										r = (Ref) overflow.get(j);
										row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
										currentResult.add(row);

									}

								}
							}

						}

						l = l.getNext();
					}

					break;

				case "<":
					l = tree.searchMinNode();

					outerloop: while (l != null) {

						for (int n = 0; n < l.getNumberOfKeys(); n++) {

							Comparable k = l.getKey(n);

							if (k.compareTo(conditionValue) != -1)
								break outerloop;

							r = l.getRecord(n);

							row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
							currentResult.add(row);

							if (l.getOverflow(n) != null) {
								Vector overflow = l.getOverflow(n);
								for (int j = 0; j < overflow.size(); j++) {
									r = (Ref) overflow.get(j);
									row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
									currentResult.add(row);

								}

							}

						}

						l = l.getNext();
					}

					// code block
					break;
				case "<=":
					l = tree.searchMinNode();

					outerloop: while (l != null) {

						for (int n = 0; n < l.getNumberOfKeys(); n++) {

							Comparable k = l.getKey(n);

							if (k.compareTo(conditionValue) > 0)
								break outerloop;

							r = l.getRecord(n);

							row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
							currentResult.add(row);

							if (l.getOverflow(n) != null) {
								Vector overflow = l.getOverflow(n);
								for (int j = 0; j < overflow.size(); j++) {
									r = (Ref) overflow.get(j);
									row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
									currentResult.add(row);

								}

							}

						}

						l = l.getNext();
					}

					// code block
					break;
				case "=":
					System.out.println();
					System.out.println();
					System.out.println("TREEEE");
					System.out.println(s);
					System.out.println(tree);
					ArrayList<Ref> references = tree.searchDuplicates(conditionValue);
					for (int j = 0; j < references.size(); j++) {
						r = references.get(j);
						row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
						currentResult.add(row);

					}

					// code block
					break;
				case "!=":

					l = tree.searchMinNode();

					while (l != null) {

						for (int n = 0; n < l.getNumberOfKeys(); n++) {

							Comparable k = l.getKey(n);

							if (k.compareTo(conditionValue) != 0) {

								r = l.getRecord(n);

								row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
								currentResult.add(row);

								if (l.getOverflow(n) != null) {
									Vector overflow = l.getOverflow(n);
									for (int j = 0; j < overflow.size(); j++) {
										r = (Ref) overflow.get(j);
										row = this.retrieveRow(r.getFileName(), r.getIndexInPage());
										currentResult.add(row);

									}

								}
							}
						}

						l = l.getNext();
					}

					// code block
					break;
				default:
					// code block
				}

				resultTables.add(currentResult);

			}

			else {

				ArrayList<String> arr = this.getPagesNames(strTableName);
				Comparable currentCell;

				if (this.getKeyName(strTableName).equals(strColName) && (!(strOperator.equals("!=")))) {

					int pageIndex;
					int firsOccurence = -1;
					int rowiStart;
					Page p;
					Comparable curCell;

					// binary search
					System.out.println();
					System.err.println("binary searching.. beep boop");

					switch (strOperator) {
					case ">":
						pageIndex = this.getRightPageNoBiggerThan(conditionValue, strTableName, ">");
						if (pageIndex != -1) {

							// int firsOccurence1 =
							// this.binarySearchSelect(this.deserializePage(arr.get(pageIndex)),
							// conditionValue, strTableName,">");
							firsOccurence = this.binarySearchSelect(this.deserializePage(arr.get(pageIndex)),
									conditionValue, strTableName);

							System.err.println("here");
							System.out.println("pageIndex " + pageIndex);
							System.out.println("firsOccurence1 " + firsOccurence);
							if (firsOccurence != -1) {
								for (int pagei = pageIndex; pagei < arr.size(); pagei++) {
									System.out.println("pagei " + pagei);
									p = this.deserializePage(arr.get(pagei));

									if (pagei == pageIndex)
										rowiStart = firsOccurence;
									else
										rowiStart = 0;

									for (int rowi = rowiStart; rowi < p.row.size(); rowi++) {
										rows curRow = (rows) p.row.get(rowi);

										currentResult.add(curRow);

									}

								}

							}
						}
						// code block
						break;
					case ">=":
						pageIndex = this.getRightPageNoBiggerThan(conditionValue, strTableName, ">=");
						if (pageIndex != -1) {

							firsOccurence = this.binarySearchSelect(this.deserializePage(arr.get(pageIndex)),
									conditionValue, strTableName);

							for (int pagei = pageIndex; pagei < arr.size(); pagei++) {
								System.out.println("pagei " + pagei);
								p = this.deserializePage(arr.get(pagei));

								for (int rowi = 0; rowi < p.row.size(); rowi++) {
									rows curRow = (rows) p.row.get(rowi);

									curCell = this.getCell(strTableName, curRow, strColName, colIndex);

									if (curCell.compareTo(conditionValue) >= 0
											|| curCell.compareTo(conditionValue) == -2)
										currentResult.add(curRow);

								}

							}

						}

						break;

					case "=":

						pageIndex = this.getPageIndexbs(conditionValue, strTableName);
						if (pageIndex != -1) {

							if (isPolygon) {

								System.out.println("\n IN POLY CASE");
								firsOccurence = this.binarySearchHassanPoly(this.changePolygon((Polygon) objValue),
										strTableName);
							}

							else {
								firsOccurence = this.binarySearchHassan(conditionValue, strTableName);
							}

							if (firsOccurence != -1) {

								System.err.println("\nfirsrt occ " + firsOccurence);
								outerloop: for (int pagei = pageIndex; pagei < arr.size(); pagei++) {
									p = this.deserializePage(arr.get(pagei));

									if (pagei == pageIndex)
										rowiStart = firsOccurence;
									else
										rowiStart = 0;

									for (int rowi = rowiStart; rowi < p.row.size(); rowi++) {

										rows curRow = (rows) p.row.get(rowi);
										curCell = this.getCell(strTableName, curRow, strColName, colIndex);

										if ((curCell.compareTo(conditionValue) > 0))
											break outerloop;

										if (curCell.compareTo(conditionValue) == 0)
											currentResult.add(curRow);

									}

								}

							}

						}

						// code block
						break;

					case "<":

						outerloop: for (int pagei = 0; pagei < arr.size(); pagei++) {
							p = this.deserializePage(arr.get(pagei));

							for (int rowi = 0; rowi < p.row.size(); rowi++) {

								rows curRow = (rows) p.row.get(rowi);
								curCell = this.getCell(strTableName, curRow, strColName, colIndex);
								if ((curCell.compareTo(conditionValue)) != -1)
									break outerloop;
								currentResult.add(curRow);

							}

						}

						// code block
						break;

					case "<=":

						outerloop: for (int pagei = 0; pagei < arr.size(); pagei++) {
							p = this.deserializePage(arr.get(pagei));

							for (int rowi = 0; rowi < p.row.size(); rowi++) {

								rows curRow = (rows) p.row.get(rowi);
								curCell = this.getCell(strTableName, curRow, strColName, colIndex);

								if ((curCell.compareTo(conditionValue)) > 0)
									break outerloop;
								currentResult.add(curRow);

							}

						}

						// code block
						break;
					}

				}

				else {
					for (int k = 0; k < arr.size(); k++) {
						// traverse pages in table
						String filename = arr.get(k);
						Page p = this.deserializePage(filename);
						rows currentRow;

						for (int j = 0; j < p.row.size(); j++) {
							// traverse rows in page

							currentRow = p.row.get(j);

							currentCell = this.getCell(strTableName, currentRow, strColName, colIndex);

							switch (strOperator) {

							case ">":
								if (currentCell.compareTo(conditionValue) > 0)
									currentResult.add(currentRow);

								// code block
								break;
							case ">=":
								if (currentCell.compareTo(conditionValue) >= 0
										|| currentCell.compareTo(conditionValue) == -2)
									currentResult.add(currentRow);

								// code block
								break;
							case "<":
								if (currentCell.compareTo(conditionValue) == -1)
									currentResult.add(currentRow);

								// code block
								break;
							case "<=":
								if (currentCell.compareTo(conditionValue) <= 0)
									currentResult.add(currentRow);

								// code block
								break;
							case "=":
								if (currentCell.compareTo(conditionValue) == 0)
									currentResult.add(currentRow);

								// code block
								break;
							case "!=":
								if (currentCell.compareTo(conditionValue) != 0)
									currentResult.add(currentRow);
								// code block
								break;
							default:
								// code block
							}

						}
						this.serializePage(filename, p);

					}
				}

				resultTables.add(currentResult);

			}

		}
		Iterator filtered = this.filterTables(strarrOperators, resultTables);

		if (!filtered.hasNext()) {
			System.out.println();
			System.out.println("No results found");
		}

		return filtered;

	}

	private Iterator filterTables(String[] strarrOperators, Vector resultTables) {

		for (int i = 0; i < resultTables.size(); i++) {
			System.out.println();
			System.err.println("result " + i);

			Vector v = (Vector) resultTables.get(i);
			for (int j = 0; j < v.size(); j++) {
				rows r = (rows) v.get(j);
				System.out.println(r.tuples);

			}

		}

		Vector finalResults = new Vector();

		if (resultTables.size() != strarrOperators.length + 1) {
			System.out.println("Missing result");
			System.err.println("missing");
			return null;
		}

		if (strarrOperators.length == 0) {
			Vector v1 = (Vector) resultTables.get(0);
			return v1.iterator();
		}

		for (int i = 0; i < strarrOperators.length; i++) {

			String strarrOperator = strarrOperators[i].toUpperCase();

			switch (strarrOperator) {

			case "AND":
				finalResults = this.andRecords((Vector) resultTables.get(i), (Vector) resultTables.get(i + 1));
				resultTables.set(i + 1, finalResults);

				// code block
				break;
			case "OR":
				finalResults = this.orRecords((Vector) resultTables.get(i), (Vector) resultTables.get(i + 1));
				resultTables.set(i + 1, finalResults);

				// code block
				break;
			case "XOR":

				finalResults = this.xorRecords((Vector) resultTables.get(i), (Vector) resultTables.get(i + 1));
				resultTables.set(i + 1, finalResults);

				// code block
				break;

			}
		}

		return finalResults.iterator();

	}

	private Vector andRecords(Vector t1, Vector t2) {
		System.out.println(t1);

		for (int i = 0; i < t1.size(); i++) {
			rows r = (rows) t1.get(i);
			System.out.println(r.tuples);

		}
		for (int i = 0; i < t2.size(); i++) {
			rows r = (rows) t2.get(i);
			System.out.println(r.tuples);

		}

		Vector res = new Vector();

		if (t1.isEmpty())
			return t2;

		if (t2.isEmpty())
			return t1;

		if (t1.size() < t2.size()) {
			Vector temp = new Vector();
			temp = t1;
			t1 = t2;
			t2 = temp;
		}

		for (int i = 0; i < t1.size(); i++) {

			rows currRow = (rows) t1.get(i);

			for (int j = 0; j < t2.size(); j++) {

				if (currRow.equals(t2.get(j)))
					res.add(currRow);

			}

		}

		return res;
	}

	private Vector orRecords(Vector t1, Vector t2) {

		if (t1.isEmpty())
			return t2;

		if (t2.isEmpty())
			return t1;

		Vector intersection = this.andRecords(t1, t2);

		t1 = this.diffRecords(t1, intersection);

		t2.addAll(t2.size(), t1);

		return t2;
	}

	private Vector xorRecords(Vector t1, Vector t2) {

		if (t1.isEmpty())
			return t2;

		if (t2.isEmpty())
			return t1;

		Vector intersection = this.andRecords(t1, t2);

		t1 = this.diffRecords(t1, intersection);
		t2 = this.diffRecords(t2, intersection);

		t2.addAll(t2.size(), t1);

		return t2;
	}

	private Vector diffRecords(Vector big, Vector small) {

		Vector res = new Vector();
		boolean found;

		for (int i = 0; i < big.size(); i++) {
			found = false;
			rows currRow = (rows) big.get(i);

			for (int j = 0; j < small.size(); j++) {
				if (currRow.equals(small.get(j)))
					found = true;

			}

			if (!found)
				res.add(big.get(i));

		}

		return res;

	}

	private int getRightPageNoBiggerThan(Comparable value, String strTableName, String operator) {

		Page p;
		ArrayList<String> array = this.getPagesNames(strTableName);
		String filename;
		Comparable lastElement;
		int index = this.getKeyIndex(strTableName);
		String strColName = this.getKeyName(strTableName);

		for (int i = 0; i < array.size(); i++) {
			filename = array.get(i);
			p = deserializePage(filename);
			lastElement = this.getCell(strTableName, p.row.lastElement(), strColName, index);
			// lastElement = (Comparable)
			// p.row.lastElement().tuples.get(this.getKeyIndex(strTableName));
			System.out.println("lastElement " + lastElement);

			if (operator.equals(">")) {
				System.out.println("page no" + i);
				if (value.compareTo(lastElement) < 0)
					return i;
			} else if (operator.equals(">=")) {

				if (value.compareTo(lastElement) <= 0)
					return i;
			}

		}
		return array.size() - 1;
	}

	private int getRightPageNoInsert(int noOfPages, Comparable value, int indexOfKey, String strTableName) {

		Page p;
		ArrayList<String> array = this.getPagesNames(strTableName);
		String filename;
		Comparable lastElement;

		for (int i = 0; i < array.size(); i++) {
			filename = array.get(i);
			p = deserializePage(filename);
			lastElement = this.getCell(strTableName, p.row.lastElement(), this.getKeyName(strTableName), indexOfKey);
			if (p.row.size() == getMaxRows()) {
				if (value.compareTo(lastElement) < 0 || value.compareTo(lastElement) == 0)
					return i;
			} else {
				if (value.compareTo(lastElement) > 0 || value.compareTo(lastElement) == 0)
					return i;
			}
			this.serializePage(filename, p);

		}
		return array.size() - 1;
	}

	private int binarySearchInsert(Page p, rows r, String strTableName) {
		int index = getKeyIndex(strTableName);
		String strColName = this.getKeyName(strTableName);
		// Comparable value = (Comparable) r.tuples.get(index);
		Comparable value = this.getCell(strTableName, r, strColName, index);

		int f = 0;
		int l = p.row.size() - 1;
		// Comparable fi = (Comparable) p.row.get(f).tuples.get(index);
		Comparable fi = this.getCell(strTableName, p.row.get(f), strColName, index);
		// Comparable la = (Comparable) p.row.get(l).tuples.get(index);
		Comparable la = this.getCell(strTableName, p.row.get(l), strColName, index);

		int PageSize = p.row.size();
		Comparable check0 = -1;
		Comparable check1 = -1;
		while ((fi.compareTo(la) == 0) || (fi.compareTo(la) < 0)) {
			int m = f + (l - f) / 2;

			// Check if present at mid
			if (m != 0)
				check0 = this.getCell(strTableName, p.row.get(m - 1), strColName, index);

			// check0 = (Comparable) p.row.get(m - 1).tuples.get(index);

			// Comparable check = (Comparable) p.row.get(m).tuples.get(index);
			Comparable check = this.getCell(strTableName, p.row.get(m), strColName, index);
			if (m != PageSize - 1)
				check1 = this.getCell(strTableName, p.row.get(m + 1), strColName, index);

			// check1 = (Comparable) p.row.get(m + 1).tuples.get(index);
			rows r1 = p.row.get(m);

			if (check.compareTo(value) == 0)
				return m;
			if ((check.compareTo(value) < 0)
					&& ((m == PageSize - 1) || (check1.compareTo(value) > 0) || (check1.compareTo(value) == 0)))
				return m + 1;
			if ((check.compareTo(value) > 0)
					&& ((m == 0) || (check0.compareTo(value) < 0) || (check0.compareTo(value) == 0)))
				return m;
			// if same key but not same row

			// If value greater, ignore left half
			if (check.compareTo(value) < 0) {
				f = m + 1;
				// fi = (Comparable) p.row.get(f).tuples.get(index);
				fi = this.getCell(strTableName, p.row.get(f), strColName, index);

			}
			// If value is smaller, ignore right half
			else {
				l = m - 1;
				// la = (Comparable) p.row.get(l).tuples.get(index);
				la = this.getCell(strTableName, p.row.get(l), strColName, index);

			}
		}
		return -1;
	}

	private int binarySearchSelect(Page p, Comparable target, String strTableName) {
		int start = 0, end = p.row.size() - 1;

		int ans = -1;

		while (start <= end) {
			int mid = (start + end) / 2;

			// Move to right side if target is
			// greater.

			Comparable vmid = this.getCell(strTableName, p.row.get(mid), this.getKeyName(strTableName),
					this.getKeyIndex(strTableName));

			if (vmid.compareTo(target) <= 0) {
				start = mid + 1;
			}

			// Move left side.
			else {
				ans = mid;
				end = mid - 1;
			}
		}
		return ans;
	}

	private Comparable stringToComparablePOLY(String s) {
		Polygon p = new Polygon();
		StringTokenizer st = new StringTokenizer(s, "),(", false);
		int x;
		int y;
		while (st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			p.addPoint(x, y);
		}

		// Polygon poly=//convert from string to polygon
		// //
		// p.setPoly(poly);
		polygonComparable key = new polygonComparable();
		key.setPoly(p);
		return (Comparable) key;

	}

//	private boolean sameCoordinates( Comparable c1, Comparable c2) {
//		polygonComparable pc1= (polygonComparable) c1;
//		polygonComparable pc2= (polygonComparable) c2;
//		
//		Polygon p1 = pc1.getPoly(pc1);
//		Polygon p2 = pc2.getPoly(pc2);
//		
//	      if (p1.npoints != p2.npoints) {
//	          return false;
//	      }
//	      if (!Arrays.equals(p1.xpoints, p2.xpoints)) {
//	          return false;
//	      }
//	      if (!Arrays.equals(p1.ypoints, p2.ypoints)) {
//	          return false;
//	      }
//	      return true;
//	  }

	private boolean sameRow(rows x, rows y) {
		if (x.tuples.size() != y.tuples.size())
			return false;

		for (int i = 0; i < x.tuples.size(); i++) {
			Comparable z = (Comparable) x.tuples.get(i);
			Comparable q = (Comparable) y.tuples.get(i);
			if ((z).compareTo(q) != 0)
				return false;
		}
		return true;

	}

	private Comparable getCell(String strTableName, rows r, String strColName, int index) {
		Comparable key;
		if (this.getDataType(strTableName, strColName).equals("java.awt.Polygon")) {
			Polygon p = (Polygon) r.tuples.get(index);
			key = (Comparable) this.changePolygon(p);

		} else {

			key = (Comparable) r.tuples.get(index);

		}
		return key;

	}

	private ArrayList<String> otherIndex(String strTableName) {

		ArrayList<String> indexedColumns = new ArrayList<String>();

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = null;
			line = br.readLine();

			while (line != null) {

				String[] info = line.split(",");
				if (info[0].equals(strTableName) && !(info[3].equals("True"))) {

					if (hasIndex(strTableName, info[1])) {
						indexedColumns.add(info[1]);

					}

				}
				line = br.readLine();

			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return indexedColumns;

	}

	private Ref insertIntoTableOld(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException {

		int noOfAttributes = this.getNoOfAttributes(strTableName);

		Set<String> keys = htblColNameValue.keySet();
		for (String key : keys) {
			checkExceptions(key, htblColNameValue.get(key).getClass().getName(), strTableName);

		}

		if (keys.size() < noOfAttributes - 1) {
			throw new DBAppException("There are missing attributes in the record you're trying to insert");
		}

		int tsize = this.getTableSize(strTableName);
		// row creation
		rows r = createOrderedRow(strTableName, htblColNameValue);
		Ref position;
		if (tsize == 0) {
			Page p = new Page(0, strTableName);

			p.row.add(r);
			this.appendPages(strTableName);
			this.addPageToArray(strTableName, p.getFilename());
			serializePage(p.getFilename(), p);
			return new Ref(p.getFilename(), 0);
		} else {
			ArrayList<String> arr = this.getPagesNames(strTableName);
			Boolean allPagesAreFull = true;
			Page p2;

			for (int i = 0; i < arr.size(); i++) {
				p2 = deserializePage(arr.get(i));
				if (!pageisFull(p2)) {
					allPagesAreFull = false;
					this.serializePage(p2.getFilename(), p2);
					break;
				}

				this.serializePage(p2.getFilename(), p2);

			}

			if (allPagesAreFull) {
				// we will create a new page and then insert a row
				Page p = new Page(this.nextPageIndex(strTableName), strTableName);

				this.addPageToArray(strTableName, p.getFilename());

				this.appendPages(strTableName);
				serializePage(p.getFilename(), p);

			}

			int keyIndex = this.getKeyIndex(strTableName);

			position = this.insertSorted(keyIndex, r, strTableName);

		}

		return position;

	}

	private void insertIntoTableTree(String strTableName, Hashtable<String, Object> htblColNameValue, int pageNo,
			int rightPosition) throws DBAppException {

		int noOfAttributes = this.getNoOfAttributes(strTableName);

		Set<String> keys = htblColNameValue.keySet();
		for (String key : keys) {
			checkExceptions(key, htblColNameValue.get(key).getClass().getName(), strTableName);

		}

		if (keys.size() < noOfAttributes - 1) {
			throw new DBAppException("There are missing attributes in the record you're trying to insert");
		}

		int tsize = this.getTableSize(strTableName);
		// row creation
		rows r = createOrderedRow(strTableName, htblColNameValue);

		if (tsize == 0) {
			Page p = new Page(0, strTableName);

			p.row.add(r);
			this.appendPages(strTableName);
			this.addPageToArray(strTableName, p.getFilename());
			serializePage(p.getFilename(), p);

		} else {

			ArrayList<String> arr = this.getPagesNames(strTableName);
			Boolean allPagesAreFull = true;
			Page p2;

			for (int i = 0; i < arr.size(); i++) {
				p2 = deserializePage(arr.get(i));
				if (!pageisFull(p2)) {
					allPagesAreFull = false;
					this.serializePage(p2.getFilename(), p2);
					break;
				}

				this.serializePage(p2.getFilename(), p2);

			}

			if (allPagesAreFull) {
				// we will create a new page and then insert a row
				Page p = new Page(this.nextPageIndex(strTableName), strTableName);
				System.err.println("I entered here");

				this.addPageToArray(strTableName, p.getFilename());

				this.appendPages(strTableName);
				serializePage(p.getFilename(), p);

			}

			int keyIndex = this.getKeyIndex(strTableName);

			this.insertSortedTree(pageNo, rightPosition, r, strTableName, keyIndex);
		}

	}

	private ArrayList<Ref> filteredref2(String strTableName, Hashtable<String, Object> htblColNameValue, Comparable key,
			String keyname) {

		RTree tree = this.deserializeRTree(strTableName + "," + keyname + ".ser");

		ArrayList<Ref> allrefs = tree.searchDuplicates(key);
		this.serializeBPTree(tree.getFileName(), tree);
		Page p;
		ArrayList<Ref> FilteredREF = new ArrayList();
		for (int i = 0; i < allrefs.size(); i++) {
			p = this.deserializePage(allrefs.get(i).getPage());

			for (int j = 0; j < p.row.size(); j++) {
				rows r = p.row.get(j);
				if (this.rowCheck(htblColNameValue, r, strTableName)) {
					FilteredREF.add(allrefs.get(i));
					p.row.remove(r);
					j--;
				}
			}
			if (p.row.size() == 0) {
				this.deletePageFromArray(strTableName, p.getFilename());
				File file = new File(p.getFilename());
				file.delete();
				i--;
				// t.decPages();
			}
			this.serializeRTree(tree.getFileName(), tree);

		}
		return FilteredREF;

	}

	private int binarySearchHassan(Comparable strKey, String strTableName) {

		ArrayList<String> arr = this.getPagesNames(strTableName);
		int pagenameIndex = this.getPageIndexbs(strKey, strTableName);
		String pagename = "";

		int index;

		if (pagenameIndex > -1) {
			pagename = arr.get(pagenameIndex);

			Page p = this.deserializePage(pagename);

			Vector<rows> pagerows = p.row;

			int min = 0;
			int max = pagerows.size();
			int currIndex;
			int keyIndex = this.getKeyIndex(strTableName);

			rows firstrow = pagerows.get(min);
			rows lastrow = pagerows.get(max - 1);

			String datatype = this.getDataType(strTableName, this.getKeyName(strTableName));
			Comparable firstval;
			Comparable lastval;

			if (datatype.equals("java.awt.Polygon")) {
				firstval = (Comparable) changePolygon((Polygon) firstrow.tuples.get(keyIndex));
				lastval = (Comparable) changePolygon((Polygon) lastrow.tuples.get(keyIndex));

			} else {
				firstval = (Comparable) firstrow.tuples.get(keyIndex);
				lastval = (Comparable) lastrow.tuples.get(keyIndex);

			}

			while ((firstval.compareTo(lastval) <= 0)) {

				currIndex = min + ((max - min) / 2);
				Vector currtuples = pagerows.get(currIndex).tuples;

				Comparable currval;
				if (datatype.equals("java.awt.Polygon")) {
					currval = (Comparable) changePolygon((Polygon) currtuples.get(keyIndex));
					// lastval = (Comparable) changePolygon((Polygon)lastrow.tuples.get(keyIndex));

				} else {

					currval = (Comparable) currtuples.get(keyIndex);

				}

				// key is present at mid
				if (strKey.compareTo(currval) == 0) {
					return this.checkFirstOcc(currIndex, strKey, strTableName, p);
				}

				// key is greater, then ignore left and go right
				else if (strKey.compareTo(currval) > 0) {
					min = currIndex + 1;
					firstrow = pagerows.get(min);

					firstval = this.getCell(strTableName, firstrow, this.getKeyName(strTableName),
							this.getKeyIndex(strTableName));
				}

				// key is smaller, then ignore right and go left
				else if (strKey.compareTo(currval) < 0) {
					max = currIndex - 1;
					lastrow = pagerows.get(max);

					lastval = this.getCell(strTableName, lastrow, this.getKeyName(strTableName),
							this.getKeyIndex(strTableName));

					// lastval = (Comparable) lastrow.tuples.get(keyIndex);
				}

			}

			this.serializePage(pagename, p);

		}
		return -1;

	}

	private int binarySearchHassanPoly(polygonComparable strKey, String strTableName) {

		ArrayList<String> arr = this.getPagesNames(strTableName);
		int pagenameIndex = this.getPageIndexbs(strKey, strTableName);
		String pagename = "";

		int index;

		if (pagenameIndex > -1) {
			pagename = arr.get(pagenameIndex);

			Page p = this.deserializePage(pagename);

			Vector<rows> pagerows = p.row;

			int min = 0;
			int max = pagerows.size();
			int currIndex;
			int keyIndex = this.getKeyIndex(strTableName);

			rows firstrow = pagerows.get(min);
			rows lastrow = pagerows.get(max - 1);

			String datatype = this.getDataType(strTableName, this.getKeyName(strTableName));

			polygonComparable firstval = changePolygon((Polygon) firstrow.tuples.get(keyIndex));
			polygonComparable lastval = changePolygon((Polygon) lastrow.tuples.get(keyIndex));

			while ((firstval.compareToArea(lastval) <= 0)) {

				currIndex = min + ((max - min) / 2);
				Vector currtuples = pagerows.get(currIndex).tuples;

				polygonComparable currval = changePolygon((Polygon) currtuples.get(keyIndex));

				// key is present at mid
				if (strKey.compareToArea(currval) == 0) {
					return this.checkFirstOccPoly(currIndex, strKey, strTableName, p);
				}

				// key is greater, then ignore left and go right
				else if (strKey.compareToArea(currval) > 0) {
					min = currIndex + 1;
					firstrow = pagerows.get(min);

					firstval = (polygonComparable) this.getCell(strTableName, firstrow, this.getKeyName(strTableName),
							this.getKeyIndex(strTableName));
				}

				// key is smaller, then ignore right and go left
				else if (strKey.compareToArea(currval) < 0) {
					max = currIndex - 1;
					lastrow = pagerows.get(max);

					lastval = (polygonComparable) this.getCell(strTableName, lastrow, this.getKeyName(strTableName),
							this.getKeyIndex(strTableName));

					// lastval = (Comparable) lastrow.tuples.get(keyIndex);
				}

			}

			this.serializePage(pagename, p);

		}
		return -1;

	}

	private int getPageIndexbs(Comparable strKey, String strTableName) {

		int pagenameIndex = -1;

		ArrayList<String> arr = this.getPagesNames(strTableName);

		for (int i = 0; i < arr.size(); i++) {
			String filename = arr.get(i);

			if (this.checkKeyInthisPage(filename, strKey, strTableName)) {
				pagenameIndex = i;
				break;
			}
		}

		return pagenameIndex;
	}

	private int checkFirstOcc(int index, Comparable strKey, String strTableName, Page p) {

		int keyIndex = this.getKeyIndex(strTableName);
		Vector<rows> pagerows = p.row;
		rows r = pagerows.get(index);

		Comparable curr;
		String datatype = this.getDataType(strTableName, this.getKeyName(strTableName));

		if (datatype.equals("java.awt.Polygon")) {
			curr = (Comparable) changePolygon((Polygon) r.tuples.get(keyIndex));
			// lastkey = (Comparable) changePolygon((Polygon)lasttuple.get(keyIndex));

		} else {
			curr = (Comparable) r.tuples.get(keyIndex);

		}

		int firstOcc = index;

		while (curr.compareTo(strKey) == 0) {
			firstOcc = index;
			index--;
			if (index > -1) {
				r = pagerows.get(index);

				if (datatype.equals("java.awt.Polygon")) {
					curr = (Comparable) changePolygon((Polygon) r.tuples.get(keyIndex));
					// lastkey = (Comparable) changePolygon((Polygon)lasttuple.get(keyIndex));

				} else {
					curr = (Comparable) r.tuples.get(keyIndex);

				}

			} else {
				return firstOcc;
			}
		}
		return firstOcc;
	}

	private int checkFirstOccPoly(int index, polygonComparable strKey, String strTableName, Page p) {

		int keyIndex = this.getKeyIndex(strTableName);
		Vector<rows> pagerows = p.row;
		rows r = pagerows.get(index);

		polygonComparable curr = changePolygon((Polygon) r.tuples.get(keyIndex));
		System.out.println(curr.getArea() + "\n curr area ");
		System.out.println(strKey.getArea() + "\n strKey area ");

		int firstOcc = index;

		while (curr.compareToArea(strKey) == 0) {

			System.out.println("\n in  backwards case");

			firstOcc = index;
			index--;
			if (index > -1) {
				r = pagerows.get(index);

				curr = changePolygon((Polygon) r.tuples.get(keyIndex));

			} else {
				return firstOcc;
			}

		}
		return firstOcc;
	}

	private boolean checkKeyInthisPage(String filename, Comparable strKey, String strTableName) {

		Boolean flag;

		Page p = this.deserializePage(filename);

		Vector<rows> rows = p.row;

		rows firstrow = rows.get(0);
		Vector firsttuple = firstrow.tuples;

		rows lastrow = rows.get(rows.size() - 1);
		Vector lasttuple = lastrow.tuples;

		int keyIndex = this.getKeyIndex(strTableName);
		String datatype = this.getDataType(strTableName, this.getKeyName(strTableName));
		Comparable firstkey;
		Comparable lastkey;

		if (datatype.equals("java.awt.Polygon")) {
			firstkey = (Comparable) changePolygon((Polygon) firsttuple.get(keyIndex));
			lastkey = (Comparable) changePolygon((Polygon) lasttuple.get(keyIndex));

		} else {
			firstkey = (Comparable) firsttuple.get(keyIndex);
			lastkey = (Comparable) lasttuple.get(keyIndex);
		}
		if (strKey.compareTo(firstkey) >= 0 && strKey.compareTo(lastkey) <= 0) {
			flag = true;
		}

		else {
			flag = false;
		}

		this.serializePage(filename, p);

		return flag;
	}

	private Comparable givevalue(String strTableName, Hashtable<String, Object> htblColNameValue, String keyname) {

		String tmp = getDataType(strTableName, keyname);
		Comparable key2 = null;

		if (tmp.equals("java.lang.Integer")) {
			int key = (int) htblColNameValue.get(keyname);
			key2 = (Comparable) key;

		} else if (tmp.equals("java.lang.String")) {
			String key = (String) htblColNameValue.get(keyname);
			key2 = (Comparable) key;

		} else if (tmp.equals("java.lang.Double")) {
			double key = (double) htblColNameValue.get(keyname);
			key2 = (Comparable) key;

		} else if (tmp.equals("java.lang.Boolean")) {
			Boolean key = (Boolean) htblColNameValue.get(keyname);
			key2 = (Comparable) key;

		} else if (tmp.equals("java.util.Date")) {
			String date = (String) htblColNameValue.get(keyname);

			try {
				Date key = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				key2 = (Comparable) key;

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (tmp.equals("java.awt.Polygon")) {
			Polygon p = (Polygon) htblColNameValue.get(keyname);
			polygonComparable key = this.changePolygon(p);
			key2 = (Comparable) key;

		}
		return key2;
	}

	private Comparable givevalue2(String strTableName, Object k, String keyname) {

		String tmp = getDataType(strTableName, keyname);
		Comparable key2 = null;

		if (tmp.equals("java.lang.Integer")) {
			int key = (int) k;
			key2 = (Comparable) key;

		} else if (tmp.equals("java.lang.String")) {
			String key = (String) k;
			key2 = (Comparable) key;

		} else if (tmp.equals("java.lang.Double")) {
			double key = (double) k;
			key2 = (Comparable) key;

		} else if (tmp.equals("java.lang.Boolean")) {
			Boolean key = (Boolean) k;
			key2 = (Comparable) key;

		} else if (tmp.equals("java.util.Date")) {
			String date = (String) k;

			try {
				Date key = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				key2 = (Comparable) key;

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (tmp.equals("java.awt.Polygon"))

		{

			// Polygon p1 = (Polygon) insert.tuples.get(index);
			// polygonComparable p = changePolygon(p1);

			Polygon p = (Polygon) k;
			polygonComparable key = this.changePolygon(p);
			key2 = (Comparable) key;

		}
		return key2;
	}

	private Comparable givevalueSelect(String strTableName, Object objValue, String keyname) {

		String tmp = getDataType(strTableName, keyname);
		Comparable key2 = null;

		if (tmp.equals("java.awt.Polygon")) {

			Polygon p = (Polygon) objValue;

			polygonComparable key = this.changePolygon(p);

			key2 = (Comparable) key;

		}

		else {

			key2 = (Comparable) objValue;

		}
		return key2;
	}

	private ArrayList<Ref> filteredref(String strTableName, Hashtable<String, Object> htblColNameValue, Comparable key,
			String keyname) {

		BPTree tree = this.deserializeBPTree(strTableName + "," + keyname + ".ser");
		// System.out.println("lala");
		ArrayList<Ref> allrefs = tree.searchDuplicates(key);
		this.serializeBPTree(tree.getFileName(), tree);
		// this.serializeBPTree(tree.getFileName(), tree);
		Page p;
		ArrayList<Ref> FilteredREF = new ArrayList();
		for (int i = 0; i < allrefs.size(); i++) {
			p = this.deserializePage(allrefs.get(i).getPage());

			for (int j = 0; j < p.row.size(); j++) {
				rows r = p.row.get(j);
				if (this.rowCheck(htblColNameValue, r, strTableName)) {
					System.out.println("deleteing with index");
					FilteredREF.add(allrefs.get(i));

					p.row.remove(r);
					j--;
				}
			}
			if (p.row.size() == 0) {
				this.deletePageFromArray(strTableName, p.getFilename());
				File file = new File(p.getFilename());
				file.delete();
				i--;
				// t.decPages();
			}
			this.serializePage(p.getFilename(), p);

		}
		return FilteredREF;

	}


	private void updateHelper(Comparable strKey, int keyIndex, String strTableName,
			Hashtable<String, Object> htblColNameValue, String keyType) {

		ArrayList<String> arr = this.getPagesNames(strTableName);

		int pageIndex = this.getPageIndexbs(strKey, strTableName);
		String pagename = arr.get(pageIndex);

		Page p = this.deserializePage(pagename);
		Vector<rows> rows = p.row;

		int firstOcc;
		if (keyType.equals("java.awt.Polygon")) {
			firstOcc = this.binarySearchHassanPoly((polygonComparable) strKey, strTableName);
		} else {
			firstOcc = this.binarySearchHassan(strKey, strTableName);
		}

		rows r = rows.get(firstOcc);
		Vector tuples = r.tuples;

		Comparable key;

		if (keyType.equals("java.awt.Polygon")) {
			key = this.updatePolyHelp(tuples.get(keyIndex));
		} else {
			key = (Comparable) tuples.get(keyIndex);
		}

		while (key.compareTo(strKey) == 0 || key.compareTo(strKey) == -2) {

			Set<String> keys = htblColNameValue.keySet();
			if (key.compareTo(strKey) == 0) {
				for (String k : keys) {

					if (this.hasIndex(strTableName, k)) {

						int columnIndex = this.getColumnIndex(strTableName, k);

						Comparable oldValue = (Comparable) tuples.get(columnIndex);
						Comparable newValue;

						String treename = strTableName + "," + k + ".ser";

						String type = this.getDataType(strTableName, k);

						Ref ref = new Ref(pagename, firstOcc);

						if (type.equals("java.awt.Polygon")) {

							newValue = (Comparable) this.changePolygon((Polygon) htblColNameValue.get(k));

							RTree rtree = this.deserializeRTree(treename);
							rtree.update(oldValue, newValue, ref, ref);
							this.serializeRTree(treename, rtree);

						} else {
							newValue = (Comparable) htblColNameValue.get(k);

							BPTree tree2 = this.deserializeBPTree(treename);
							tree2.update(oldValue, newValue, ref, ref);
							this.serializeBPTree(treename, tree2);
						}

					}

					tuples.set(this.getColumnIndex(strTableName, k), htblColNameValue.get(k));
					tuples.setElementAt(getTimeStamp(), tuples.size() - 1);

				}
			}

			firstOcc++;

			if (firstOcc < rows.size()) {
				r = rows.get(firstOcc);
				tuples = r.tuples;

				if (keyType.equals("java.awt.Polygon")) {
					key = this.updatePolyHelp(tuples.get(keyIndex));
				} else {
					key = (Comparable) tuples.get(keyIndex);
				}

			} else {
				this.serializePage(pagename, p);
				pageIndex++;

				if (pageIndex < arr.size()) {
					pagename = arr.get(pageIndex);
					p = this.deserializePage(pagename);

					firstOcc = 0;
					rows = p.row;
					r = rows.get(firstOcc);
					tuples = r.tuples;
					if (keyType.equals("java.awt.Polygon")) {
						key = this.updatePolyHelp(tuples.get(keyIndex));
					} else {
						key = (Comparable) tuples.get(keyIndex);
					}
				} else {
					break;
				}
			}
		}

		this.serializePage(pagename, p);
	}

	private Comparable updatePolyHelp(Object o) {
		Polygon poly = (Polygon) o;
		return (Comparable) this.changePolygon(poly);
	}

	private void updateHelperIndexed(Comparable strKey, String strTableName, String columnName,
			Hashtable<String, Object> htblColNameValue) {

		String filename = strTableName + "," + columnName + ".ser";

		String columnType = this.getDataType(strTableName, columnName);

		BPTree tree;
		Boolean polygon = false;

		int index = this.getColumnIndex(strTableName, columnName);

		if (columnType.equals("java.awt.Polygon")) {
			tree = (RTree) this.deserializeRTree(filename);
			polygon = true;
		}

		else {
			tree = this.deserializeBPTree(filename);
		}

		ArrayList<Ref> arrRef = tree.searchDuplicates(strKey);

		for (int i = 0; i < arrRef.size(); i++) {

			Ref ref = arrRef.get(i);

			String pageFileName = ref.getFileName();
			int rowIndex = ref.getIndexInPage();

			Page p = this.deserializePage(pageFileName);
			Vector<rows> rows = p.row;
			rows r = rows.get(rowIndex);

			Vector tuples = r.tuples;

			int keyIndex = this.getKeyIndex(strTableName);

			// Comparable key = (Comparable) tuples.get(keyIndex);

			Comparable key = this.getCell(strTableName, r, columnName, index);

			// make sure that the key equals the key in the hshtbl
			if (key.compareTo(strKey) == 0) {

				Set<String> keys = htblColNameValue.keySet();

				for (String k : keys) {
					int columnIndex = this.getColumnIndex(strTableName, k);

					// update the BPtree of the other the clmns if they are
					// indexed

					if (this.hasIndex(strTableName, k)) {

						// Comparable oldValue = (Comparable) tuples.get(columnIndex);
						Comparable oldValue = this.getCell(strTableName, r, k, columnIndex);

						Comparable newValue;

						String treename = strTableName + "," + k + ".ser";

						String type = this.getDataType(strTableName, k);

						if (type.equals("java.awt.Polygon")) {

							newValue = (Comparable) this.changePolygon((Polygon) htblColNameValue.get(k));

							RTree rtree = this.deserializeRTree(treename);
							rtree.update(oldValue, newValue, ref, ref);
							this.serializeRTree(treename, rtree);

						} else {
							newValue = (Comparable) htblColNameValue.get(k);

							BPTree tree2 = this.deserializeBPTree(treename);
							tree2.update(oldValue, newValue, ref, ref);
							this.serializeBPTree(treename, tree2);
						}
					}

					// update table

					tuples.set(columnIndex, htblColNameValue.get(k));
					tuples.setElementAt(getTimeStamp(), tuples.size() - 1);
				}

				this.serializePage(pageFileName, p);
			}

			else {
				System.out.println("tuple is not updated, the keys are not equal");
			}

		}

		if (polygon) {
			this.serializeRTree(filename, (RTree) tree);
		} else {
			this.serializeBPTree(filename, tree);
		}

	}

	private void deleteFromTableOld(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException {
		boolean flag = false;
		tableNotFound(strTableName);
		Page p;

		for (int i = 0; i < this.getPagesNames(strTableName).size(); i++) {

			p = this.deserializePage(this.getPagesNames(strTableName).get(i));

			for (int j = 0; j < p.row.size(); j++) {
				rows r = p.row.get(j);
				if (this.rowCheck(htblColNameValue, r, strTableName)) {
					p.row.remove(r);
					j--;
					flag = true;
				}

			}

			if (p.row.size() == 0) {
				this.deletePageFromArray(strTableName, p.getFilename());
				File file = new File(p.getFilename());
				file.delete();
				i--;
				// t.decPages();
			}
			this.serializePage(p.getFilename(), p);

		}
		if (flag == false) {
			DBAppException e = new DBAppException(
					"you are trying to delete a record that does not exist in this table " + strTableName);
			throw e;
		}
	}

	private Ref insertSorted(int keyIndex, rows r, String strTableName) {
		String keyName = this.getKeyName(strTableName);
		String dataType = this.getDataType(strTableName, keyName);
		int[] insertIndex = { -1, -1 };
		Comparable value;
		int tsize = this.getTableSize(strTableName);
		Ref position;

		if (dataType.equals("java.awt.Polygon")) {
			polygonComparable p = new polygonComparable();
			Polygon p1 = (Polygon) r.tuples.get(keyIndex);
			p.setPoly(p1);
			value = (Comparable) p;

			// insertIndex = this.getIndicesPolygon(pages, p, keyIndex);
		} else {
			value = (Comparable) r.tuples.get(keyIndex);
		}
		ArrayList<String> pg = this.getPagesNames(strTableName);
		int page = getRightPageNoInsert(tsize, value, keyIndex, strTableName);
		Page p1 = this.deserializePage(pg.get(page));
		int rightPosition = binarySearchInsert(p1, r, strTableName);
		insertIndex[0] = page;
		insertIndex[1] = rightPosition;
		String pageName = getPagesNames(strTableName).get(page);
		position = new Ref(pageName, rightPosition);
		this.serializePage(pg.get(page), p1);
		;
		// insertIndex = getIndices(tsize, value, keyIndex, strTableName);

		if (pg.get(insertIndex[0]).equals(pg.get(pg.size() - 1))) {
			Page lpage = this.deserializePage(pg.get(pg.size() - 1));
			if (this.pageisFull(lpage)) {
				Page p = new Page(this.nextPageIndex(strTableName), strTableName);
				this.addPageToArray(strTableName, p.getFilename());
				System.out.println();
				System.err.println("CREATONG 2PAGE " + p.filename);
				System.err.println();
				this.appendPages(strTableName);
				serializePage(p.getFilename(), p);
			}

		}
		String filename = this.getPagesNames(strTableName).get(insertIndex[0]);
		Page rightPage = deserializePage(filename);
		System.out.println("right page ret: " + rightPage.row.size());

		rightPage.row.insertElementAt(r, insertIndex[1]);

		if (rightPage.row.size() < getMaxRows()) {
			serializePage(rightPage.getFilename(), rightPage);
			return position;
		}

		int index = this.getPageIndexinArray(filename, strTableName);
		while (rightPage != null && index < this.getPagesNames(strTableName).size() - 1
				&& rightPage.row.size() > getMaxRows()) {

			r = rightPage.row.lastElement();

			rightPage.row.removeElementAt(getMaxRows());
			this.serializePage(rightPage.getFilename(), rightPage);
			index = this.getPageIndexinArray(rightPage.getFilename(), strTableName);

			filename = this.getPagesNames(strTableName).get(++index);

			rightPage = this.deserializePage(filename);

			if (rightPage != null) {
				rightPage.row.insertElementAt(r, 0);
			}
			if (rightPage.getFilename().equals(this.getPagesNames(strTableName))
					&& rightPage.row.size() > this.getMaxRows()) {
				Page p = new Page(this.nextPageIndex(strTableName), strTableName);
				this.addPageToArray(strTableName, p.getFilename());

				this.appendPages(strTableName);
				serializePage(p.getFilename(), p);

			}

		}

		if (rightPage != null) {

			this.serializePage(filename, rightPage);
		}
		return position;

	}

	private void insertSortedTree(int pageNo, int rightPosition, rows r, String strTableName, int keyIndex) {
		String keyName = this.getKeyName(strTableName);
		String dataType = this.getDataType(strTableName, keyName);
		int[] insertIndex = { -1, -1 };
		this.temp = new ArrayList();
		this.Oldtemp = new ArrayList();
		Comparable value;
		int tsize = this.getTableSize(strTableName);

		if (dataType.equals("java.awt.Polygon")) {
			polygonComparable p = new polygonComparable();
			Polygon p1 = (Polygon) r.tuples.get(keyIndex);
			p.setPoly(p1);
			value = (Comparable) p;

			// insertIndex = this.getIndicesPolygon(pages, p, keyIndex);
		} else {
			value = (Comparable) r.tuples.get(keyIndex);
		}
		ArrayList<String> pg = this.getPagesNames(strTableName);
		// int page = this.g

		// Page p1 = this.deserializePage(pg.get(pageNo));

		insertIndex[0] = pageNo;
		insertIndex[1] = rightPosition;
		// this.serializePage(pg.get(pageNo), p1);

		// insertIndex = getIndices(tsize, value, keyIndex, strTableName);
		System.err.println("pageno" + insertIndex[0]);
		System.err.println("indexno" + insertIndex[1]);
		int h;

		if (pg.get(insertIndex[0]).equals(pg.get(pg.size() - 1))) {
			Page lpage = this.deserializePage(pg.get(pg.size() - 1));
			if (this.pageisFull(lpage)) {
				Page p = new Page(this.nextPageIndex(strTableName), strTableName);
				this.addPageToArray(strTableName, p.getFilename());
				System.out.println();
				System.err.println("CREATONG 2PAGE " + p.filename);
				System.err.println();
				this.appendPages(strTableName);
				serializePage(p.getFilename(), p);

			}

		}
		String filename = this.getPagesNames(strTableName).get(insertIndex[0]);
		Page rightPage = deserializePage(filename);
		System.out.println("right page ret: " + rightPage.row.size());
		// boolean flag = true;
		System.err.println(insertIndex[1]);
		// if ((insertIndex[1]) <= rightPage.row.size() - 1) {
		// flag = false;
		// System.err.println("ana da5alt");
		// }

		rightPage.row.insertElementAt(r, insertIndex[1]);
		//
		ArrayList<rows> row = new ArrayList<rows>();
		ArrayList<String> pages = new ArrayList<String>();
		ArrayList<Integer> rightIndex = new ArrayList<Integer>();
		this.temp = new ArrayList();
		// if (flag == false) {
		h = insertIndex[1];
		int z = h + 1;

		Page p5 = this.deserializePage(pg.get(insertIndex[0]));
		for (int j = h; j < p5.row.size(); j++) {
			Ref r4 = new Ref(pg.get(insertIndex[0]), j);
			Oldtemp.add(r4);

		}
		this.serializePage(pg.get(insertIndex[0]), p5);

		for (int k = insertIndex[0] + 1; k < tsize; k++) {
			Page p1 = this.deserializePage(pg.get(k));
			for (int j = 0; j < p1.row.size(); j++) {
				Ref r3 = new Ref(pg.get(k), j);
				Oldtemp.add(r3);

			}
			this.serializePage(pg.get(k), p1);
		}

		for (int i = z; i < rightPage.row.size() && i < getMaxRows(); i++) {

			rows r5 = (rightPage.row.get(i));
			row.add(r5);
			pages.add(filename);
			rightIndex.add(i);
			Ref ref = new Ref(filename, i);
			temp.add(ref);

			// }
		}

		if (rightPage.row.size() < getMaxRows()) {
			serializePage(rightPage.getFilename(), rightPage);
			return;
		}

		int index = this.getPageIndexinArray(filename, strTableName);

		int x = rightPosition;
		while (rightPage != null && index < this.getPagesNames(strTableName).size() - 1
				&& rightPage.row.size() > getMaxRows()) {
			r = rightPage.row.lastElement();
			rightPage.row.removeElementAt(getMaxRows());
			this.serializePage(rightPage.getFilename(), rightPage);
			index = this.getPageIndexinArray(rightPage.getFilename(), strTableName);

			filename = this.getPagesNames(strTableName).get(++index);

			rightPage = this.deserializePage(filename);

			if (rightPage != null) {

				rightPage.row.insertElementAt(r, 0);
				row.add(r);
				pages.add(filename);
				rightIndex.add(0);
				Ref e = new Ref(filename, 0);
				temp.add(e);
				for (int i = 1; i < rightPage.row.size() && i < getMaxRows(); i++) {

					rows r5 = (rightPage.row.get(i));
					row.add(r5);
					pages.add(filename);
					rightIndex.add(i);
					Ref ref = new Ref(filename, i);
					temp.add(ref);

				}
			}
			if (rightPage.getFilename().equals(this.getPagesNames(strTableName))
					&& rightPage.row.size() > this.getMaxRows()) {
				Page p = new Page(this.nextPageIndex(strTableName), strTableName);
				this.addPageToArray(strTableName, p.getFilename());

				this.appendPages(strTableName);
				serializePage(p.getFilename(), p);

			}

		}
		// this.temp = getNewRef(pages, row, strTableName, rightIndex);

		if (rightPage != null) {

			this.serializePage(filename, rightPage);
		}
		// this.temp=new ArrayList();
		// for(int i=0;i<rightIndex.size();i++) {
		// Ref ref=new Ref(pages.get(i),rightIndex.get(i));
		// temp.add(ref);
		// }
		// //System.err.println();
		// System.err.println( "ana temp"+temp);

	}

	// private ArrayList<Ref> getNewRef(ArrayList<String> filename,
	// ArrayList<rows> row, String tableName,
	// ArrayList<Integer> index) {
	// ArrayList<Ref> references = new ArrayList<Ref>();
	// for (int i = 0; i < index.size(); i++) {
	// System.err.println("I ENTEREDD");
	//
	// //Page p = this.deserializePage(filename.get(i));
	// int x = index.get(i);
	// //this.serializePage(filename.get(i), p);
	// Ref r = new Ref(filename.get(i), x);
	// references.add(r);
	//
	// }
	// return references;
	// // sara's method
	// }

	private int getPageIndexinArray(String filename, String strTableName) {
		ArrayList<String> arr = this.getPagesNames(strTableName);
		int x = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(filename)) {
				x = i;
			}
		}
		return x;
	}

	private int getColumnIndex(String strTableName, String columnName) {
		int i = 0;

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = null;
			line = br.readLine();

			while (line != null) {

				String[] info = line.split(",");
				if (info[0].equals(strTableName)) {

					if (info[1].equals(columnName)) {
						return i;
					}
					i++;

				}
				line = br.readLine();

			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;

	}

	// compares hashtable values with row values of the same attributes
	private boolean rowCheck(Hashtable<String, Object> htblColNameValue, rows r, String strTableName) {
		boolean flag = true;
		// String keyName=this.getKeyName(strTableName);
		// String dataType=this.getDataType(strTableName, keyName);
		String dataType;
		Set<String> keys = htblColNameValue.keySet();
		Comparable Value;
		for (String key : keys) {
			dataType = this.getDataType(strTableName, key);

			if (dataType.equals("java.awt.Polygon")) {
				polygonComparable p1 = new polygonComparable();

				Polygon poly = (Polygon) htblColNameValue.get(key);
				p1.setPoly(poly);
				Value = (Comparable) p1;
			} else {
				Value = (Comparable) htblColNameValue.get(key);
			}

//			if (dataType.equals("java.awt.Polygon")) {
//				Value = this.stringToComparablePOLY((String) htblColNameValue.get(key));
//			} else {
//				Value = (Comparable) htblColNameValue.get(key);
//			}

			int i = getColumnIndex(strTableName, key);
			Comparable compare;
			if (dataType.equals("java.awt.Polygon")) {
				Polygon poly = (Polygon) r.tuples.elementAt(i);
				polygonComparable p2 = this.changePolygon(poly);
				compare = (Comparable) p2;
			} else {
				compare = (Comparable) r.tuples.elementAt(i);
			}
			if (Value.compareTo(compare) != 0)
				flag = false;

		}

		return flag;
	}

	private int getKeyIndex(String strTableName) {
		int i = 0;

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = null;
			line = br.readLine();

			while (line != null) {

				String[] info = line.split(",");
				if (info[0].equals(strTableName)) {

					if (info[3].equals("True")) {
						return i;
					}
					i++;

				}
				line = br.readLine();

			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;

	}

	private String getKeyName(String strTableName) {
		String s = "";

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = null;
			line = br.readLine();

			while (line != null) {

				String[] info = line.split(",");
				if (info[0].equals(strTableName)) {

					if (info[3].equals("True")) {
						s = info[1];

						return s;
					}

				}
				line = br.readLine();

			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;

	}

	public ArrayList<String> getPagesNames(String strTableName) {
		Table t = this.deserializeTable(strTableName + ".ser");

		ArrayList<String> arr = t.getPageNames();
		serializeTable(t.getFilename(), t);
		return arr;

	}

	private void deletePageFromArray(String strTableName, String pageName) {
		Table t = this.deserializeTable(strTableName + ".ser");
		ArrayList<String> arr = t.getPageNames();
		arr.remove(pageName);
		t.setPageNames(arr);
		serializeTable(t.getFilename(), t);
	}

	private void addPageToArray(String strTableName, String pageName) {
		Table t = this.deserializeTable(strTableName + ".ser");

		ArrayList<String> arr = t.getPageNames();
		arr.add(pageName);
		t.setPageNames(arr);

		serializeTable(t.getFilename(), t);

	}

	private static String getDataType(String strTableName, String columnName) {
		BufferedReader br = null;
		String out = null;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName) && info[1].equals(columnName)) {
					out = info[2];
					return out;

				}
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;

	}

	private boolean hasIndex(String strTableName, String columnName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName) && info[1].equals(columnName)) {
					if (info[4].equals("True"))
						return true;
					else
						return false;

				}
				line = br.readLine();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	// ///////// EXCEPTION HANDLING METHODS//////////////////////////////

	// checks for correct type, whether the table is there, whether the
	// attribute is
	// there
	private void checkExceptions(String key, String valueType, String strTableName) throws DBAppException {
		Boolean tablefound = false;
		Boolean keyfound = false;
		int no = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName)) {
					tablefound = true;
					no++;
					if (info[1].equals(key)) {
						keyfound = true;
						if (!(valueType.equals(info[2]))) {
							DBAppException e = new DBAppException(key + " is of incorrect type\n Expected type: "
									+ info[2] + " instead it is of type: " + valueType);
							throw e;
						}
					}

				}

				line = br.readLine();

			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!(tablefound)) {
			DBAppException e = new DBAppException(
					"You are inserting into a table that doesn't exist\n Cannot find table: " + strTableName);
			throw e;
		}
		if (!(keyfound)) {
			DBAppException e = new DBAppException(
					"There is no attribute in table: " + strTableName + " with name: " + key);
			throw e;
		}

	}

	// checks that it's one of the 6 data types
	private void legalType(String strTableName, Hashtable<String, String> htblColNameType) throws DBAppException {
		Set<String> keys = htblColNameType.keySet();

		ArrayList<String> legalTypes = new ArrayList<String>() {
			{
				add("java.lang.Integer");
				add("java.lang.String");
				add("java.lang.Double");
				add("java.lang.Boolean");
				add("java.util.Date");
				add("java.awt.Polygon");
			}
		};

		int i = 0;
		for (String key : keys) {
			if (!(legalTypes.contains((htblColNameType.get(key)))))
				throw new DBAppException("The type of" + key + " is invalid. \nIt's of type:" + htblColNameType.get(key)
						+ "\nMust be one of types: \n "
						+ "java.lang.Integer \njava.lang.String \njava.lang.Double \njava.lang.Boolean \njava.util.Date  \njava.awt.Polygon");
		}
	}

//	private void compatibleType(Object objValue, String strColName, String strTableName) throws DBAppException {
//
//		String correctType = getDataType(strTableName, strColName);
//
//		if (!(objValue.getClass().equals(correctType)))
//			throw new DBAppException("Thhe objValue is of type: " + objValue.getClass() + "\nMust be of type: "
//					+ correctType + " in order to compare it to " + strColName);
//
//	}

	private int getNoOfAttributes(String strTableName) throws DBAppException {
		int n = 0;

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName)) {
					n++;

				}

				line = br.readLine();

			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n;

	}

	// table not found exception
	private void tableNotFound(String strTableName) throws DBAppException {
		Boolean tablefound = false;

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName))
					tablefound = true;

				line = br.readLine();

			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!tablefound) {
			DBAppException e = new DBAppException(
					"You are inserting into a table that doesn't exist\n Cannot find table: " + strTableName);
			throw e;
		}

	}

	// Column not found exception
	private void columnNotFound(String strTableName, String columnName) throws DBAppException {
		Boolean columnfound = false;

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName) && info[1].equals(columnName))
					columnfound = true;

				line = br.readLine();

			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!columnfound) {
			DBAppException e = new DBAppException(
					"You are inserting into a column that doesn't exist\n Cannot find column: " + columnName
							+ " in table: " + strTableName);
			throw e;
		}

	}

	// valid operator
	private void legalOperator(String operator) throws DBAppException {

		ArrayList<String> legalOperators = new ArrayList<String>() {
			{
				add(">");
				add(">=");
				add("<");
				add("<=");
				add("!=");
				add("=");
			}
		};

		if (!(legalOperators.contains(operator)))
			throw new DBAppException(
					"The operator: " + operator + "is invalid\n Must be one of the following: >, >=, <, <=, != or =");

	}

	// AND, OR, or XOR.
	// valid operator
	private void legalstrarrOperators(String starrOperator) throws DBAppException {

		ArrayList<String> legalOperators = new ArrayList<String>() {
			{
				add("AND");
				add("OR");
				add("XOR");

			}
		};

		if (!(legalOperators.contains(starrOperator.toUpperCase())))
			throw new DBAppException(
					"The operator: " + starrOperator + "is invalid\n Must be one of the following: AND, OR, or XOR");

	}

	private void legalName(String strTableName) throws DBAppException {
		Boolean tablefound = false;

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName))
					tablefound = true;

				line = br.readLine();

			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (tablefound) {
			DBAppException e = new DBAppException(
					"You cannot create a table with name: " + strTableName + "because it already exists");
			throw e;
		}

	}

	// ///////// END EXCEPTION METHODS//////////////////////////////

	// gets max no of rows in a page from properties file
	int getMaxRows() {
		int maxRows = 0;
		try (InputStream input = new FileInputStream("config/DBApp.config")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			maxRows = Integer.parseInt(prop.getProperty("MaximumRowsCountinPage"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return maxRows;
	}

	// gets max no of rows in a page from properties file
	private int getNoNodes() {
		int maxRows = 0;
		try (InputStream input = new FileInputStream("config/DBApp.config")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			maxRows = Integer.parseInt(prop.getProperty("NodeSize"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return maxRows;
	}

	// gets correct index of row and page where a record should be placed
	private int[] getIndices(int noOfPages, Comparable value, int indexOfKey, String strTableName) {
		int[] arr = new int[2];

		String filename;
		Page p;
		String keyName = this.getKeyName(strTableName);
		String dataType = this.getDataType(strTableName, keyName);
		ArrayList<String> array = this.getPagesNames(strTableName);
		filename = array.get(array.size() - 1);

		// int lastPage = noOfPages - 1;

		Comparable lastElement;

		// filename = strTableName + lastPage + ".ser";
		p = deserializePage(filename);

		if (p.row.size() == 0) {
			String f = array.get(array.size() - 2);
			Page p1 = deserializePage(f);
			if (dataType.equals("java.awt.Polygon")) {
				polygonComparable p2 = new polygonComparable();
				Polygon poly = (Polygon) p1.row.lastElement().tuples.get(indexOfKey);
				p2.setPoly(poly);
				lastElement = (Comparable) p2;
			} else
				lastElement = (Comparable) p1.row.lastElement().tuples.get(indexOfKey);

			this.serializePage(p1.getFilename(), p1);

		} else {
			if (dataType.equals("java.awt.Polygon")) {
				polygonComparable p2 = new polygonComparable();
				Polygon poly = (Polygon) p.row.lastElement().tuples.get(indexOfKey);
				p2.setPoly(poly);
				lastElement = (Comparable) p2;
			} else
				lastElement = (Comparable) p.row.lastElement().tuples.get(indexOfKey);

		}

		if (value.compareTo(lastElement) > 0) {
			this.serializePage(p.getFilename(), p);
			arr[0] = this.getPagesNames(strTableName).size() - 1;
			arr[1] = p.row.size();
			return arr;
		}
		Comparable out;

		for (int i = 0; i < array.size(); i++) {
			filename = array.get(i);
			p = deserializePage(filename);
			// System.out.println("i: " + i);

			int noOfRowsInPage = p.row.size();

			for (int j = 0; j < noOfRowsInPage; j++) {
				// System.out.println("j: " + j);
				if (dataType.equals("java.awt.Polygon")) {
					polygonComparable p2 = new polygonComparable();
					Polygon poly = (Polygon) p.row.get(j).tuples.get(indexOfKey);
					p2.setPoly(poly);
					out = (Comparable) p2;
				} else {
					out = (Comparable) p.row.get(j).tuples.get(indexOfKey);
				}
				int x = value.compareTo(out);
				if (x < 0 || (i == array.size() - 1 && j == noOfRowsInPage - 1)) {
					// where i is the page number and j is row index in that
					// page
					arr[0] = i;
					arr[1] = j;
					return arr;

				}

			}

			this.serializePage(filename, p);
		}

		return arr;
	}

	private boolean pageisFull(Page p) {
		if (p.row.size() >= getMaxRows()) {
			return true;
		}

		return false;

	}

	private Timestamp getTimeStamp() {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts;
	}

	private rows createOrderedRow(String strTableName, Hashtable<String, Object> htblColNameValue) {
		rows r = new rows();
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {

				String[] info = line.split(",");
				if (info[0].equals(strTableName)) {

					if (info[1].equals("touchDate"))
						r.tuples.add(getTimeStamp());

					else
						r.tuples.add(htblColNameValue.get(info[1]));

				}
				line = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r.tuples);

		return r;
	}

	private rows retrieveRow(String filename, int rowIndex) {

		Page p = this.deserializePage(filename);
		rows r = p.row.get(rowIndex);
		this.serializePage(filename, p);
		return r;
	}

	// ///////// CSV writing METHODS//////////////////////////////

	private static void writemetadataCSV(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType) {

		BufferedReader br = null;

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("data/metadata.csv", true);
			br = new BufferedReader(new FileReader("data/metadata.csv"));

			String line = br.readLine();

			if (line == null)
				fileWriter.append("Table Name, Column Name, Column Type, ClusteringKey, Indexed\n");

			Set<String> keys = htblColNameType.keySet();

			for (String key : keys) {
				fileWriter.append(strTableName + ",");
				fileWriter.append(key + ",");
				fileWriter.append(htblColNameType.get(key) + ",");

				if (key.equals(strClusteringKeyColumn))
					fileWriter.append("True,");
				else
					fileWriter.append("False,");

				fileWriter.append("False");
				fileWriter.append("\n");

			}

			fileWriter.append(strTableName + ",");
			fileWriter.append("touchDate" + ",");
			fileWriter.append("java.util.Date" + ",");

			if ("touchDate".equals(strClusteringKeyColumn))
				fileWriter.append("True,");
			else
				fileWriter.append("False,");

			fileWriter.append("False");
			fileWriter.append("\n");

			System.out.println("CSV file was updated successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}
	}

	private static void createCSV() {
		String header = "Table Name, Column Name, Column Type, ClusteringKey, Indexed\n";

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("data/metadata.csv");

			fileWriter.append(header);
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}

	private static void indexCSV(String strTableName, String strColName) {

		BufferedReader br = null;

		String csvBody = "";

		try {
			br = new BufferedReader(new FileReader("data/metadata.csv"));
			String line = br.readLine();

			while (line != null) {
				String[] info = line.split(",");
				if (info[0].equals(strTableName) && info[1].equals(strColName))
					line = info[0] + "," + info[1] + "," + info[2] + "," + info[3] + "," + "True";

				csvBody = csvBody + line + "\n";
				line = br.readLine();

			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("data/metadata.csv");

			fileWriter.append(csvBody);
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}



	// ///////// END CSV writing METHODS//////////////////////////////

	public int getTableSize(String strTableName) {
		Table t = this.deserializeTable(strTableName + ".ser");
		int n = this.getPagesNames(strTableName).size();
		this.serializeTable(t.getFilename(), t);
		return n;
	}

	private int nextPageIndex(String strTableName) {
		Table t = this.deserializeTable(strTableName + ".ser");
		int n = t.getnoOfPages();
		serializeTable(t.getFilename(), t);
		return n;
	}

	private void appendPages(String strTableName) {
		Table t = this.deserializeTable(strTableName + ".ser");
		t.appendPages();
		serializeTable(t.getFilename(), t);

	}

	private void decPages(String strTableName) {
		Table t = this.deserializeTable(strTableName + ".ser");
		t.decPages();
		serializeTable(t.getFilename(), t);

	}

	// ///////// SERIALIZATION METHODS//////////////////////////////

	public void serializePage(String filename, Page p) {

		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(p);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + filename);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static Page deserializePage(String filename) {
		Page p = null;

		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			p = (Page) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Page class not found");
			c.printStackTrace();
		}

		return p;
	}

	private void serializeTable(String filename, Table p) {

		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(p);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + filename);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	private Table deserializeTable(String filename) {
		Table p = null;

		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			p = (Table) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
		}

		return p;
	}

	private void serializeBPTree(String filename, BPTree p) {

		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(p);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + filename);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public BPTree deserializeBPTree(String filename) {
		BPTree p = null;

		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			p = (BPTree) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("BPTree class not found");
			c.printStackTrace();
		}

		return p;
	}



	// ///////// END SERIALIZATION METHODS//////////////////////////////

	public static void main(String[] args) throws DBAppException {
		System.out.println(getDataType("TrialStudent", "gpa"));

		DBApp db = new DBApp();

		// db.createBTreeIndex("TrialStudent", "name");

		int x = 5;
		int y = 0;

		Vector t1 = new Vector();
		Vector t2 = new Vector();
		Vector t3 = new Vector();

		t2.add("nahla");
		t2.add("19");
		t2.add("52");

		t1.add("nahla");
		t1.add("19");
		t1.add("52");

		t3.add("nahla");
		t3.add("19");
		t3.add("57777");

		rows r1 = new rows();
		r1.tuples = t1;

		rows r2 = new rows();
		r2.tuples = t2;

		rows r3 = new rows();
		r3.tuples = t3;

		Vector table1 = new Vector();
		table1.add(r1);
		table1.add(r2);
		table1.add(r3);

		Vector t4 = new Vector();
		Vector t5 = new Vector();
		Vector t6 = new Vector();
		Vector t7 = new Vector();

		t4.add("nahla");
		t4.add("19");
		t4.add("52");

		t5.add("nahla");
		t5.add("19");
		t5.add("52");

		t6.add("not-nahla");
		t6.add("19");
		t6.add("57777");

		t7.add("not-nahla");
		t7.add("19");
		t7.add("57777");

		rows r4 = new rows();
		r4.tuples = t4;

		rows r5 = new rows();
		r5.tuples = t5;

		rows r6 = new rows();
		r6.tuples = t6;

		rows r7 = new rows();
		r7.tuples = t7;

		Vector table2 = new Vector();
		table2.add(r4);
		table2.add(r5);
		table2.add(r6);
		table2.add(r7);

		System.out.println("table 1 ");
		for (int i = 0; i < table1.size(); i++) {
			System.out.println(((rows) table1.get(i)).tuples);
		}

		System.out.println("table 2 ");
		for (int i = 0; i < table2.size(); i++) {
			System.out.println(((rows) table2.get(i)).tuples);
		}

		System.out.println();

		Vector res = db.xorRecords(table2, table1);

		System.out.println("RES ");
		for (int i = 0; i < res.size(); i++) {
			System.out.println(((rows) res.get(i)).tuples);
		}

		// t2.addAll(t2.size(), t1);

		Comparable s = (Comparable) x;

		Integer fs = (Integer) 5;
		System.out.println(fs.getClass().getName());

		System.out.println(s.compareTo(y));
	}

}
