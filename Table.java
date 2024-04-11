import java.io.*;
import java.util.Hashtable;
import java.util.Vector;

import com.opencsv.CSVWriter;

public class Table implements Serializable {
    private String TableName = "";
    private String ClusteringKeyColumn;
    private int pageCount;
    private Vector<String> Pages = new Vector<String>();
    private Vector<String> colOrder = new Vector<String>();

    public Table() {

    }

    public Table(String strTableName,
                 String strClusteringKeyColumn,
                 Hashtable<String, String> htblColNameType) {
        this.TableName = strTableName;
        this.ClusteringKeyColumn = strClusteringKeyColumn;
        String hash = htblColNameType.toString();
        String hash2 = hash.substring(1, hash.length() - 1);
        String[] hash3 = hash2.split(",");
        for (int i = hash3.length - 1; i >= 0; i--) {
            String[] x = hash3[i].split("=");
            String xtrimmed = x[0].trim();
            colOrder.add(xtrimmed);
            if (xtrimmed.equals(strClusteringKeyColumn)) {
                String[] y = {strTableName, xtrimmed, x[1], "True", "null", "null"};
                writeDataLineByLine("resources/metaFile.csv", y);
            } else {
                String[] y = {strTableName, xtrimmed, x[1], "False", "null", "null"};
                writeDataLineByLine("resources/metaFile.csv", y);
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

    public int getPageCount(){
        return this.pageCount;
    }
    public Vector<String> getPages(){
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

    public void createIndexHelper(String tableName, String columnName){
        int index = colOrder.indexOf(columnName);
        BPTree tree = new BPTree(2);
        tree.setFileName(tableName,columnName);
        tree.createFile(tree.getFileName());
        for(int i=0; i< Pages.size();i++){
           Page p = deserializePage(Pages.get(i));
           Vector<Tuple> tuples = p.getTuples();
           for(int j=0; j<p.tupleSize(); j++){
               Tuple tuple = tuples.get(j);
               Ref reference = new Ref(p.getPageName(), j);
               tree.insert((Comparable) tuple.getData().get(index),reference);
           }
           serializePage(p);
        }
        serializeTree(tree);
    }

    private void serializeTree(BPTree t){
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


    public boolean addData(Tuple data) {
        int max = getMax();
        //int max = 2;
        String fileName = TableName + "," + ClusteringKeyColumn + ".bin";
        File check = new File(fileName);
        if (Pages.size() == 0) {
            pageCount++;
            String pageName = TableName + (Pages.size()+1);
            Page p = new Page(pageName, data);
            addInBTreeHelper(p, 0, data, 1);
            Pages.add(p.getPageName());
            //System.out.print(p.toString());
            serializePage(p);
            return true;
        } else if(check.exists()) {
            BPTree tree = deserializeTree(fileName);
            int index = colOrder.indexOf(ClusteringKeyColumn);
            BPTreeLeafNode r = tree.searchGreaterthan((Comparable) data.getData().get(index));
            if(tree.search((Comparable) data.getData().get(index)) == null){
                serializeTree(tree);
                return false;
            }else {
                serializeTree(tree);
                addWithIndex(data, r);
                return true;
            }
        }
        else {
            int index= colOrder.indexOf(ClusteringKeyColumn);
            for(int i =0; i<Pages.size(); i++) {
                Page p = deserializePage(Pages.get(i));
                Vector<Tuple> tuples= p.getTuples();
                for(int j=0; j<tuples.size(); j++){
                    Tuple a = tuples.get(j);
                    String b = (String) data.getData().get(index); //value to be inserted
                    String c = (String) a.getData().get(index); //value in page
                    if(b.compareTo(c) ==0 ){
                        serializePage(p);
                        return false;
                    }
                    if(b.compareTo(c) < 0){
                        if(tuples.size()<max){
                            p.addData(data,j);
                            addInBTreeHelper(p, j, data, 2);
                            //System.out.print(p.toString());
                            serializePage(p);
                            return true;
                        }
                        else if(tuples.size() == max){
                            Tuple shift = tuples.getLast();
                            p.addData(data,j);
                            addInBTreeHelper(p, j, data, 3);
                            p.removeData(shift);
                            //System.out.print(p.toString());
                            serializePage(p);
                            addData(shift);
                            return true;
                        }
                    }
                    else if(i == Pages.size()-1){
                        if (j == tuples.size() - 1) {
                                if (tuples.size() == max) {
                                    pageCount++;
                                    String pageName = TableName + (Pages.size()+1);
                                    Page x = new Page(pageName, data);
                                    Pages.add(x.getPageName());
                                    addInBTreeHelper(x, 0, data, 1);
                                    //System.out.println(p.toString());
                                    //System.out.println(x.toString());
                                    serializePage(x);
                                    serializePage(p);
                                    return true;
                                } else {
                                    p.addData(data, j+1);
                                    addInBTreeHelper(p, j+1, data, 1);
                                    //System.out.print(p.toString());
                                    serializePage(p);
                                    return true;
                                }
                            }
                    }
                }
            }
        }
        return false;
    }

    public void addWithIndex(Tuple data, BPTreeLeafNode node){
        int max = getMax();
        //int max = 2;
        if(node != null)
        //System.out.println(node.toString());
        if(node == null){
            Page p = deserializePage(Pages.getLast());
            Vector<Tuple> tuples = p.getTuples();
            if (tuples.size() == max) {
                pageCount++;
                String pageName = TableName + (Pages.size() + 1);
                Page x = new Page(pageName, data);
                Pages.add(x.getPageName());
                addInBTreeHelper(x, 0, data, 1);
                //System.out.println(p.toString());
                //System.out.println(x.toString());
                serializePage(x);
                serializePage(p);
                return;
            } else {
                p.addData(data, tuples.size());
                addInBTreeHelper(p, tuples.size()-1, data, 1);
                //System.out.print(p.toString());
                serializePage(p);
                return;
            }
        }
        else {
            int colIndex= colOrder.indexOf(ClusteringKeyColumn);
            Ref yy = null;
            for (int i = node.getRecords().length-1 ; i >= 0; i--) {
                if(((Comparable) node.getKey(i)).compareTo(data.getData().get(colIndex)) > 0 ){
                   yy = node.getRecords()[i];
                }
            }
            Ref r = yy;
            Page p = deserializePage(r.getFileName());
            int index = r.getIndexInPage();
            //System.out.println("index: " + index);
            Vector<Tuple> tuples = p.getTuples();
            if (tuples.size() < max) {
                p.addData(data, index);
                addInBTreeHelper(p, index, data, 2);
                //System.out.print(p.toString());
                serializePage(p);
                return;
            } else if (tuples.size() == max) {
                Tuple shift = tuples.getLast();
                p.addData(data, index);
                addInBTreeHelper(p, index, data, 3);
                p.removeData(shift);
                System.out.print(p.toString());
                serializePage(p);
                addData(shift);
                return;
            } else if (Pages.getLast().equalsIgnoreCase(p.getPageName())) {
                if (index == tuples.size() - 1) {
                    if (tuples.size() == max) {
                        pageCount++;
                        String pageName = TableName + (Pages.size() + 1);
                        Page x = new Page(pageName, data);
                        Pages.add(x.getPageName());
                        addInBTreeHelper(x, 0, data, 1);
                        //System.out.println(p.toString());
                        //System.out.println(x.toString());
                        serializePage(x);
                        serializePage(p);
                        return;
                    } else {
                        p.addData(data, index + 1);
                        addInBTreeHelper(p, index + 1, data, 1);
                        //System.out.print(p.toString());
                        serializePage(p);
                        return;
                    }
                }
            }
        }

    }

    private void addInBTreeHelper(Page p, int startIndex, Tuple data, int flag){
        Vector <Tuple> tuples = p.getTuples();
        for(int i =0; i<colOrder.size(); i++) {
            String fileName = TableName + "," + colOrder.get(i) + ".bin";
            File check = new File(fileName);
            if(check.exists()) {
                BPTree tree = deserializeTree(fileName);
                if(flag == 1){
                    Ref reference = new Ref(p.getPageName(), startIndex);
                    tree.insert((Comparable) data.getData().get(i), reference);
                    serializeTree(tree);
                }
                else{
                    if((flag == 3) || flag == 2){
                        Ref refOld = new Ref(p.getPageName(), tuples.indexOf(tuples.getLast())-1);
                        tree.delete((Comparable) tuples.getLast().getData().get(i),refOld);
                    }
                        for (int j = startIndex; j < p.getTuples().size() - 1; j++) {
                            if (!(flag == 3 && j == p.getTuples().size() - 2)) {
                                Ref refOld = new Ref(p.getPageName(), j);
                                Ref refNew = new Ref(p.getPageName(), j + 1);
                                tree.update((Comparable) tuples.get(j + 1).getData().get(i), (Comparable) tuples.get(j + 1).getData().get(i), refNew, refOld);
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
        // check if table is empty
        if (Pages.isEmpty()) {
            throw new DBAppException("Table is empty");
        } else {
            boolean dataFound = false;
            // iterate over all pages
            for (String pageName : Pages) {
                Page page = deserializePage(pageName);
                // attempt to delete data from page
                boolean deleted = page.removeData(data);
                if (deleted) {
                    dataFound = true;
                    // if data is deleted, serialize the page again
                    serializePage(page);
                    // no need to check other pages
                    break;
                }
            }
            if (!dataFound) {
                throw new DBAppException("Data not found in any page");
            }
        }
    }

    public Tuple getTuple(String clusteringKeyValue){
        int index = colOrder.indexOf(ClusteringKeyColumn);
        Tuple tu = new Tuple();
        String fileName = TableName + "," + ClusteringKeyColumn + ".bin";
        File check = new File(fileName);
        if (check.exists()) {
            BPTree tree = deserializeTree(fileName);
            Ref r= tree.search(clusteringKeyValue);
            Page p = deserializePage(r.getFileName());
            tu = p.getTuples().get(r.getIndexInPage());
            serializePage(p);
            serializeTree(tree);
            return tu;
        }
        else{
            for(int i=0; i< Pages.size(); i++){
                Page p = deserializePage(Pages.get(i));
                for (int j = 0; j < p.getTuples().size()-1; j++) {
                    if(p.getTuples().get(j).getData().get(index).equals (clusteringKeyValue)){
                        Tuple tuple = p.getTuples().get(j);
                        serializePage(p);
                        return tuple;
                    }
                }
                serializePage(p);
            }
        }
        return tu;
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

    private Page deserializePage(String pageName) {
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
        for (String page : Pages) {
            Page p = deserializePage(page);
            data.addAll(p.getTuples());
            serializePage(p);
        }
        return data;
    }
}