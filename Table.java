import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import com.opencsv.CSVWriter;

public class Table implements Serializable {
    private String TableName = "";
    private String ClusteringKeyColumn;
    private int pageCount;
    private Vector<PageInfo> Pages = new Vector<PageInfo>();
    private Vector<String> colOrder = new Vector<String>();

    public Table() {

    }

    public Table(String strTableName,
                 String strClusteringKeyColumn,
                 Hashtable<String, String> htblColNameType) throws DBAppException{
        if(htblColNameType.size()==0){
            throw new DBAppException("Please insert the columns and their types");
        }
        this.TableName = strTableName;
        this.ClusteringKeyColumn = strClusteringKeyColumn;
        String hash = htblColNameType.toString();
        String hash2 = hash.substring(1, hash.length() - 1);
        String[] hash3 = hash2.split(",");
        for (int i = hash3.length - 1; i >= 0; i--) {
            String[] x = hash3[i].split("=");
            String xtrimmed = x[0].trim();
            if(colOrder.contains(xtrimmed)) {
                throw new DBAppException("Can not have 2 columns with the same name");
            }
            else{
                colOrder.add(xtrimmed);
                if (x[1].equalsIgnoreCase("java.lang.Integer") || x[1].equalsIgnoreCase("java.lang.Double")
                        || x[1].equalsIgnoreCase("java.lang.String")) {
                    if (xtrimmed.equals(strClusteringKeyColumn)) {
                        String[] y = {strTableName, xtrimmed, x[1], "True", "null", "null"};
                        writeDataLineByLine("resources/metaFile.csv", y);
                    } else {
                        String[] y = {strTableName, xtrimmed, x[1], "False", "null", "null"};
                        writeDataLineByLine("resources/metaFile.csv", y);
                    }
                } else {
                    throw new DBAppException("cannot create a column with type " + x[1]);
                }
            }

        }
    }

    private static void writeDataLineByLine(String filePath, String[] hash) {
        try {
            FileWriter outputfile = new FileWriter(filePath, true);
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeNext(hash);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTableName() {
        return this.TableName;
    }

    public Vector<String> getColOrder() {
        return this.colOrder;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public Vector<PageInfo> getPages() {
        return this.Pages;
    }

    public String getClusteringKeyColumn() {
        return this.ClusteringKeyColumn;
    }

    private int getMax() {
        int x;
        try {
            FileReader fr = new FileReader("resources/DBApp.config");
            BufferedReader br = new BufferedReader(fr);
            String z = br.readLine();
            String[] y = z.split("=");
            z = y[1].trim();
            x = Integer.parseInt(z);
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return x;
    }

    public void createIndexHelper(String tableName, String columnName) {
        int index = colOrder.indexOf(columnName);
        BPTree tree = new BPTree(2);
        tree.setFileName(tableName, columnName);
        tree.createFile(tree.getFileName());
        for (int i = 0; i < Pages.size(); i++) {
            Page p = deserializePage(Pages.get(i).getPageName());
            Vector<Tuple> tuples = p.getTuples();
            for (int j = 0; j < p.tupleSize(); j++) {
                Tuple tuple = tuples.get(j);
                Ref reference = new Ref(p.getPageName(), j);
                tree.insert((Comparable) tuple.getData().get(index), reference);
            }
            serializePage(p);
        }
        serializeTree(tree);
    }

    private void serializeTree(BPTree t) {
        String treeName = t.getFileName();
        File file = new File(treeName);
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

    private BPTree deserializeTree(String treeName) {
        BPTree t = new BPTree(2);
        String fileName = treeName;
        ObjectInputStream in = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            in = new ObjectInputStream(fileIn);
            t = (BPTree) in.readObject();

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

    private String binarySearch(Vector<PageInfo> pageInfos, int start, int end, Object value) {
        if (end >= start) {
            int mid = (end + start) / 2;

            // If the element is present at the middle itself
            PageInfo w = pageInfos.get(mid);
            if (((Comparable) value).compareTo((Comparable) w.getMin()) >= 0
                    && ((Comparable) value).compareTo((Comparable) w.getMax()) <= 0) {
                return w.getPageName();
            }
            // If element is smaller than mid, then it can only be present in right subarray
            if (((Comparable) value).compareTo((Comparable) w.getMax()) > 0)
                return binarySearch(pageInfos, mid + 1, end, value);

            // Else the element can only be present in left subarray
            return binarySearch(pageInfos, start, mid - 1, value);
        } else if (((Comparable) pageInfos.firstElement().getMin()).compareTo((Comparable) value) > 0) {
            return pageInfos.firstElement().getPageName();
        } else {
            return pageInfos.lastElement().getPageName();
        }

    }
    private Tuple correctTuple (Tuple data){
        Tuple data2 = new Tuple();
        for (int i = 0; i < data.getData().size(); i++) {
            String type = Validators.dataType(colOrder.get(i),TableName);
            String value = data.getData().get(i) +"";
            if(type.equals("int")){
                int x = Integer.parseInt(value);
                data2.getData().add(x);
            }
            else if(type.equals("double")){
                double x = Double.parseDouble(value);
                data2.getData().add(x);
            }
            else {
                data2.getData().add(value);
            }

        }
        return data2;
    }

    public boolean addData(Tuple data2)  {
        Tuple data = correctTuple(data2);
        int max = getMax();
        //int max = 2;
        String fileName = TableName + "," + ClusteringKeyColumn + ".bin";
        File check = new File(fileName);
        if (Pages.size() == 0) {
            pageCount++;
            String pageName = TableName + (Pages.size() + 1);
            Page p = new Page(pageName, data);
            addInBTreeHelper(p, 0, data, 1);
            PageInfo pi = new PageInfo(pageName, data.getData().get(colOrder.indexOf(ClusteringKeyColumn)),
                    data.getData().get(colOrder.indexOf(ClusteringKeyColumn)));
            Pages.add(pi);
            // System.out.print(p.toString());
            serializePage(p);
            return true;
        } else if (check.exists()) {
            BPTree tree = deserializeTree(fileName);
            int index = colOrder.indexOf(ClusteringKeyColumn);
            BPTreeLeafNode r = tree.searchGreaterthan((Comparable) data.getData().get(index));
            if (tree.search((Comparable) data.getData().get(index)) != null) {
                serializeTree(tree);
                return false;
            } else {
                serializeTree(tree);
                addWithIndex(data, r);
                return true;
            }
        } else {
            int index = colOrder.indexOf(ClusteringKeyColumn);
            Object value = data.getData().get(index);
            String type = Validators.dataType(ClusteringKeyColumn,TableName);
            String name = binarySearch(Pages, 0, Pages.size() - 1, value);
            Page p = deserializePage(name);
            Vector<Tuple> tuples = p.getTuples();
            for (int j = 0; j < tuples.size(); j++) {
                Tuple a = tuples.get(j);
                String b =  data.getData().get(index) + ""; // value to be inserted
                String c =  a.getData().get(index) + ""; // value in page
                if (checkEqual(b,c,type)) {
                    serializePage(p);
                    return false;
                }
                if (checkLessThan(b,c,type)) {
                    if (tuples.size() < max) {
                        p.addData(data, j);
                        addInBTreeHelper(p, j, data, 2);
                        // System.out.print(p.toString());
                        for (int i = 0; i < Pages.size(); i++) {
                            if (name.equals(Pages.get(i).getPageName())) {
                                Pages.get(i).setMin(tuples.firstElement().getData().get(index));
                                Pages.get(i).setMax(tuples.lastElement().getData().get(index));
                            }
                        }
                        serializePage(p);
                        return true;
                    } else if (tuples.size() == max) {
                        Tuple shift = tuples.lastElement();
                        p.addData(data, j);
                        addInBTreeHelper(p, j, data, 3);
                        p.removeData(shift);
                        // System.out.print(p.toString());
                        for (int i = 0; i < Pages.size(); i++) {
                            if (name.equals(Pages.get(i).getPageName())) {
                                Pages.get(i).setMin(tuples.firstElement().getData().get(index));
                                Pages.get(i).setMax(tuples.lastElement().getData().get(index));
                            }
                        }
                        serializePage(p);
                        addData(shift);
                        return true;
                    }
                } else if (Pages.lastElement().getPageName().equals(name)) {
                    if (j == tuples.size() - 1) {
                        if (tuples.size() == max) {
                            pageCount++;
                            String pageName = TableName + (Pages.size() + 1);
                            Page x = new Page(pageName, data);
                            PageInfo pi = new PageInfo(pageName,
                                    data.getData().get(colOrder.indexOf(ClusteringKeyColumn)),
                                    data.getData().get(colOrder.indexOf(ClusteringKeyColumn)));
                            Pages.add(pi);
                            addInBTreeHelper(x, 0, data, 1);
                            // System.out.println(p.toString());
                            // System.out.println(x.toString());
                            serializePage(x);
                            serializePage(p);
                            return true;
                        } else {
                            p.addData(data, j + 1);
                            addInBTreeHelper(p, j + 1, data, 1);
                            // System.out.print(p.toString());
                            Pages.lastElement().setMin(tuples.firstElement().getData().get(index));
                            Pages.lastElement().setMax(tuples.lastElement().getData().get(index));
                            serializePage(p);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkEqual (String b, String c, String type){
        if(type.equals("int")){
            int x = Integer.parseInt(b);
            int y = Integer.parseInt(c);
            if (x==y){
                return true;
            }
            else {
                return false;
            }
        }
        else if(type.equals("double")){
            double x = Double.parseDouble(b);
            double y = Double.parseDouble(c);
            if (x==y){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if (b.equals(c))
            {
            return true;
            }
        else {
                return false;
            }
        }
    }

    private boolean checkLessThan (String b, String c, String type){
        if(type.equals("int")){
            int x = Integer.parseInt(b);
            int y = Integer.parseInt(c);
            if (x<y){
                return true;
            }
            else {
                return false;
            }
        }
        else if(type.equals("double")){
            double x = Double.parseDouble(b);
            double y = Double.parseDouble(c);
            if (x<y){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if (b.compareTo(c)<0)
            {
                return true;
            }
            else {
                return false;
            }
        }
    }



    public void addWithIndex(Tuple data, BPTreeLeafNode node) {
        int max = getMax();
        //int max = 2;
        if (node == null) {
            Page p = deserializePage(Pages.lastElement().getPageName());
            int index = colOrder.indexOf(ClusteringKeyColumn);
            Vector<Tuple> tuples = p.getTuples();
            if (tuples.size() == max) {
                pageCount++;
                String pageName = TableName + (Pages.size() + 1);
                Page x = new Page(pageName, data);
                PageInfo pi = new PageInfo(pageName, data.getData().get(index), data.getData().get(index));
                Pages.add(pi);
                addInBTreeHelper(x, 0, data, 1);
                // System.out.println(p.toString());
                // System.out.println(x.toString());
                serializePage(x);
                serializePage(p);
                return;
            } else {
                p.addData(data, tuples.size());
                addInBTreeHelper(p, tuples.size() - 1, data, 1);
                // System.out.print(p.toString());
                Pages.lastElement().setMin(tuples.firstElement().getData().get(index));
                Pages.lastElement().setMax(tuples.lastElement().getData().get(index));
                serializePage(p);
                return;
            }
        } else {
            // System.out.println(node);
            int colIndex = colOrder.indexOf(ClusteringKeyColumn);
            Ref yy = null;
            // System.out.println(node.getRecords().length);
            for (int i = node.getRecords().length - 1; i >= 0; i--) {
                if (node.getKey(i) != null) {
                    if (((Comparable) node.getKey(i)).compareTo(data.getData().get(colIndex)) > 0) {
                        yy = node.getRecords()[i];
                    }
                }
            }
            Ref r = yy;
            Page p = deserializePage(r.getFileName());
            int index = r.getIndexInPage();
            // System.out.println("index: " + index);
            Vector<Tuple> tuples = p.getTuples();
            if (tuples.size() < max) {
                p.addData(data, index);
                addInBTreeHelper(p, index, data, 2);
                // System.out.print(p.toString());
                for (int i = 0; i < Pages.size(); i++) {
                    if (r.getFileName().equals(Pages.get(i).getPageName())) {
                        Pages.get(i).setMin(tuples.firstElement().getData().get(colIndex));
                        Pages.get(i).setMax(tuples.lastElement().getData().get(colIndex));
                    }
                }
                serializePage(p);
                return;
            } else if (tuples.size() == max) {
                Tuple shift = tuples.lastElement();
                p.addData(data, index);
                addInBTreeHelper(p, index, data, 3);
                p.removeData(shift);
                // System.out.print(p.toString());
                for (int i = 0; i < Pages.size(); i++) {
                    if (r.getFileName().equals(Pages.get(i).getPageName())) {
                        Pages.get(i).setMin(tuples.firstElement().getData().get(index));
                        Pages.get(i).setMax(tuples.lastElement().getData().get(index));
                    }
                }
                serializePage(p);
                addData(shift);
                return;
            } else if (Pages.lastElement().getPageName().equalsIgnoreCase(p.getPageName())) {
                if (index == tuples.size() - 1) {
                    if (tuples.size() == max) {
                        pageCount++;
                        String pageName = TableName + (Pages.size() + 1);
                        Page x = new Page(pageName, data);
                        PageInfo pi = new PageInfo(pageName, data.getData().get(colOrder.indexOf(ClusteringKeyColumn)),
                                data.getData().get(colOrder.indexOf(ClusteringKeyColumn)));
                        Pages.add(pi);
                        addInBTreeHelper(x, 0, data, 1);
                        // System.out.println(p.toString());
                        // System.out.println(x.toString());
                        serializePage(x);
                        serializePage(p);
                        return;
                    } else {
                        p.addData(data, index + 1);
                        addInBTreeHelper(p, index + 1, data, 1);
                        // System.out.print(p.toString());
                        Pages.lastElement().setMin(tuples.firstElement().getData().get(index));
                        Pages.lastElement().setMax(tuples.lastElement().getData().get(index));
                        serializePage(p);
                        return;
                    }
                }
            }
        }

    }

    private void addInBTreeHelper(Page p, int startIndex, Tuple data, int flag) {
        Vector<Tuple> tuples = p.getTuples();
        for (int i = 0; i < colOrder.size(); i++) {
            String fileName = TableName + "," + colOrder.get(i) + ".bin";
            File check = new File(fileName);
            if (check.exists()) {
                BPTree tree = deserializeTree(fileName);
                if (flag == 1) {
                    Ref reference = new Ref(p.getPageName(), startIndex);
                    tree.insert((Comparable) data.getData().get(i), reference);
                    serializeTree(tree);
                } else {
                    if ((flag == 3) || flag == 2) {
                        Ref refOld = new Ref(p.getPageName(), tuples.indexOf(tuples.lastElement()) - 1);
                        tree.delete((Comparable) tuples.lastElement().getData().get(i), refOld);
                    }
                    for (int j = startIndex; j < p.getTuples().size() - 1; j++) {
                        if (!(flag == 3 && j == p.getTuples().size() - 2)) {
                            Ref refOld = new Ref(p.getPageName(), j);
                            Ref refNew = new Ref(p.getPageName(), j + 1);
                            tree.update((Comparable) tuples.get(j + 1).getData().get(i),
                                    (Comparable) tuples.get(j + 1).getData().get(i), refNew, refOld);
                        }
                    }

                    Ref reference = new Ref(p.getPageName(), startIndex);
                    tree.insert((Comparable) data.getData().get(i), reference);
                    serializeTree(tree);
                }
            }
        }
    }

    public void deleteData(Tuple data) throws DBAppException {
        // get the bptree
        int index = colOrder.indexOf(ClusteringKeyColumn);
        String fileName = TableName + "," + ClusteringKeyColumn + ".bin";
        File check = new File(fileName);
        if (check.exists()) {
            BPTree tree = deserializeTree(fileName);
            Ref r = tree.search((Comparable) data.getData().get(index));
            serializeTree(tree);
            if (r != null) {
                Page p = deserializePage(r.getFileName());
                boolean deleted = p.removeDataIndex(r.getIndexInPage());
                if (deleted) {
                    Vector<Tuple> tuples = p.getTuples();
                    // serialise the page after deleting from it
                    //serializePage(p);

                    // delete the reference of that page from the tree
                    //tree.delete((Comparable) data.getData().get(index), r);

                    //deleting the data from all trees if they exist
                    for (int i = 0; i < colOrder.size(); i++) {
                        String treeCheck = colOrder.get(i);
                        String fName = TableName + "," + treeCheck + ".bin";
                        File tCheck = new File(fName);
                        if (tCheck.exists()) {
                            BPTree tt = deserializeTree(fName);
                            tt.delete((Comparable) data.getData().get(i), r);

                            for (int j = r.getIndexInPage(); j < p.getTuples().size(); j++) {
                                Ref refOld = new Ref(r.getFileName(), j + 1);
                                Ref refNew = new Ref(p.getPageName(), j);
                                tt.update((Comparable) tuples.get(j).getData().get(i),
                                        (Comparable) tuples.get(j).getData().get(i), refNew, refOld);
                            }
                            serializeTree(tt);
                        }
                    }

                    // loop over all the pages
                    for (int i = 0; i < Pages.size(); i++) {
                        // check if the page is the one we just deleted from
                        if (r.getFileName().equals(Pages.get(i).getPageName())) {
                            // load the page info
                            PageInfo pi = Pages.get(i);

                            // check if the page is empty
                            if (p.tupleSize() == 0) {
                                // remove the page from the pages list
                                Pages.remove(i);

                                // delete the page from the disk
                                serializePage(p);
                                File f = new File(r.getFileName() + ".bin");
                                f.delete();

                                // break the loop because we deleted the page
                                break;
                            }

                            // deserialize the page again to update the min and max
                            //Page page = deserializePage(r.getFileName());

                            // set the min and max of the page info
                            pi.setMin(p.getTuples().get(0).getData().get(index));
                            pi.setMax(p.getTuples().get(p.tupleSize() - 1).getData().get(index));

                            // finally, serialize the page
                            serializePage(p);
                        }
                    }

                    // serialise the tree after deleting from it
                    //serializeTree(tree);
                }
            }

        } else {
            // if tree not found then search linearly
            Object value = data.getData().get(index);
            String name = binarySearch(Pages, 0, Pages.size() - 1, value);
            Page p = deserializePage(name);
            Vector<Tuple> tuples = p.getTuples();
            for (int i = 0; i < tuples.size(); i++) {
                value = value + "";
                String value2 = tuples.get(i).getData().get(index) + "";
                if (value2.equals(value)){
                    boolean deleted = p.removeDataIndex(i);
                    if (deleted) {
                        // serialise the page after deleting from it
                        //serializePage(p);
                        for (int k = 0; k < colOrder.size(); k++) {
                            String treeCheck = colOrder.get(k);
                            String fName = TableName + "," + treeCheck + ".bin";
                            File tCheck = new File(fName);
                            if (tCheck.exists()) {
                                BPTree tt = deserializeTree(fName);
                                Ref r = new Ref(p.getPageName(),i);
                                tt.delete((Comparable) data.getData().get(k), r);

                                for (int j = r.getIndexInPage(); j < p.getTuples().size(); j++) {
                                    Ref refOld = new Ref(r.getFileName(), j + 1);
                                    Ref refNew = new Ref(p.getPageName(), j);
                                    tt.update((Comparable) tuples.get(j).getData().get(k),
                                            (Comparable) tuples.get(j).getData().get(k), refNew, refOld);
                                }
                                serializeTree(tt);
                            }
                        }

                        // loop over all the pages
                        for (int j = 0; j < Pages.size(); j++) {
                            // check if the page is the one we just deleted from
                            if (p.getPageName().equals(Pages.get(j).getPageName())) {
                                // load the page info
                                PageInfo pi = Pages.get(j);

                                // check if the page is empty
                                if (p.tupleSize() == 0) {
                                    // remove the page from the pages list
                                    Pages.remove(j);

                                    // delete the page from the disk
                                    serializePage(p);
                                    File f = new File(p.getPageName() + ".bin");
                                    f.delete();

                                    // break the loop because we deleted the page
                                    break;
                                }

                                // deserialize the page again to update the min and max
                                //Page page = deserializePage(p.getPageName());

                                // set the min and max of the page info
                                pi.setMin(p.getTuples().get(0).getData().get(index));
                                pi.setMax(p.getTuples().get(p.tupleSize() - 1).getData().get(index));

                                // finally, serialize the page
                                serializePage(p);
                            }
                        }
                    }
                }
            }
        }
    }

    public Tuple binarySearchTuples(Vector<Tuple> tuples, Object value) {
        int start = 0;
        int end = tuples.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            Tuple midTuple = tuples.get(mid);
            Object midValue = midTuple.getData().get(colOrder.indexOf(ClusteringKeyColumn));
            if (midValue.equals(value)) {
                return midTuple;
            } else if (((Comparable) midValue).compareTo((Comparable) value) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return null;
    }

    public Tuple getTuple(String clusteringKeyValue) {
        int index = colOrder.indexOf(ClusteringKeyColumn);
        Tuple resultTuple = new Tuple();
        String fileName = TableName + "," + ClusteringKeyColumn + ".bin";
        File check = new File(fileName);
        if (check.exists()) {
            BPTree tree = deserializeTree(fileName);
            Ref r = tree.search(clusteringKeyValue);
            Page p = deserializePage(r.getFileName());
            resultTuple = p.getTuples().get(r.getIndexInPage());
            serializePage(p);
            serializeTree(tree);

        } else {
            // Search for the tuple using binary search

            // Get the page where the tuple is located
            String pageName = binarySearch(Pages, 0, Pages.size() - 1, clusteringKeyValue);
            Page p = deserializePage(pageName);

            // Get the tuples in the page (O(1)) operation
            Vector<Tuple> tuples = p.getTuples();
            serializePage(p);

            // binary search within the tuples to find the tuple with the clustering key value
            resultTuple = binarySearchTuples(tuples, clusteringKeyValue);

        }
        return resultTuple;
    }

    private void serializePage(Page p) {
        String pageName = p.getPageName() + ".bin";
        File file = new File(pageName);
        ObjectOutputStream os = null;
        try {
            FileOutputStream fileOS = new FileOutputStream(file);
            os = new ObjectOutputStream(fileOS);
            // p.addData(data);
            os.writeObject(p);
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

    public Page deserializePage(String pageName) {
        Page p = new Page();
        String fileName = pageName + ".bin";
        ObjectInputStream in = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            in = new ObjectInputStream(fileIn);
            p = (Page) in.readObject();

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
        return p;
    }

    public Vector<Tuple> getAllData() {
        // Get all data from all pages. This is done linearly.
        Vector<Tuple> data = new Vector<Tuple>();
        for (PageInfo page : Pages) {
            Page p = deserializePage(page.getPageName());
            data.addAll(p.getTuples());
            serializePage(p);
        }
        return data;
    }

    public Vector<Tuple> getSelectDataIndex(String columnName, String operator, Object value) throws DBAppException {
        // Get only the relevant data using the binary plus tree index.
        Vector<Tuple> data = new Vector<Tuple>();
        BPTree tree = deserializeTree(TableName + "," + columnName + ".bin");
        value = value + "";

        switch (operator) {
            case "=":
                Ref b = tree.search((Comparable) value);
                if (b != null) {
                    ArrayList<Ref> dups = tree.searchDuplicates((Comparable) value);
                    for (int i = 0; i < dups.size(); i++) {
                        Ref a = dups.get(i);
                        if (a != null) {
                            Page p = deserializePage(a.getFileName());
                            data.add(p.getTuples().get(a.getIndexInPage()));
                            serializePage(p);
                        }
                    }
                    serializeTree(tree);
                }
                break;
            case ">":
                BPTreeLeafNode nn = tree.searchGreaterthan((Comparable) value);
                Object max = value;
                if (nn != null) {
                    Object temp = value;
                    for (int i = nn.getRecords().length - 1; i >= 0; i--) {
                        if (nn.getKey(i) != null) {
                            if (((Comparable) nn.getKey(i)).compareTo(temp) > 0) {
                                max = nn.getKey(i);
                            }
                        }
                    }
                } else {
                    serializeTree(tree);
                    break;
                }
                while (nn != null) {
                    ArrayList<Ref> dups = tree.searchDuplicates((Comparable) max);
                    for (int i = 0; i < dups.size(); i++) {
                        Ref rr = dups.get(i);
                        if (rr != null) {
                            Page p = deserializePage(rr.getFileName());
                            data.add(p.getTuples().get(rr.getIndexInPage()));
                            serializePage(p);
                        }
                    }
                    nn = tree.searchGreaterthan((Comparable) max);
                    if (nn != null) {
                        Object temp = max;
                        for (int i = nn.getRecords().length - 1; i >= 0; i--) {
                            if (nn.getKey(i) != null) {
                                if (((Comparable) nn.getKey(i)).compareTo(temp) > 0) {
                                    max = nn.getKey(i);
                                }
                            }
                        }
                    } else {
                        serializeTree(tree);
                        break;
                    }
                }
                serializeTree(tree);
                break;
            case "<":
                BPTreeLeafNode n = tree.searchMinNode();
                if (n != null) {
                    Object min = n.getFirstKey();
                    while (((Comparable) min).compareTo(value) < 0) {
                        ArrayList<Ref> dups = tree.searchDuplicates((Comparable) min);
                        for (int i = 0; i < dups.size(); i++) {
                            Ref rr = dups.get(i);
                            if (rr != null) {
                                Page p = deserializePage(rr.getFileName());
                                data.add(p.getTuples().get(rr.getIndexInPage()));
                                serializePage(p);
                            }
                        }
                        n = tree.searchGreaterthan((Comparable) min);
                        if (n != null) {
                            Object temp = min;
                            for (int i = n.getRecords().length - 1; i >= 0; i--) {
                                if (n.getKey(i) != null) {
                                    if (((Comparable) n.getKey(i)).compareTo(temp) > 0) {
                                        min = n.getKey(i);
                                    }
                                }
                            }
                        } else {
                            serializeTree(tree);
                            break;
                        }
                    }
                    serializeTree(tree);
                }
                break;
            case ">=":
                Vector<Tuple> data1 = getSelectDataIndex(columnName, "=", value);
                Vector<Tuple> data2 = getSelectDataIndex(columnName, ">", value);
                data = RecordOperators.orRecords(data1, data2);
                break;
            case "<=":
                Vector<Tuple> data11 = getSelectDataIndex(columnName, "=", value);
                Vector<Tuple> data22 = getSelectDataIndex(columnName, "<", value);
                data = RecordOperators.orRecords(data11, data22);
                break;
        }

        return data;
    }
}
