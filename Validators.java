import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.util.Arrays;
import java.util.List;


public class Validators {
    public static boolean checkTableExistsMF(String tableName) throws DBAppException {
        // Check if a table with the table name exists in the database by checking for it in the metafile.
        try {
            FileReader fr = new FileReader("resources/metaFile.csv");
            BufferedReader br = new BufferedReader(fr);
            String z = br.readLine();
            while (z != null) {
                String[] mFile = z.split(",");
                String a = mFile[0].substring(1, mFile[0].length() - 1).trim();
                if (a.equals(tableName)) {
                    br.close();
                    fr.close();
                    return true;
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

    public static boolean checkColumnExistsMF(String columnName, String tableName) throws DBAppException {
        // Check if a column with the column name exists in the database by checking for it in the metafile.
        // The column has to belong to the table.
        try {
            FileReader fr = new FileReader("resources/metaFile.csv");
            BufferedReader br = new BufferedReader(fr);
            String z = br.readLine();
            while (z != null) {
                String[] mFile = z.split(",");
                String a = mFile[0].substring(1, mFile[0].length() - 1).trim();
                String b = mFile[1].substring(1, mFile[1].length() - 1).trim();
                if (a.equals(tableName) && b.equals(columnName)) {
                    br.close();
                    fr.close();
                    return true;
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


    private void generalExcCheck(String tablename, String key, String keyType) throws DBAppException {
        Boolean keyattr = false;
        Boolean table = false;
        int i = 0;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("resources/metaFile.csv"));
            String ln = br.readLine();

            while (ln != null) {
                String[] a = ln.split(",");
                if (a[0].equals(tablename)) {
                    table = true;
                    i++;
                    if (a[1].equals(key)) {
                        keyattr = true;
                        if (!(keyType.equals(a[2]))) {
                            DBAppException exc = new DBAppException(key + " should be of type: "
                                    + a[2]);
                            throw exc;
                        }
                    }

                }

                ln = br.readLine();

            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!(table)) {
            DBAppException exc = new DBAppException(
                    "Table can't be found");
            throw exc;
        }
        if (!(keyattr)) {
            DBAppException exc = new DBAppException(
                    "There's no attribute in table" + tablename + " with the name" + key);
            throw exc;
        }

    }

    private void allowedKeyType(Hashtable<String, String> htblColNameType) throws DBAppException {
        Set<String> keys = htblColNameType.keySet();
        List<String> datatypes = Arrays.asList("java.lang.Integer", "java.lang.Double", "java.lang.String");
        int i = 0;
        for (String key : keys) {
            if (!(datatypes.contains((htblColNameType.get(key)))))
                throw new DBAppException("The type of the key is invalid. It has be either Integer or Double or String");
        }
    }
    private void allowedOps(String op) throws DBAppException {

        List<String> operators = Arrays.asList(">",">=","<","<=","!=","=");

        if (!(operators.contains(op)))
            throw new DBAppException(
                    "The operator has to be one of the following: >, >=, <, <=, != , =");

    }

    private void allowedSTROps(String strOp) throws DBAppException {

        List<String> operators = Arrays.asList("AND", "OR", "XOR");

        if (!(operators.contains(strOp.toUpperCase())))
            throw new DBAppException(
                    "The operator has to be one of the following: AND, OR, XOR");

    }

    private int numOfCols(String tablename) throws DBAppException {
        int i = 0;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("resources/metaFile.csv"));
            String ln = br.readLine();
            while (ln != null) {
                String[] a = ln.split(",");
                if (a[0].equals(tablename))
                    i++;

                ln = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return i;

    }


    private void checkTableName(String tablename) throws DBAppException {
        Boolean flag = false;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("resources/metaFile.csv"));
            String ln = br.readLine();
            while (ln != null) {
                String[] a = ln.split(",");
                if (a[0].equals(tablename))
                    flag = true;

                ln = br.readLine();

            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (flag) {
            DBAppException exc = new DBAppException(
                    "Table already exists");
            throw exc;
        }

    }
}
