import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import java.io.Serializable;

public class Page implements Serializable {

    Vector<rows> row;
    String filename;
    String filepath;

    public Page(int pageIndex, String tableName) {
        row = new Vector<rows>();
        this.createFile(pageIndex, tableName);

    }


    public String getFilename() {
        return filename;
    }

    public String getPath() {
        return filepath;
    }

    public void createFile(int pageIndex, String tableName) {
        this.filename = tableName + pageIndex + ".class";


        try {
            FileOutputStream fileOut = new FileOutputStream(filename, false);

            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < row.size(); i++)
            s = s + row.get(i).tuples + " , ";

        return s;
    }


}

