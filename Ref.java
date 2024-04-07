import java.io.Serializable;

public class Ref implements Serializable {

    /**
     * This class represents a pointer to the record. It is used at the leaves of
     * the B+ tree
     */
    private static final long serialVersionUID = 1L;
    private int indexInPage;
    private String pageName;

    public Ref(String pageName, int indexInPage) {
        this.pageName = pageName;
        this.indexInPage = indexInPage;
    }

    /**
     * @return the page at which the record is saved on the hard disk
     */
    public String getPage() {
        return pageName;
    }

    /**
     * @return the index at which the record is saved in the page
     */
    public int getIndexInPage() {
        return indexInPage;
    }

    public String getFileName() {
        return this.pageName;

    }

    public Boolean isEqual(Ref ref) {
        if (this.pageName.equals(ref.pageName) && this.indexInPage == ref.indexInPage)
            return true;

        return false;
    }

    public String toString() {
        String s = "";
        s += "PageName:" + this.getFileName() + "  RowIndex:" + this.getIndexInPage();
        return s;
    }
}