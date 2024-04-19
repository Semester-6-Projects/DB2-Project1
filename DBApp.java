import java.io.*;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Random;

import com.opencsv.CSVWriter;

public class DBApp {
    private static Vector<String> tableNames = new Vector<String>();

    public DBApp() {
    }

    public static void main(String[] args) {
        try {
            String strTableName = "Student";
            DBApp dbApp = new DBApp();
            dbApp.init();

            // testing createTable
            Hashtable htblColNameType = new Hashtable();
            htblColNameType.put("id", "java.lang.Integer");
            htblColNameType.put("name", "java.lang.String");
            htblColNameType.put("gpa", "java.lang.Double");
            dbApp.createTable(strTableName, "id", htblColNameType);

            // Testing Creating Indices

//            dbApp.createIndex(strTableName, "id", "idIndex");
//            dbApp.createIndex(strTableName, "gpa", "gpaIndex");
//            dbApp.createIndex(strTableName, "name", "nameIndex");

            // Testing Inserting into Table
            Hashtable htblColNameValue = new Hashtable();
            htblColNameValue.put("gpa", Double.valueOf(0.88));
            htblColNameValue.put("id", Integer.valueOf(333));
            htblColNameValue.put("name", new String("Ahmed Noor2"));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(72));
            htblColNameValue.put("name", new String("amy"));
            htblColNameValue.put("gpa", Double.valueOf(0.96));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            htblColNameValue.put("id", Integer.valueOf(5));
            htblColNameValue.put("name", new String("dalia"));
            htblColNameValue.put("gpa", Integer.valueOf(1));
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
            htblColNameValue.put("name", new String("Zeinar"));
            htblColNameValue.put("gpa", Double.valueOf(0.88));
            dbApp.insertIntoTable(strTableName, htblColNameValue);

            htblColNameValue.clear();
            // Add randomised values
            for (int i = 0; i < 10000; i++) {
                Random rand = new Random();
                htblColNameValue.put("id", rand.nextInt(100000000));
                htblColNameValue.put("name", new String("Name" + i));
                htblColNameValue.put("gpa", rand.nextDouble());
                dbApp.insertIntoTable(strTableName, htblColNameValue);
            }


            Table t = dbApp.deserializeTable(tableNames.get(0));
            for (int i = 0; i < t.getPageCount(); i++) {
                System.out.println(t.deserializePage(t.getPages().get(i).getPageName()));
            }


            SQLTerm[] arrSQLTerms;
            arrSQLTerms = new SQLTerm[3];

            arrSQLTerms[0] = new SQLTerm();
            arrSQLTerms[0]._strTableName = "Student";
            arrSQLTerms[0]._strColumnName = "gpa";
            arrSQLTerms[0]._strOperator = "=";
            arrSQLTerms[0]._objValue = Double.valueOf(0.88);

            arrSQLTerms[1] = new SQLTerm();
            arrSQLTerms[1]._strTableName = "Student";
            arrSQLTerms[1]._strColumnName = "name";
            arrSQLTerms[1]._strOperator = "<=";
            arrSQLTerms[1]._objValue = "Zaky Noor";

            arrSQLTerms[2] = new SQLTerm();
            arrSQLTerms[2]._strTableName = "Student";
            arrSQLTerms[2]._strColumnName = "id";
            arrSQLTerms[2]._strOperator = "=";
            arrSQLTerms[2]._objValue = Integer.valueOf(9);

            String[] strarrOperators = new String[2];
            //strarrOperators[0] = null;
            strarrOperators[0] = "AND";
            strarrOperators[1] = "or";


            // select * from Student where name = "John Noor" or gpa = 1.5;
            Iterator resultSet = dbApp.selectFromTable(arrSQLTerms, strarrOperators);
            System.out.println("Result set:");
            if (resultSet != null) {
                while (resultSet.hasNext()) {
                    System.out.println(resultSet.next());
                }
            } else
                System.out.println("no results");


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
            throw new DBAppException("Table already exists");
        }


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
            throw new DBAppException("Table doesn't exist");
        }
        Table t = deserializeTable(strTableName);
        if (!(t.getColOrder().contains(strColName))) {
            serializeTable(t);
            throw new DBAppException("Column " + strColName + " doesn't exist in table " + strTableName);
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
            throw new DBAppException("Cannot insert into table " + strTableName + ", it doesn't exist");
        }

        Table t = deserializeTable(strTableName);
        if (htblColNameValue.size() != t.getColOrder().size()) {
            serializeTable(t);
            throw new DBAppException("Incorrect number of insertions.Should be " + t.getColOrder().size());
        }
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
                throw new DBAppException("Column " + columnName + " doesn't exist in table " + strTableName);
            }
        }
//        if (t.getColOrder().size() != htblColNameValue.size()) {
//            serializeTable(t);
//            throw new DBAppException("Incorrect number of insertions");
//        }
        Tuple t2 = new Tuple(dataValue);
        if (t.addData(t2)) {
            serializeTable(t);
        } else {
            serializeTable(t);
            throw new DBAppException("Value of primary key (" + t.getClusteringKeyColumn() + ") is already in use");
        }

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
                            throw new DBAppException("Mismatch data type, for column '" + columnName
                                    + "' should be java.lang.Integer");
                        }
                    } else if (c.equalsIgnoreCase("java.lang.Double")) {
                        try {
                            Double d = Double.parseDouble(columnValue);
                            br.close();
                            fr.close();
                            return true;
                        } catch (Exception e) {
                            throw new DBAppException("Mismatch data type, for column '" + columnName
                                    + "' should be java.lang.Double");
                        }
                    } else if (c.equalsIgnoreCase("java.lang.String")) {
                        try {
                            int x = Integer.parseInt(columnValue);

                            br.close();
                            fr.close();
                            throw new DBAppException("Mismatch data type, for column '" + columnName
                                    + "' should be java.lang.String");
                        } catch (DBAppException d) {
                            throw new DBAppException("Mismatch data type, for column '" + columnName
                                    + "' should be java.lang.String");
                        } catch (Exception e) {
                            try {
                                Double d = Double.parseDouble(columnValue);

                                br.close();
                                fr.close();
                                throw new DBAppException("Mismatch data type, for column '" + columnName
                                        + "' should be java.lang.String");
                            } catch (DBAppException d) {
                                throw new DBAppException("Mismatch data type, for column '" + columnName
                                        + "' should be java.lang.String");
                            } catch (Exception ee) {

                                br.close();
                                fr.close();
                                return true;
                            }

                        }
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
            throw new DBAppException("Table doesn't exist");
        } else {
            t = deserializeTable(strTableName);
        }
//        if(t.getPages().size()==0){
//            serializeTable(t);
//            throw new DBAppException("Table is empty");
//        }
        if (htblColNameValue.containsKey(t.getClusteringKeyColumn())) {
            serializeTable(t);
            throw new DBAppException("Cannot update primary key");
        }

        String clusteringKey = t.getClusteringKeyColumn();
        if (checkValueMF(clusteringKey, strClusteringKeyValue, strTableName)) {
            Hashtable<String, Object> htblColNameValue2 = new Hashtable<String, Object>();
            String checkType = Validators.dataType(clusteringKey, strTableName);
            if (checkType.equals("int")) {
                int x = Integer.valueOf(Integer.parseInt(strClusteringKeyValue));
                htblColNameValue2.put(clusteringKey, x);
            } else if (checkType.equals("double")) {
                double y = Double.valueOf(Double.parseDouble(strClusteringKeyValue));
                htblColNameValue2.put(clusteringKey, y);
            } else {
                htblColNameValue2.put(clusteringKey, strClusteringKeyValue);
            }
            Tuple tu = t.getTuple(strClusteringKeyValue);
            if (!(tu.getData().size() > 0)) {
                serializeTable(t);
                throw new DBAppException("Tuple does not exist");
            }
            if (htblColNameValue.size() == 0) {
                serializeTable(t);
                throw new DBAppException("Please select the values to be updated");
            }
            Vector<String> columns = t.getColOrder();
            serializeTable(t);
            deleteFromTable(strTableName, htblColNameValue2);
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

        Table table = new Table();
        if (!(tableNames.contains(strTableName))) {
            throw new DBAppException("Table doesn't exist");
        } else {
            table = deserializeTable(strTableName);
        }
        SQLTerm[] arrSQLTerms;
        if (htblColNameValue.size() == 0) {
            int size = table.getPages().size();
            for (int i = 0; i < size; i++) {
                File f = new File(table.getPages().get(0).getPageName() + ".bin");
                table.getPages().remove(0);
                f.delete();
            }
            for (int i = 0; i < table.getColOrder().size(); i++) {
                String fileName = strTableName + "," + table.getColOrder().get(i) + ".bin";
                File check = new File(fileName);
                if (check.exists()) {
                    File f = new File(fileName);
                    f.delete();
                    table.createIndexHelper(strTableName, table.getColOrder().get(i));
                }

            }
            return;
        }
        arrSQLTerms = new SQLTerm[htblColNameValue.size()];
        // open the hashtable
        String hash = htblColNameValue.toString();
        hash = hash.substring(1, hash.length() - 1);
        String[] hashArr = hash.split(",");
        Vector<Object> dataVec = new Vector<Object>();
        Vector<Object> nameVec = new Vector<Object>();
        for (int i = 0; i < hashArr.length; i++) {
            String[] temp = hashArr[i].split("=");
            String name = temp[0].trim();
            String data = temp[1].trim();
            arrSQLTerms[i] = new SQLTerm();
            arrSQLTerms[i]._strTableName = strTableName;
            arrSQLTerms[i]._strColumnName = name;
            arrSQLTerms[i]._strOperator = "=";
            arrSQLTerms[i]._objValue = data;
        }
        String[] strarrOperators = {null};
        if (!(htblColNameValue.size() - 1 == 0)) {
            strarrOperators = new String[htblColNameValue.size() - 1];
            for (int i = 0; i < strarrOperators.length; i++) {
                strarrOperators[i] = "AND";
            }
        }


        Iterator resultSet = selectFromTable(arrSQLTerms, strarrOperators);
//        if (!resultSet.hasNext()) {
//            serializeTable(table);
//            throw new DBAppException("Tuples not found");
//        }
        if (resultSet != null) {
            //System.out.println(resultSet.hasNext());
            while (resultSet.hasNext()) {
                Tuple tuple = (Tuple) resultSet.next();
                table.deleteData(tuple);
                //System.out.println("pagee");
            }
            serializeTable(table);
        }

    }

    public String[] getColumnRow(String tableName, String columnName) throws DBAppException {
        // This retrieves the row containing the metadata for a column.
        try {
            FileReader fr = new FileReader("resources/metaFile.csv");
            BufferedReader br = new BufferedReader(fr);
            String z = br.readLine();
            while (z != null) {
                String[] mfile = z.split(",");
                String curTableName = mfile[0].substring(1, mfile[0].length() - 1).trim();
                String curColumnName = mfile[1].substring(1, mfile[1].length() - 1).trim();
                if (curTableName.equals(tableName) && curColumnName.equals(columnName)) {
                    String[] columnRow = {mfile[0], mfile[1], mfile[2], mfile[3], mfile[4], mfile[5]};
                    br.close();
                    fr.close();
                    return columnRow;
                }

                z = br.readLine();
            }
            br.close();
            fr.close();
            throw new DBAppException("Column " + columnName + " doesn't exist in table " + tableName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getColumnType(String tableName, String columnName) throws DBAppException {
        // This retrieved the column type from the metadata file.
        // The options are: java.lang.Integer, java.lang.Double, java.lang.String

        String[] columnRow = getColumnRow(tableName, columnName);
        return columnRow[2];
    }

    public boolean hasColumnIndex(String tableName, String columnName) throws DBAppException {
        // This checks if the column has an index on it.
        String[] columnRow = getColumnRow(tableName, columnName);
        String index = columnRow[4].substring(1, columnRow[4].length() - 1);
        return !index.equals("") || index.equals("null") || index.equals("\"\"");
    }

    public boolean canBeCast(String type, Object value) {
        // This checks if the value can be cast to the specified type.
        try {
            // Try to cast the value to the specified type, if it fails, return false, else return true.
            switch (type) {
                case "java.lang.Integer" -> {
                    Integer.parseInt(value + "");
                    break;
                }
                case "java.lang.Double" -> {
                    Double.parseDouble(value + "");
                    break;
                }
                case "java.lang.String" -> {
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Vector<Tuple> getSubResult(SQLTerm arrSQLTerm) throws DBAppException {
        /*
         * This gets the sub-results of a single select operation.
         * It retrieves data depending on if the table has an index on the column or
         * not.
         */

        // Initialize the iterator for the current select operation.
        Vector<Tuple> results = new Vector<Tuple>();
        // Check if the table exists in the database

        if (!Validators.checkTableExistsMF(arrSQLTerm._strTableName)) {
            throw new DBAppException("Table '" + arrSQLTerm._strTableName + "' not found");
        }
        if (!Validators.checkColumnExistsMF(arrSQLTerm._strColumnName, arrSQLTerm._strTableName)) {
            throw new DBAppException("Column'" + arrSQLTerm._strColumnName + "' not found");
        }
        // Check data types with meta data file.
        String columnValue = arrSQLTerm._objValue + "";
        checkValueMF(arrSQLTerm._strColumnName, columnValue, arrSQLTerm._strTableName);

        // Deserialize the table.
        Table t = deserializeTable(arrSQLTerm._strTableName);
//        if(t.getPages().size()==0){
//            serializeTable(t);
//            throw new DBAppException("Table is empty");
//        }

        // Case 1 : A binary tree exists for the column.
        String fileName = arrSQLTerm._strTableName + "," + arrSQLTerm._strColumnName + ".bin";
        File check = new File(fileName);

        if (check.exists() && !(arrSQLTerm._strOperator.equals("!="))) {
            results = t.getSelectDataIndex(arrSQLTerm._strColumnName, arrSQLTerm._strOperator, arrSQLTerm._objValue);
            serializeTable(t);
            return results;
        }

        // Case 2 : A binary tree does not exist for the column.

        /*
         * If the column does not have an index, but it is the clustering key, the data would be sorted, and we can use
         * binary search to find the data. Clustering key is primary key so it is unique.
         */

        if (arrSQLTerm._strColumnName.equals(t.getClusteringKeyColumn())) {
            Tuple tuple = t.getTuple(arrSQLTerm._objValue + "");
            if (tuple.getData().size() > 0) {
                results.add(tuple);
            }
            serializeTable(t);
            return results;
        }


        // Get all the data from the table and iterate through it. (In case it is not the clustering key)
        Vector<Tuple> allRows = t.getAllData();
        for (Tuple tuple : allRows) {
            Object value = tuple.getData().get(t.getColOrder().indexOf(arrSQLTerm._strColumnName));
            String columnType = getColumnType(arrSQLTerm._strTableName, arrSQLTerm._strColumnName);
            if (!canBeCast(columnType, value)) {
                serializeTable(t);
                throw new DBAppException("Data type mismatch");
            }
            //System.out.println(columnType);
            columnType = columnType.substring(1, columnType.length() - 1);


            switch (columnType.toLowerCase()) {
                case "java.lang.integer" -> {
                    arrSQLTerm._objValue = Integer.parseInt(arrSQLTerm._objValue + "");
                    value = Integer.parseInt(value + "");

                    switch (arrSQLTerm._strOperator) {
                        case "=" -> {

                            //value = value + "";
                            if (arrSQLTerm._objValue.equals(value)) {

                                results.add(tuple);
                                break;
                            }
                        }
                        case "!=" -> {
                            if (!arrSQLTerm._objValue.equals(value)) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case ">" -> {
                            if ((int) arrSQLTerm._objValue < (int) value) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case "<" -> {
                            if ((int) arrSQLTerm._objValue > (int) value) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case ">=" -> {
                            if ((int) arrSQLTerm._objValue <= (int) value) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case "<=" -> {
                            if ((int) arrSQLTerm._objValue >= (int) value) {
                                results.add(tuple);
                                break;
                            }
                        }
                        default -> {
                            serializeTable(t);
                            throw new DBAppException("Operator " + arrSQLTerm._strOperator + " not supported");
                        }
                    }
                }
                case "java.lang.double" -> {
                    arrSQLTerm._objValue = Double.parseDouble(arrSQLTerm._objValue + "");
                    value = Double.parseDouble(value + "");

                    switch (arrSQLTerm._strOperator) {
                        case "=" -> {
                            //value = value + "";
                            if (arrSQLTerm._objValue.equals(value)) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case "!=" -> {
                            if (!arrSQLTerm._objValue.equals(value)) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case ">" -> {
                            if ((double) arrSQLTerm._objValue < (int) value) {
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
                        default -> {
                            serializeTable(t);
                            throw new DBAppException("Operator '" + arrSQLTerm._strOperator + "' not supported");
                        }
                    }
                }
                case "java.lang.string" -> {
                    arrSQLTerm._objValue = arrSQLTerm._objValue + "";
                    value = value + "";

                    switch (arrSQLTerm._strOperator) {
                        case "=" -> {
                            //value = value + "";
                            if (arrSQLTerm._objValue.equals(value)) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case "!=" -> {
                            if (!arrSQLTerm._objValue.equals(value)) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case ">" -> {
                            if (arrSQLTerm._objValue.toString().compareTo(value.toString()) < 0) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case "<" -> {
                            if (arrSQLTerm._objValue.toString().compareTo(value.toString()) > 0) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case ">=" -> {
                            if (arrSQLTerm._objValue.toString().compareTo(value.toString()) <= 0) {
                                results.add(tuple);
                                break;
                            }
                        }
                        case "<=" -> {
                            if (arrSQLTerm._objValue.toString().compareTo(value.toString()) >= 0) {
                                results.add(tuple);
                                break;
                            }
                        }
                        default -> {
                            serializeTable(t);
                            throw new DBAppException("Operator '" + arrSQLTerm._strOperator + "' not supported");
                        }

                    }

                }
            }


        }
        serializeTable(t);
        System.out.println("sub results" + results);
        return results;
    }

    public Iterator selectFromTable(SQLTerm[] arrSQLTerms,
                                    String[] strarrOperators) throws DBAppException {

        // Array of Iterators to hold the results of the multiple select operations
        // Each index in the array corresponds to a select operation.
        Vector<Vector> subResults = new Vector<>();
        if (arrSQLTerms.length == 0) {
            throw new DBAppException("please insert terms to be selected");
        }


        // Iterate through the SQLTerms array and select the relevant data.
        for (SQLTerm arrSQLTerm : arrSQLTerms) {
            // Initialize the vector for the current select operation.
            if (arrSQLTerm != null) {
                subResults.add(getSubResult(arrSQLTerm));
            }
        }

        /*
         * Perform the strarr operation on the iterators.
         * Loop through the array of the operators.
         * Each operator will be applied to the previous result and the current
         * iterator.
         */
        Vector<Tuple> tempResult = null;
        if (subResults.size() != 0) {
            // Initialize Temp result vector as the first vector in the subResults array.
            tempResult = subResults.get(0);
            if (strarrOperators[0] == null) {
                //System.out.println(tempResult);
                return tempResult.iterator();
            }
            int i = 1;
            for (String strarrOperator : strarrOperators) {
                // Initialize the result as a vector.
                if (strarrOperator != null) {
                    Vector<Tuple> result = new Vector<Tuple>();
                    if (i == subResults.size()) {
                        throw new DBAppException("Incorrect number of SQLTerms ");
                    }

                    switch (strarrOperator.toUpperCase()) {
                        case "AND" -> tempResult = RecordOperators.andRecords(tempResult, subResults.get(i));
                        case "OR" -> tempResult = RecordOperators.orRecords(tempResult, subResults.get(i));
                        case "XOR" -> tempResult = RecordOperators.xorRecords(tempResult, subResults.get(i));
                        default -> {
                            throw new DBAppException("Operation '" + strarrOperator + "' not supported");
                        }
                    }
                    i++;

                }

            }
            if (i != subResults.size()) {
                throw new DBAppException("Incorrect number of operators");
            }

        }
        // Convert the result vector to an iterator and return it.

        if (tempResult == null) {
            return null;
        }
        return tempResult.iterator();
    }
}