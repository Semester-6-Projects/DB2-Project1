import java.awt.Polygon;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class rows implements Serializable {
    Vector tuples;

    public rows() {
        tuples = new Vector();
    }

    public static void main(String[] args) {
        
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        rows other = (rows) obj;
        if (tuples == null) {
            if (other.tuples != null)
                return false;

        }
        if (this.tuples.size() != other.tuples.size())
            return false;

        else if (this.tuples.size() == other.tuples.size()) {

            for (int i = 0; i < this.tuples.size(); i++) {
                Comparable key1;
                Comparable key2;

                String type = this.tuples.get(i).getClass().getName();

                if (type.equals("java.awt.Polygon")) {
                    polygonComparable p1 = new polygonComparable();
                    Polygon poly1 = (Polygon) this.tuples.get(i);
                    p1.setPoly(poly1);
                    key1 = (Comparable) p1;

                    polygonComparable p2 = new polygonComparable();
                    Polygon poly2 = (Polygon) other.tuples.get(i);
                    p2.setPoly(poly2);
                    key2 = (Comparable) p2;

                } else {
                    key1 = (Comparable) this.tuples.get(i);
                    key2 = (Comparable) other.tuples.get(i);
                }

                if (key1.compareTo(key2) != 0)
                    return false;

            }

        }

        return true;
    }

}