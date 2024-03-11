import java.io.*;
import java.util.Hashtable;
import java.io.Serializable;
import java.util.Vector;

import com.opencsv.CSVWriter;

public class Table implements Serializable{
    private String TableName="";
    private String ClusteringKeyColumn;
    private int pageCount = 0;
    private Vector<Page> Pages = new Vector<Page>();

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
            if (xtrimmed.equals(strClusteringKeyColumn)) {
                String[] y = {strTableName, xtrimmed, x[1], "True", "null", "null"};
                writeDataLineByLine("resources/metaFile.csv", y);
            } else {
                String[] y = {strTableName, xtrimmed, x[1], "False", "null", "null"};
                writeDataLineByLine("resources/metaFile.csv", y);
            }
        }
    }

    public String getTableName(){
        return this.TableName;
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


     private int getMax(){
        int x;
        try{
            FileReader fr=new FileReader("resources/DBApp.config");
            BufferedReader br=new BufferedReader(fr);
            String z = br.readLine();
            String [] y = z.split("=");
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
        if ((Pages.size() == 0) || (Pages.getLast().tupleSize() == max)) {
            //make 200 max config
            pageCount++;
            String pageName = TableName + pageCount + ".bin";
            Page p = new Page(pageName,data);
            Pages.add(p);
            serializePageCreate(p,data);
        }
        else{
             deserializePage(Pages.getLast());
             serializePageAdd(Pages.getLast(), data);
        }
    }


    private void serializePageCreate(Page p, Tuple data){
        ObjectOutputStream os = null;
        String pageName = p.getPageName();
        try {
            FileOutputStream fileOS = new FileOutputStream(pageName);
            os = new ObjectOutputStream(fileOS);
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


    private void serializePageAdd(Page p, Tuple data) {
        String pageName = p.getPageName();
        File file = new File(pageName);
        ObjectOutputStream os= null;
        try{
            FileOutputStream fileOS= new FileOutputStream(file,true);
            os = new ObjectOutputStream(fileOS);
            p.addData(data);
            os.writeObject(p);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void deserializePage(Page p){
        String pageName = p.getPageName();
        ObjectInputStream in= null;
        try{
            FileInputStream fileIn = new FileInputStream(pageName);
            in = new ObjectInputStream(fileIn);
            in.readObject();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void serializePageDelete(Page p, Tuple data) {
        String pageName = p.getPageName();
        File file = new File(pageName);
        ObjectOutputStream os= null;
        try{
            FileOutputStream fileOS= new FileOutputStream(file,true);
            os = new ObjectOutputStream(fileOS);
            p.removeData(data);
            os.writeObject(p);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


//    public Tuple createTuple(Hashtable<String,Object> h){
//     //to be done
//
//    }



    public static void main(String[] args) {
        String strTableName = "Student";

        Hashtable htblColNameType = new Hashtable();
        htblColNameType.put("id", "java.lang.Integer");
        htblColNameType.put("name", "java.lang.String");
        htblColNameType.put("gpa", "java.lang.double");

        Table t= new Table(strTableName,"id",htblColNameType);


//        ArrayList<Object> tupleData= new ArrayList<Object>();
//        tupleData.add("Ahmed");
//        tupleData.add("20");
//        tupleData.add("Zamalek");
//        Tuple data = new Tuple(tupleData);
//
//        ArrayList<Object> tupleData2= new ArrayList<Object>();
//        tupleData2.add("Ahmed2");
//        tupleData2.add("202");
//        tupleData2.add("Zamalek2");
//        Tuple data2 = new Tuple(tupleData2);
//
//        //Page p = new Page(strTableName,pageNo,data);
//        t.addData(data);
//        t.addData(data2);
//        System.out.print(t.getMax());




        //System.out.print(data.compareTo(data));
        // p.ReadData(data2);
        //System.out.print(p.ReadData().toString());
        //System.out.print(p.toString());

    }
}