import java.io.*;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.Vector;
import com.opencsv.CSVWriter;

public class DBApp {
    private Vector<String> tableNames = new Vector<String>();

    public DBApp() {
    }

    public static void main(String[] args) {

        try {
            String strTableName = "Student";
            DBApp dbApp = new DBApp();
            dbApp.init();

            Hashtable htblColNameType = new Hashtable();
            htblColNameType.put("id", "java.lang.Integer");
            htblColNameType.put("name", "java.lang.String");
            htblColNameType.put("gpa", "java.lang.double");
            dbApp.createTable(strTableName, "id", htblColNameType);
            //dbApp.createIndex(strTableName, "id", "idIndex");

            Hashtable htblColNameValue = new Hashtable();
            htblColNameValue.put("gpa", Double.valueOf(0.88));
            htblColNameValue.put("id", Integer.valueOf(3));
            htblColNameValue.put("name", new String("Ahmed Noor"));
            dbApp.insertIntoTable(strTableName, htblColNameValue);
            dbApp.createIndex(strTableName, "gpa", "gpaIndex");
            dbApp.createIndex(strTableName, "name", "nameIndex");

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(7));
            htblColNameValue.put("name", new String("Ahmed Noor"));
            htblColNameValue.put("gpa", Double.valueOf(0.96));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(5));
            htblColNameValue.put("name", new String("Dalia Noor"));
            htblColNameValue.put("gpa", Double.valueOf(1.25));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(2));
            htblColNameValue.put("name", new String("John Noor"));
            htblColNameValue.put("gpa", Double.valueOf(1.5));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(1));
            htblColNameValue.put("name", new String("Zaky Noor"));
            htblColNameValue.put("gpa", Double.valueOf(0.88));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(9));
            htblColNameValue.put("name", new String("Zaky Noor"));
            htblColNameValue.put("gpa", Double.valueOf(0.88));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

//            htblColNameValue.clear();
//            htblColNameValue.put("id", Integer.valueOf(6));
//            htblColNameValue.put("name", new String("Zaky Noor"));
//            htblColNameValue.put("gpa", Double.valueOf(0.88));
//            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("name", new String("Amy"));
            htblColNameValue.put("gpa", new String("0.92"));
            //htblColNameValue.put("id", new String("9"));
            //dbApp.updateTable(strTableName, "1", htblColNameValue);

			SQLTerm[] arrSQLTerms;
			arrSQLTerms = new SQLTerm[2];
            arrSQLTerms[0]=new SQLTerm();
            arrSQLTerms[1]=new SQLTerm();
			arrSQLTerms[0]._strTableName =  "Student";
			arrSQLTerms[0]._strColumnName=  "id";
			arrSQLTerms[0]._strOperator  =  ">";
			arrSQLTerms[0]._objValue     =  Integer.valueOf(6);

			arrSQLTerms[1]._strTableName =  "Student";
			arrSQLTerms[1]._strColumnName=  "gpa";
			arrSQLTerms[1]._strOperator  =  "!=";
			arrSQLTerms[1]._objValue     =  Double.valueOf( 0.88);

			String[]strarrOperators = new String[1];
            //strarrOperators[0] = null;
			strarrOperators[0] = "OR";
			// select * from Student where name = "John Noor" or gpa = 1.5;
			Iterator resultSet = dbApp.selectFromTable(arrSQLTerms , strarrOperators);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private static void writeInCSV(String filePath, String[] hash) {
        try {
            FileWriter outputfile = new FileWriter(filePath, true);
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeNext(hash);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // this does whatever initialization you would like
    // or leave it empty if there is no code you want to
    // execute at application startup
    public void init() {
        FileReader fr = null;
        try {
            createMetaDataFile();
            fr = new FileReader("resources/metaFile.csv");
            BufferedReader br = new BufferedReader(fr);
            String z = br.readLine();
            while (z != null) {
                String[] mfile = z.split(",");
                String a = mfile[0].substring(1, mfile[0].length() - 1).trim();
                if (!(tableNames.contains(a))) {
                    tableNames.add(a);
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
    }

    private void createMetaDataFile() {
        try {
            FileWriter outfile = new FileWriter("resources/metaFile.csv", true);
            CSVWriter writer = new CSVWriter(outfile);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String strTableName,
                            String strClusteringKeyColumn,
                            Hashtable<String, String> htblColNameType) throws DBAppException {
        if (!(tableNames.contains(strTableName))) {
            Table t = new Table(strTableName, strClusteringKeyColumn, htblColNameType);
            tableNames.add(strTableName);
            serializeTable(t);
        } else {
            throw new DBAppException("table already exists");
        }

        //throw new DBAppException("not implemented yet");
    }

    private void serializeTable(Table t) {
        String fileName = t.getTableName() + ".bin";
        File file = new File(fileName);
        ObjectOutputStream os = null;
        try {
            FileOutputStream fileOS = new FileOutputStream(file);
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

    private Table deserializeTable(String tableName) {
        Table t = new Table();
        String fileName = tableName + ".bin";
        ObjectInputStream in = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            in = new ObjectInputStream(fileIn);
            t = (Table) in.readObject();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return t;
    }

    public void createIndex(String strTableName,
                            String strColName,
                            String strIndexName) throws DBAppException {
        if (!(tableNames.contains(strTableName))) {
            throw new DBAppException("table doesn't exist");
        }
        Table t = deserializeTable(strTableName);
        if (!(t.getColOrder().contains(strColName))) {
            serializeTable(t);
            throw new DBAppException("column " + strColName + " doesn't exist");
        } else {
            try {
                FileWriter outfile = new FileWriter("resources/metaFile2.csv", true);
                CSVWriter writer = new CSVWriter(outfile);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileReader fr = new FileReader("resources/metaFile.csv");
                BufferedReader br = new BufferedReader(fr);
                String z = br.readLine();
                while (z != null) {
                    String[] mfile = z.split(",");
                    String a = mfile[0].substring(1, mfile[0].length() - 1).trim();
                    String b = mfile[1].substring(1, mfile[1].length() - 1).trim();
                    String c = mfile[2].substring(1, mfile[2].length() - 1).trim();
                    String d = mfile[3].substring(1, mfile[3].length() - 1).trim();
                    String e = mfile[4].substring(1, mfile[4].length() - 1).trim();
                    String f = mfile[5].substring(1, mfile[5].length() - 1).trim();
                    if (a.equalsIgnoreCase(strTableName) && b.equalsIgnoreCase(strColName)) {
                        String[] y = {strTableName, strColName, c, d, strIndexName, "B+tree"};
                        writeInCSV("resources/metaFile2.csv", y);
                    } else {
                        String[] y = {a, b, c, d, e, f};
                        writeInCSV("resources/metaFile2.csv", y);
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
            File file = new File("resources/metaFile2.csv");
            File rename = new File("resources/metaFile.csv");
            rename.delete();
            file.renameTo(rename);
            t.createIndexHelper(strTableName, strColName);
            serializeTable(t);
        }
    }


    public void insertIntoTable(String strTableName,
                                Hashtable<String, Object> htblColNameValue) throws DBAppException {
        if (!(tableNames.contains(strTableName))) {
            throw new DBAppException("table doesn't exist");
        }
        Table t = deserializeTable(strTableName);
        Vector<Object> dataValue = new Vector<Object>();
        String hash = htblColNameValue.toString();
        String hash2 = hash.substring(1, hash.length() - 1);
        String[] hash3 = hash2.split(",");
        for (int i = hash3.length - 1; i >= 0; i--) {
            String[] x = hash3[i].split("=");
            String columnName = x[0].trim();
            String columnValue = x[1].trim();
            if (checkValueMF(columnName, columnValue, strTableName)) {
                for (int k = 0; k < t.getColOrder().size(); k++) {
                    if (t.getColOrder().get(k).equals(columnName)) {
                        dataValue.add(k, columnValue);
                        break;
                    }
                }
            } else {
                serializeTable(t);
                throw new DBAppException("Column " + columnName + " doesn't exist");
            }
        }
        if (t.getColOrder().size() != htblColNameValue.size()) {
            serializeTable(t);
            throw new DBAppException("Incorrect number of insertions");
        }
        Tuple t2 = new Tuple(dataValue);
        if (t.addData(t2)) {
            serializeTable(t);
        } else {
            serializeTable(t);
            throw new DBAppException("Value of primary key (" + t.getClusteringKeyColumn() + ") is already in use");
        }
        //throw new DBAppException("not implemented yet");
    }

    private boolean checkValueMF(String columnName, String columnValue, String tableName) throws DBAppException {
        try {
            FileReader fr = new FileReader("resources/metaFile.csv");
            BufferedReader br = new BufferedReader(fr);
            String z = br.readLine();

            while (z != null) {
                String[] mfile = z.split(",");
                String a = mfile[0].substring(1, mfile[0].length() - 1).trim();
                String b = mfile[1].substring(1, mfile[1].length() - 1).trim();
                String c = mfile[2].substring(1, mfile[2].length() - 1).trim();
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
                        for (int i = 0; i < columnValue.length(); i++) {
                            if (((char) (columnValue.charAt(i)) >= '0') && ((char) (columnValue.charAt(i)) <= '9')) {
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
                            Hashtable<String, Object> htblColNameValue) throws DBAppException {

        // init the table
        Table t = new Table();
        if (!(tableNames.contains(strTableName))) {
            throw new DBAppException("table doesn't exist");
        } else {
            t = deserializeTable(strTableName);
        }
        if (htblColNameValue.containsKey(t.getClusteringKeyColumn())) {
            serializeTable(t);
            throw new DBAppException("cannot update primary key");
        }

        String clusteringKey = t.getClusteringKeyColumn();
        if (checkValueMF(clusteringKey, strClusteringKeyValue, strTableName)) {
            Hashtable<String, Object> htblColNameValue2 = new Hashtable<String, Object>();
            htblColNameValue2.put(clusteringKey, strClusteringKeyValue);
            Tuple tu = t.getTuple(strClusteringKeyValue);
            if (!(tu.getData().size() > 0)) {
                serializeTable(t);
                throw new DBAppException("row/tuple does not exist");
            }
            Vector<String> columns = t.getColOrder();
            serializeTable(t);
            //deleteFromTable(strTableName, htblColNameValue2);
            Vector<Object> data = tu.getData();
            Vector<Object> colUpdated = new Vector<Object>();
            Hashtable htblnew = new Hashtable();

            String hash = htblColNameValue.toString();
            String hash2 = hash.substring(1, hash.length() - 1);
            String[] hash3 = hash2.split(",");
            for (int i = 0; i < hash3.length; i++) {
                String[] x = hash3[i].split("=");
                String columnName = x[0].trim();
                String columnValue = x[1].trim();
                if (columns.contains(columnName)) {
                    colUpdated.add(columnName);
                    htblnew.put(columnName, columnValue);
                }

            }
            for (int i = 0; i < columns.size(); i++) {
                if (!(colUpdated.contains(columns.get(i)))) {
                    htblnew.put(columns.get(i), data.get(i));
                }
            }

            insertIntoTable(strTableName, htblnew);

            return;
        } else {
            serializeTable(t);
            throw new DBAppException("Column " + clusteringKey + " doesn't exist");
        }


    }

    // following method could be used to delete one or more rows.
    // htblColNameValue holds the key and value. This will be used in search
    // to identify which rows/tuples to delete.
    // htblColNameValue enteries are ANDED together
	public void deleteFromTable(String strTableName,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {
		// init the table
		Table table = new Table(strTableName);

		// open the hashtable
		String hash = htblColNameValue.toString();
		hash = hash.substring(1, hash.length() - 1);
		String[] hashArr = hash.split(",");
		Vector<String> dataVec = new Vector<object>();
		Vector<String> nameVec = new Vector<object>();
		for (int i = 0; i < hashArr.length; i++) {
			String[] temp = hashArr[i].split("=");
			String name = temp[0].trim();
			String data = temp[1].trim();

			// check if the column exists
			if (checkValueMF(name, data, strTableName)) {
				t = deserializeTable(strTableName);
				dataVec.add(data);
				nameVec.add(name);
			} else {
				throw new DBAppException("The column " + name + " does not exist in the table " + strTableName);
			}
		}

		// init a tuple to search for
		Tuple tuple = new Tuple(dataVec);
		
		// delete the tuple
		table.deleteData(tuple);
	}

    public Vector<Tuple> getSubResult(SQLTerm arrSQLTerm) throws DBAppException {
        /*
        This gets the sub-results of a single select operation.
        It retrieves data depending on if the table has an index on the column or not.
         */

        // Initialize the iterator for the current select operation.
        Vector<Tuple> results = new Vector<Tuple>();
        // Check if the table exists in the database.
        Validators.checkTableExistsMF(arrSQLTerm._strTableName);
        Validators.checkColumnExistsMF(arrSQLTerm._strColumnName, arrSQLTerm._strTableName);

        // Deserialize the table.
        Table t = deserializeTable(arrSQLTerm._strTableName);


        // Case 1 : The column doesn't have an index. We perform a linear search and a manual comparison operation on
        // the data, row by row.
        String fileName = arrSQLTerm._strTableName + "," + arrSQLTerm._strColumnName + ".bin";
        File check = new File(fileName);
        if(check.exists() && !(arrSQLTerm._strOperator.equals("!="))){
            results = t.getSelectDataIndex(arrSQLTerm._strColumnName, arrSQLTerm._strOperator, arrSQLTerm._objValue);
            serializeTable(t);
            return results;
        }
        Vector<Tuple> allRows = t.getAllData();
        for (Tuple tuple : allRows) {
            Object value = tuple.getData().get(t.getColOrder().indexOf(arrSQLTerm._strColumnName));
            switch (arrSQLTerm._strOperator) {
                case "=" -> {
                    arrSQLTerm._objValue = arrSQLTerm._objValue + "";
                    value = value + "";
                    if (arrSQLTerm._objValue.equals(value)) {
                        results.add(tuple);
                        break;
                    }
                }
                case "!=" -> {
                    arrSQLTerm._objValue = arrSQLTerm._objValue + "";
                    value = value + "";
                    if (!arrSQLTerm._objValue.equals(value)) {
                        System.out.println("!=");
                        results.add(tuple);
                        break;
                    }
                }
                case ">" -> {
                    if ((double) arrSQLTerm._objValue < (double) value) {
                        results.add(tuple);
                        break;
                    }
                }
                case "<" -> {
                    if ((double) arrSQLTerm._objValue > (double) value) {
                        results.add(tuple);
                        break;
                    }
                }
                case ">=" -> {
                    if ((double) arrSQLTerm._objValue <= (double) value) {
                        results.add(tuple);
                        break;
                    }
                }
                case "<=" -> {
                    if ((double) arrSQLTerm._objValue >= (double) value) {
                        results.add(tuple);
                        break;
                    }
                }
            }

        }
        serializeTable(t);
        return results;
    }

    public Iterator selectFromTable(SQLTerm[] arrSQLTerms,
                                    String[] strarrOperators) throws DBAppException {

        // Array of Iterators to hold the results of the multiple select operations
        // Each index in the array corresponds to a select operation.
        Vector<Vector> subResults = new Vector<>();

        // Iterate through the SQLTerms array and select the relevant data.
        for (SQLTerm arrSQLTerm : arrSQLTerms) {
            // Initialize the vector for the current select operation.
            subResults.add(getSubResult(arrSQLTerm));
        }

        /*
        Perform the strarr operation on the iterators.
        Loop through the array of the operators.
        Each operator will be applied to the previous result and the current iterator.*/

        // Initialize Temp result vector as the first vector in the subResults array.
        Vector<Tuple> tempResult = subResults.get(0);
        if(strarrOperators[0] == null){
            System.out.println(tempResult);
            return null;
        }
        int i = 1;
        for (String strarrOperator : strarrOperators) {
            // Initialize the result as a vector.
            Vector<Tuple> result = new Vector<Tuple>();

            switch (strarrOperator) {
                case "AND" -> tempResult = RecordOperators.andRecords(tempResult, subResults.get(i));
                case "OR" -> tempResult = RecordOperators.orRecords(tempResult, subResults.get(i));
                case "XOR" -> tempResult = RecordOperators.xorRecords(tempResult, subResults.get(i));
            }

        }
        // Convert the result vector to an iterator and return it.
        return tempResult.iterator();
    }
}