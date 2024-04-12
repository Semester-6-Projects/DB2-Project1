import java.io.Serializable;

public class PageInfo implements Serializable {
    private String PageName;
    private Object min;
    private Object max;
    public PageInfo(){
    }
    public PageInfo(String PageName, Object min, Object max){
     this.PageName = PageName;
     this.max = max;
     this.min = min;
    }

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
    }

    public Object getMin() {
        return min;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    public Object getMax() {
        return max;
    }

    public void setMax(Object max) {
        this.max = max;
    }
}
