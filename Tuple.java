import java.io.Serializable;
import java.util.Vector;

public class Tuple implements Serializable {
    private Vector<Object> data= new Vector<Object>();

    public Tuple(Vector<Object> data){
        this.data=data;
    }

    public String toString() {
        String x = "";
        for (int i = 0; i < data.size() - 1; i++) {
            x = x + data.get(i) + ",";
        }
        x = x + data.get(data.size() - 1);
        return x;
    }

    public boolean compareTo(Tuple t) {
        if(t.data.size() != data.size())
            return false;
        for(int i =0; i<data.size()-1; i++){
           if(!(t.data.get(i).equals(data.get(i)))){
               return false;
           }
        }
        return true;
    }
}
