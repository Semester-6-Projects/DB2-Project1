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
            dbApp.createIndex(strTableName, "gpa", "gpaIndex");

            Hashtable htblColNameValue = new Hashtable();
            htblColNameValue.put("id", Integer.valueOf(2343432));
            htblColNameValue.put("name", new String("Ahmed Noor"));
            htblColNameValue.put("gpa", Double.valueOf(0.95));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(453455));
            htblColNameValue.put("name", new String("Ahmed Noor"));
            htblColNameValue.put("gpa", Double.valueOf(0.95));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(5674567));
            htblColNameValue.put("name", new String("Dalia Noor"));
            htblColNameValue.put("gpa", Double.valueOf(1.25));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(23498));
            htblColNameValue.put("name", new String("John Noor"));
            htblColNameValue.put("gpa", Double.valueOf(1.5));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(78452));
            htblColNameValue.put("name", new String("Zaky Noor"));
            htblColNameValue.put("gpa", Double.valueOf(0.88));
            dbApp.insertIntoTable(strTableName, htblColNameValue);


			/*SQLTerm[] arrSQLTerms;
			arrSQLTerms = new SQLTerm[2];
			arrSQLTerms[0]._strTableName =  "Student";
			arrSQLTerms[0]._strColumnName=  "name";
			arrSQLTerms[0]._strOperator  =  "=";
			arrSQLTerms[0]._objValue     =  "John Noor";

			arrSQLTerms[1]._strTableName =  "Student";
			arrSQLTerms[1]._strColumnName=  "gpa";
			arrSQLTerms[1]._strOperator  =  "=";
			arrSQLTerms[1]._objValue     =  Double.valueOf( 1.5 );

			String[]strarrOperators = new String[1];
			strarrOperators[0] = "OR";
			// select * from Student where name = "John Noor" or gpa = 1.5;
			Iterator resultSet = dbApp.selectFromTable(arrSQLTerms , strarrOperators);*/
        } catch (Exception exp) {
            exp.printStackTrace();
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
            FileOutputStream fileOS = new FileOutputStream(file, true);
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

    // following method creates a B+tree index
    public void createIndex(String strTableName,
                            String strColName,
                            String strIndexName) throws DBAppException {

        //throw new DBAppException("not implemented yet");
    }

    public void insertIntoTable(String strTableName,
                                Hashtable<String, Object> htblColNameValue) throws DBAppException {
        if (!(tableNames.contains(strTableName))) {
            throw new DBAppException("table doesn't exist");
        }
        Table t = new Table();
        Vector<Object> dataValue = new Vector<Object>();
        Vector<Object> dataName = new Vector<Object>();
        String hash = htblColNameValue.toString();
        String hash2 = hash.substring(1, hash.length() - 1);
        String[] hash3 = hash2.split(",");
        for (int i = hash3.length - 1; i >= 0; i--) {
            String[] x = hash3[i].split("=");
            String columnName = x[0].trim();
            String columnValue = x[1].trim();
            if (checkValueMF(columnName, columnValue, strTableName)) {
                t = deserializeTable(strTableName);
                dataName.add(columnName);
                dataValue.add(columnValue);
            } else {
                serializeTable(t);
                throw new DBAppException("Column " + columnName + " doesn't exist");
            }
        }
        if (t.getColOrder().size() != htblColNameValue.size()) {
            serializeTable(t);
            throw new DBAppException("Incorrect number of insertions");
        }
        for (int j = 0; j < dataName.size(); j++) {
            if (!(dataName.get(j).equals(t.getColOrder().get(j)))) {
                serializeTable(t);
                throw new DBAppException("Incorrect order of insertions");
            }
        }
        Tuple t2 = new Tuple(dataValue);
        t.addData(t2);
        serializeTable(t);
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

        //throw new DBAppException("not implemented yet");
    }

    // following method could be used to delete one or more rows.
    // htblColNameValue holds the key and value. This will be used in search
    // to identify which rows/tuples to delete.
    // htblColNameValue enteries are ANDED together
    public void deleteFromTable(String strTableName,
                                Hashtable<String, Object> htblColNameValue) throws DBAppException {

        //throw new DBAppException("not implemented yet");
    }

    public Iterator selectFromTable(SQLTerm[] arrSQLTerms,
                                    String[] strarrOperators) throws DBAppException {

        // Array of Iterators to hold the results of the multiple select operations
        // Each index in the array corresponds to a select operation.
        Vector<Iterator> iterators = new Vector<Iterator>();

        // Iterate through the SQLTerms array and select the relevant data.
        for (SQLTerm arrSQLTerm : arrSQLTerms) {
            // Initialize the iterator for the current select operation.
            Iterator<Tuple> results = null;
            // Check if the table exists in the database.
            if (!(tableNames.contains(arrSQLTerm._strTableName))) {
                throw new DBAppException("table doesn't exist");
            }

            // Deserialize the table.
            Table t = deserializeTable(arrSQLTerm._strTableName);

            // TODO: Check if the column exists in the metafile.
            // Currently checks if the column exists in the table.
            if (!(t.getColOrder().contains(arrSQLTerm._strColumnName))) {
                throw new DBAppException("Column " + arrSQLTerm._strColumnName + " doesn't exist");
            }

            // Get table data
            Vector<Tuple> tuples = t.getAllData();

            // Perform the select operation linearly.
            Iterator<Tuple> it = tuples.iterator();
            while (it.hasNext()) {
                Tuple tuple = it.next();

                // Get the relevant Value from the tuple
                // TODO: Check if the column exists in the metafile.
                // TODO: Check the column data type and cast the value accordingly.
                // TODO:
                Object value = tuple.getData().get(t.getColOrder().indexOf(arrSQLTerm._strColumnName));

                switch (arrSQLTerm._strOperator) {
                    case "=" -> {
                        if (arrSQLTerm._objValue.equals(value)) {
                            results = it;
                        }
                    }
                    case "!=" -> {
                        if (!arrSQLTerm._objValue.equals(value)) {
                            results = it;
                        }
                    }
                    case ">" -> {
                        if ((int) arrSQLTerm._objValue < (double) value) {
                            results = it;
                        }
                    }
                    case "<" -> {
                        if ((double) arrSQLTerm._objValue > (double) value) {
                            results = it;
                        }
                    }
                    case ">=" -> {
                        if ((double) arrSQLTerm._objValue <= (double) value) {
                            results = it;
                        }
                    }
                    case "<=" -> {
                        if ((double) arrSQLTerm._objValue >= (double) value) {
                            results = it;
                        }
                    }
                }
            }
            // Add the iterator to the array of iterators.
            iterators.add(results);


        }

        // Perform the strarr operation on the iterators.


        return null;
    }


}