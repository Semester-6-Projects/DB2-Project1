import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class BPTree<T extends Comparable<T>> implements Serializable {

	private static final long serialVersionUID = 1L;
	private int order;
	private BPTreeNode<T> root;
	private String filename;
	private ArrayList<BPTreeNode<T>> nodes = new ArrayList<BPTreeNode<T>>();

	/**
	 * Creates an empty B+ tree
	 * 
	 * @param order the maximum number of keys in the nodes of the tree
	 */
	public BPTree(int order) {
		this.order = order;
		root = new BPTreeLeafNode<T>(this.order);
		nodes.add(root);
		root.setRoot(true);
		// nodes=this.getNodes();
		// this.createFile(filename);
	}

	public void setFileName(String tableName, String columnName) {
		filename = tableName + "," + columnName + ".bin";

	}

	public String getFileName() {
		return filename;
	}

	public ArrayList getNodes() {
		ArrayList output = new ArrayList();
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).isRoot()) {

			} else {
				output.add(nodes.get(i));
			}

		}

		return output;
	}

	public void createFile(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename, false);

			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	/**
	 * Inserts the specified key associated with the given record in the B+ tree
	 * 
	 * @param key             the key to be inserted
	 * @param recordReference the reference of the record associated with the key
	 */
	public void insert(T key, Ref recordReference) {
		BPTreeLeafNode leaf = this.searchNode(key);
		if (leaf != null) {
			leaf.insertOverflow(key, recordReference);
		} else {
			PushUp<T> pushUp = root.insert(key, recordReference, null, -1);
			if (pushUp != null) {
				BPTreeInnerNode<T> newRoot = new BPTreeInnerNode<T>(order);
				nodes.add(newRoot);
				newRoot.insertLeftAt(0, pushUp.key, root);
				newRoot.setChild(1, pushUp.newNode);
				root.setRoot(false);
				root = newRoot;
				root.setRoot(true);
			}
		}
	}

	/**
	 * updates a value in the tree
	 */
	public void update(T Oldkey, T newKey, Ref refNew, Ref refOld) {
		delete(Oldkey, refOld);
		insert(newKey, refNew);
	}

	/*
	 * updates the references of shifted keys
	 */

	public void updateRefNonKey(ArrayList<Ref> oldRefs, ArrayList<Ref> newRefs) {
		BPTreeLeafNode min = this.searchMinNode();
		while (min != null) {

			for (int j = 0; j < min.numberOfKeys; j++) {
				for (int i = 0; i < oldRefs.size(); i++) {
					// for each leaf we will check if it is equal to one of the old ref,update if it
					// does and remove
					// old,new corresponding ref
					Ref curRef = oldRefs.get(i);
					Ref newRef = newRefs.get(i);
					if (min.getRecord(j).isEqual(curRef)) {
						min.setRecord(j, newRef);
						oldRefs.remove(i);
						newRefs.remove(i);
						break;

					} else if (min.getOverflow(j) != null && min.overflow.size() > 0) {
						for (int k = 0; k < min.getOverflow(j).size(); k++) {
							if (((Ref) min.getOverflow(j).get(k)).isEqual(curRef)) {
								min.getOverflow(j).remove(k);
								min.getOverflow(j).add(k, newRef);
								oldRefs.remove(i);
								newRefs.remove(i);
								break;
							}
						}
					}
				}
			}
			min = min.getNext();
		}

	}

	public void updateRef(ArrayList<Ref> refs, int index, BPTreeLeafNode leaf) {
		System.err.println(refs);
		System.err.println("Inex is" + 1);
		// leaf.setRecord(index, refs.get(0));
		int j = 0;
		for (int i = index; i < leaf.numberOfKeys && j < refs.size(); i++) {
			leaf.setRecord(i, refs.get(j));
			j++;
			if (leaf.getOverflow(i) != null && leaf.getOverflow(i).size() > 0) {
				System.err.println("I enter when duplicates of" + leaf.getKey(i));
				int size = leaf.getOverflow(i).size();
				leaf.initializeVectors(i);
				for (int m = 0; m < size && j < refs.size(); m++) {
					leaf.getOverflow(i).add(m, refs.get(j));
					j++;

				}
			}
		}
		leaf = leaf.getNext();
		while (leaf != null && j < refs.size()) {
			for (int i = 0; i < leaf.numberOfKeys && j < refs.size(); i++) {
				leaf.setRecord(i, refs.get(j));
				j++;
				if (leaf.getOverflow(i) != null && leaf.getOverflow(i).size() > 0) {
					System.err.println("I enter when duplicates of" + leaf.getKey(i));
					int size = leaf.getOverflow(i).size();
					leaf.initializeVectors(i);
					for (int m = 0; m < size && j < refs.size(); m++) {
						leaf.getOverflow(i).add(m, refs.get(j));
						j++;

					}
				}
			}
			leaf = leaf.getNext();
		}
	}

	/**
	 * Looks up for the record that is associated with th e specified key
	 * 
	 * @param key the key to find its record
	 * @return the reference of the record associated with this key
	 */
	public Ref search(T key) {
		return root.search(key);
	}

	public ArrayList<Ref> searchDuplicates(T Key) {

		return root.searchFromNodesDuplicates(Key);

	}

	public BPTreeLeafNode searchNode(T key) {
		return root.searchForNode2(key);
	}

	public BPTreeLeafNode searchNodeRef(T key, Ref ref) {
		return root.searchForNodeRef(key, ref, this);
	}

	public BPTreeLeafNode searchMinNode() {
		return root.searchForMin();
	}

	public BPTreeLeafNode searchGreaterthan(T key) {
		return root.searchGreaterthan(key);
	}

	public BPTreeLeafNode searchGreaterEqual(T key) {
		return root.searchGreatereEqual(key);
	}

	public BPTreeLeafNode searchGreaterEqualPoly(T key) {
		return root.searchGreatereEqualPoly(key);
	}

	public BPTreeLeafNode getLastLeaf() {
		BPTreeLeafNode curNode = this.searchMinNode();
		while (curNode.getNext() != null) {
			curNode = curNode.getNext();
		}
		return curNode;
	}

	/**
	 * Delete a key and its associated record from the tree.
	 * 
	 * @param key the key to be deleted
	 * @return a boolean to indicate whether the key is successfully deleted or it
	 *         was not in the tree
	 */
	public Ref insertRef(T key, int maxRows, String tableName, boolean empty) {
		if (empty) {
			return new Ref(tableName + "0" + ".class", 0);
		} else {
			BPTreeLeafNode b = this.searchGreaterthan(key);
			if (b == null) {
				Ref BeforeLast;
				if (this.getLastLeaf().getOverflow(this.getLastLeaf().numberOfKeys - 1) != null) {
					if (this.getLastLeaf().getOverflow(this.getLastLeaf().numberOfKeys - 1).size() == 0) {
						BeforeLast = this.getLastLeaf().getLastRecord();
					} else {
						Vector<Ref> refs = this.getLastLeaf().getOverflow(this.getLastLeaf().numberOfKeys - 1);
						BeforeLast = refs.get(refs.size() - 1);
					}
				} else {
					BeforeLast = this.getLastLeaf().getLastRecord();
				}
				System.err.println("Last ref is" + BeforeLast);
				String pageNumber = BeforeLast.getPage();
				String number = pageNumber.substring(tableName.length(), pageNumber.length() - 6);
				int n = Integer.parseInt(number);
				int rowsCurrent = BeforeLast.getIndexInPage() + 1;
				System.err.println("will I enter?");
				if (rowsCurrent >= maxRows) {
					System.err.println("I entered");
					int newRow = 0;
					n++;
					String nn = Integer.toString(n);
					String pageNew = tableName + nn + ".class";
					return new Ref(pageNew, newRow);

				} else {
					return new Ref(pageNumber, rowsCurrent);

				}

			} else {
				int indexInser = -1;
				for (int i = 0; i < b.numberOfKeys; i++)
					if (b.getKey(i).compareTo(key) > 0) {
						indexInser = i;
						break;
					}
				return b.getRecord(indexInser);
			}

		}

	}

	public boolean deleteHelper(T key, Ref ref) {
		if (root.numberOfKeys == 0) {
			if (root instanceof BPTreeInnerNode)
				root = ((BPTreeInnerNode) root).getFirstChild();
		}
		boolean done = root.delete(key, null, -1, ref);
		// go down and find the new root in case the old root is deleted
		while (root instanceof BPTreeInnerNode && !root.isRoot())
			root = ((BPTreeInnerNode<T>) root).getFirstChild();
		return done;

	}

//delete using references
	public boolean delete(T key, Ref ref) {
		boolean done = false;
		BPTreeLeafNode leaf = this.searchNode(key);
		if (leaf != null && leaf.hasDuplicates(key)) {
			//System.out.println("I have duplicates so I entered here");
			done = leaf.deleteOverflow(key, ref);
			//System.out.println("No matching tuple so I will look at main ref");

		}

		if (ref == null) {
		while (this.searchNode(key) != null) {
				boolean done2 = false;
				done = this.deleteL(key, ref);
				done = done2 || done;
			}
		}
		if (ref != null) {
//			boolean done2 = false;
//			done = this.deleteL(key, ref);
//			done = done2 || done;
			done = this.deleteHelper(key, ref);
			//System.out.println("I will delete here now and it should succeed");
		}

		return done;

	}

	public void printingRef(BPTreeLeafNode leaf) {
		if (leaf != null) {
			leaf.print();
		} else {
			System.out.println("null");
		}
	}

	public boolean deleteL(T key, Ref ref) {
		if (root.numberOfKeys == 0) {
			if (root instanceof BPTreeInnerNode)
				root = ((BPTreeInnerNode) root).getFirstChild();
		}
		return root.deleteLeft(key, null, -1, ref);
	}

	public boolean deleteAllRefs(ArrayList<Ref> refs, T key) {
		if (refs == null || refs.size() == 0)
			return false;
		for (int i = 0; i < refs.size(); i++) {
			this.delete(key, refs.get(i));
		}
		return false;
	}

	/**
	 * Returns a string representation of the B+ tree.
	 */
	public String toString() {

		// <For Testing>
		// node : (id)[k1|k2|k3|k4]{P1,P2,P3,}
		String s = "";
		Queue<BPTreeNode<T>> cur = new LinkedList<BPTreeNode<T>>(), next;
		cur.add(root);
		while (!cur.isEmpty()) {
			next = new LinkedList<BPTreeNode<T>>();
			while (!cur.isEmpty()) {
				BPTreeNode<T> curNode = cur.remove();
				System.out.print(curNode);
				if (curNode instanceof BPTreeLeafNode) {
					this.printingRef((BPTreeLeafNode) curNode);
					System.out.print("->");
				} else {
					System.out.print("{");
					BPTreeInnerNode<T> parent = (BPTreeInnerNode<T>) curNode;
					for (int i = 0; i <= parent.numberOfKeys; ++i) {
						System.out.print(parent.getChild(i).index + ",");
						next.add(parent.getChild(i));
					}
					System.out.print("} ");
				}

			}
			System.out.println();
			cur = next;
		}
		// </For Testing>
		return s;
	}
}