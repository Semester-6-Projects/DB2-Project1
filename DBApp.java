import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.Vector;

public class DBApp {
 private Vector<String> tableNames = new Vector<String>();

	public DBApp() {
	}

	// this does whatever initialization you would like
	// or leave it empty if there is no code you want to
	// execute at application startup
	public void init( ){


	}

	public void createTable(String strTableName,
							String strClusteringKeyColumn,
							Hashtable<String,String> htblColNameType) throws DBAppException{

		 if(!(tableNames.contains(strTableName))) {
			 Table t = new Table(strTableName, strClusteringKeyColumn, htblColNameType);
			 tableNames.add(strTableName);
			 serializeTableCreate(t);
			 return;
		 }
		 else{
			 throw new DBAppException("table already exists");
		 }

		//throw new DBAppException("not implemented yet");
	}


	private void serializeTableCreate(Table t){
		String tableFileName = t.getTableName() + ".bin";
		ObjectOutputStream os = null;
		try {
			FileOutputStream fileOS = new FileOutputStream(tableFileName);
			os = new ObjectOutputStream(fileOS);
			os.writeObject(t);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	private void deserializeTable(Table t){
		String pageName = t.getTableName() + ".bin";
		ObjectInputStream in= null;
		try{
			FileInputStream fileIn = new FileInputStream(pageName);
			in = new ObjectInputStream(fileIn);
			in.readObject();

		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	// following method creates a B+tree index
	public void createIndex(String   strTableName,
							String   strColName,
							String   strIndexName) throws DBAppException{

		//throw new DBAppException("not implemented yet");
	}


	// following method inserts one row only.
	// htblColNameValue must include a value for the primary key
	public void insertIntoTable(String strTableName,
								Hashtable<String,Object>  htblColNameValue) throws DBAppException{

		if(!(tableNames.contains(strTableName))) {
			throw new DBAppException("table doesn't exist");
		}

		String hash = htblColNameValue.toString();
		String hash2 = hash.substring(1, hash.length() - 1);
		String[] hash3 = hash2.split(",");


		for (int i = hash3.length - 1; i >= 0; i--) {
			String[] x = hash3[i].split("=");
			String columnName = x[0].trim();
			String columnValue = x[1].trim();
			if(checkValueMF(columnName,columnValue, strTableName)){
				//hn3ml tuple
			}
			else{
				throw new DBAppException("Column " + columnName + " doesn't exist");
			}


		}
		//throw new DBAppException("not implemented yet");
	}


	private boolean checkValueMF(String columnName, String columnValue, String tableName)throws DBAppException {
		try {
			FileReader fr = new FileReader("resources/metaFile.csv");
			BufferedReader br = new BufferedReader(fr);
			String z = br.readLine();

			while (z != null) {
				String[] mfile = z.split(",");
				String a = mfile[0].substring(1,mfile[0].length()-1).trim();
				String b = mfile[1].substring(1,mfile[1].length()-1).trim();
				String c = mfile[2].substring(1,mfile[2].length()-1).trim();
                if (a.equals(tableName) && b.equals(columnName)) {
					if (c.equalsIgnoreCase("java.lang.Integer")) {
						try {
							int x = Integer.parseInt(columnValue);
							br.close();
							fr.close();
							return true;
						} catch (Exception e) {
							throw new DBAppException("mismatch data type, for column '" + columnName
									+ "' should be java.lang.Integer");
						}
					} else if (c.equalsIgnoreCase("java.lang.Double")) {
						try {
							Double d = Double.parseDouble(columnValue);
							br.close();
							fr.close();
							return true;
						} catch (Exception e) {
							throw new DBAppException("mismatch data type, for column '" + columnName
									+ "' should be java.lang.Double");
						}
					} else if (c.equalsIgnoreCase("java.lang.String")) {
							for(int i = 0; i<columnValue.length(); i++){
								if(((char) (columnValue.charAt(i)) >= '0') && ((char) (columnValue.charAt(i)) <= '9')){
									throw new DBAppException("mismatch data type, for column '" + columnName
											+ "' should be java.lang.String");
								}
                            }
							br.close();
							fr.close();
							return true;
					}
				}
				z = br.readLine();
			}

			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return false;
	}


	// following method updates one row only
	// htblColNameValue holds the key and new value
	// htblColNameValue will not include clustering key as column name
	// strClusteringKeyValue is the value to look for to find the row to update.
	public void updateTable(String strTableName,
							String strClusteringKeyValue,
							Hashtable<String,Object> htblColNameValue   )  throws DBAppException{

		//throw new DBAppException("not implemented yet");
	}


	// following method could be used to delete one or more rows.
	// htblColNameValue holds the key and value. This will be used in search
	// to identify which rows/tuples to delete.
	// htblColNameValue enteries are ANDED together
	public void deleteFromTable(String strTableName,
								Hashtable<String,Object> htblColNameValue) throws DBAppException{

		//throw new DBAppException("not implemented yet");
	}


	public Iterator selectFromTable(SQLTerm[] arrSQLTerms,
									String[]  strarrOperators) throws DBAppException{

		return null;
	}

	public static void main(String[] args) {

	try{
		String strTableName = "Student";
		DBApp	dbApp = new DBApp( );

		Hashtable htblColNameType = new Hashtable( );
		htblColNameType.put("id", "java.lang.Integer");
		htblColNameType.put("name", "java.lang.String");
		htblColNameType.put("gpa", "java.lang.double");
		dbApp.createTable( strTableName, "id", htblColNameType );
		dbApp.createIndex( strTableName, "gpa", "gpaIndex" );

		Hashtable htblColNameValue = new Hashtable( );
		htblColNameValue.put("id", Integer.valueOf( 2343432 ));
		htblColNameValue.put("name", new String("Ahmed Noor" ) );
		htblColNameValue.put("gpa", Double.valueOf( 0.95 ) );
		dbApp.insertIntoTable( strTableName , htblColNameValue );

		htblColNameValue.clear( );
		htblColNameValue.put("id", Integer.valueOf( 453455 ));
		htblColNameValue.put("name", new String("Ahmed Noor" ) );
		htblColNameValue.put("gpa", Double.valueOf( 0.95 ) );
		dbApp.insertIntoTable( strTableName , htblColNameValue );

		htblColNameValue.clear( );
		htblColNameValue.put("id", Integer.valueOf( 5674567 ));
		htblColNameValue.put("name", new String("Dalia Noor" ) );
		htblColNameValue.put("gpa", Double.valueOf( 1.25 ) );
		dbApp.insertIntoTable( strTableName , htblColNameValue );

		htblColNameValue.clear( );
		htblColNameValue.put("id", Integer.valueOf( 23498 ));
		htblColNameValue.put("name", new String("John Noor" ) );
		htblColNameValue.put("gpa", Double.valueOf( 1.5 ) );
		dbApp.insertIntoTable( strTableName , htblColNameValue );

		htblColNameValue.clear( );
		htblColNameValue.put("id", Integer.valueOf( 78452 ));
		htblColNameValue.put("name", new String("Zaky Noor" ) );
		htblColNameValue.put("gpa", Double.valueOf( 0.88 ) );
		dbApp.insertIntoTable( strTableName , htblColNameValue );


//			SQLTerm[] arrSQLTerms;
//			arrSQLTerms = new SQLTerm[2];
//			arrSQLTerms[0]._strTableName =  "Student";
//			arrSQLTerms[0]._strColumnName=  "name";
//			arrSQLTerms[0]._strOperator  =  "=";
//			arrSQLTerms[0]._objValue     =  "John Noor";
//
//			arrSQLTerms[1]._strTableName =  "Student";
//			arrSQLTerms[1]._strColumnName=  "gpa";
//			arrSQLTerms[1]._strOperator  =  "=";
//			arrSQLTerms[1]._objValue     =  Double.valueOf( 1.5 );
//
//			String[]strarrOperators = new String[1];
//			strarrOperators[0] = "OR";
//			// select * from Student where name = "John Noor" or gpa = 1.5;
//			Iterator resultSet = dbApp.selectFromTable(arrSQLTerms , strarrOperators);
		}
		catch(Exception exp){
			exp.printStackTrace( );
		}
	}

}