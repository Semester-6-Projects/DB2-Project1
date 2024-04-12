import java.util.Vector;

public class RecordOperators {

    private static boolean recordExists(Vector<Tuple> records, Tuple record) {
        // Check if a record exists in a record vector.
        for (Tuple r : records) {
            if (r.compareTo(record)) {
                return true;
            }
        }
        return false;
    }

    public static Vector<Tuple> xorRecords(Vector<Tuple> records1, Vector<Tuple> records2) {
        // Return the XOR of two record vectors.
        Vector<Tuple> xorRecords = new Vector<Tuple>();

        // Add records that are in records1 but not in records2, and vice versa.
        for (Tuple record1 : records1) {
            if (!recordExists(records2, record1)) {
                xorRecords.add(record1);
            }
        }
        for (Tuple record2 : records2) {
            if (!recordExists(records1, record2)) {
                xorRecords.add(record2);
            }
        }
        return xorRecords;
    }

    public static Vector<Tuple> andRecords(Vector<Tuple> records1, Vector<Tuple> records2) {
        // Return the AND of two record vectors.
        Vector<Tuple> andRecords = new Vector<Tuple>();
        for (Tuple record1 : records1) {
            if (recordExists(records2, record1)) {
                andRecords.add(record1);
            }
        }
        return andRecords;
    }

    public static Vector<Tuple> orRecords(Vector<Tuple> records1, Vector<Tuple> records2) {
        // Return the OR of two record vectors.
        Vector<Tuple> orRecords = new Vector<Tuple>(records1);
        for (Tuple record2 : records2) {
            boolean found = recordExists(records1, record2);
            if (!found) {
                orRecords.add(record2);
            }
        }
        return orRecords;
    }
}
