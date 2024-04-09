import java.util.Vector;
import java.io.Serializable;

public class Page implements Serializable {
    private String pageName = "";
    private Vector<Tuple> tuples = new Vector<Tuple>();

    public Page() {

    }

    public Page(String pageName, Tuple data) {
        this.pageName = pageName;
        tuples.add(data);
    }

    public int tupleSize() {
        return tuples.size();
    }

    public String getPageName() {
        return pageName;
    }

    public void addData(Tuple data, int index) {

        tuples.add(index,data);
    }

    public boolean removeData(Tuple data) {
        try {
            tuples.remove(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean searchData(Tuple data) {
        return tuples.contains(data);
    }

    public Vector<Tuple> getTuples() {
        return tuples;
    }

    public String toString() {
        String x = "";
        for (int i = 0; i < tuples.size() - 1; i++) {
            x = x + tuples.get(i).toString() + ", " + "\n";
        }
        x = x + tuples.get(tuples.size() - 1) + "\n" + "\n";
        return x;
    }
}
