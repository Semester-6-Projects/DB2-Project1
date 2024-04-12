import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
