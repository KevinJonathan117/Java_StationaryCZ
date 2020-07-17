
package beans;

public class CDetailRetur {
    private String NORETUR;
    private String IDBARANG;
    private String NODETAIL;
    private int JUMLAHRETUR;

    public CDetailRetur(String NORETUR, String IDBARANG, String NODETAIL, int JUMLAHRETUR) {
        this.NORETUR = NORETUR;
        this.IDBARANG = IDBARANG;
        this.NODETAIL = NODETAIL;
        this.JUMLAHRETUR = JUMLAHRETUR;
    }

    public String getNORETUR() {
        return NORETUR;
    }

    public void setNORETUR(String NORETUR) {
        this.NORETUR = NORETUR;
    }

    public String getIDBARANG() {
        return IDBARANG;
    }

    public void setIDBARANG(String IDBARANG) {
        this.IDBARANG = IDBARANG;
    }

    public String getNODETAIL() {
        return NODETAIL;
    }

    public void setNODETAIL(String NODETAIL) {
        this.NODETAIL = NODETAIL;
    }

    public int getJUMLAHRETUR() {
        return JUMLAHRETUR;
    }

    public void setJUMLAHRETUR(int JUMLAHRETUR) {
        this.JUMLAHRETUR = JUMLAHRETUR;
    }
    
}
