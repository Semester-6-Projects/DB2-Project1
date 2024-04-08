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

    public void addData(Tuple data) {
        int max = getMax();
        //int max = 2;
        if (Pages.size() == 0) {
            pageCount++;
            String pageName = TableName + (Pages.size()+1);
            Page p = new Page(pageName, data);
            Pages.add(p.getPageName());
            System.out.println("Pages: " + Pages.size());
            System.out.println(p.toString());
            serializePage(p);
        } else {
            System.out.println("two");
            int index= colOrder.indexOf(ClusteringKeyColumn);
            for(int i =0; i<Pages.size(); i++) {
                Page p = deserializePage(Pages.get(i));
                Vector<Tuple> tuples= p.getTuples();
                for(int j=0; j<tuples.size(); j++){
                    Tuple a = tuples.get(j);
                    String b = (String) data.getData().get(index); //value to be inserted
                    String c = (String) a.getData().get(index); //value in page
                    if(b.compareTo(c) < 0){
                        System.out.println("<");
                        if(tuples.size()<max){
                            p.addData(data,j);
                            System.out.println(p.toString());
                            serializePage(p);
                            return;
                        }
                        else if(tuples.size() == max){
                            System.out.println("awl == max + recurrsive");
                            Tuple shift = tuples.getLast();
                            p.removeData(shift);
                            p.addData(data,j);
                            System.out.println(p.toString());
                            serializePage(p);
                            addData(shift);
                            return;
                        }
                    }
                    else if(i == Pages.size()-1){
                        System.out.println("pages.size: " + Pages.size());
                        System.out.println("i: " + i);
                        System.out.println("last page");
                        System.out.println("tuples.size: " + tuples.size());
                        System.out.println("pages.size: " + Pages.size());
                        System.out.println("j: " + j);
                        if (j == tuples.size() - 1) {
                                if (tuples.size() == max) {
                                    System.out.println("second ==max");
                                    pageCount++;
                                    String pageName = TableName + (Pages.size()+1);
                                    Page x = new Page(pageName, data);
                                    Pages.add(x.getPageName());
                                    System.out.println(x.toString());
                                    serializePage(x);
                                    System.out.println(p.toString());
                                    serializePage(p);
                                    return;
                                } else {
                                    System.out.println("last page else");
                                    p.addData(data, j + 1);
                                    System.out.println(p.toString());
                                    serializePage(p);
                                    return;
                                }
                            }
                    }
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
        }
        return data;
    }
}