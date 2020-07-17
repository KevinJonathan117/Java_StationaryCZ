
package beans;

public class CDetailBeli {
    private String IDBELI;
    private String NODETAIL;
    private String IDBRG;
    private int JUMLAH;
    private int HRGBELI;

    public CDetailBeli( String IDBELI, String IDBRG,String NODETAIL, int JUMLAH, int HRGBELI) {
        this.NODETAIL = NODETAIL;
        this.IDBRG = IDBRG;
        this.JUMLAH = JUMLAH;
        this.HRGBELI = HRGBELI;
        this.IDBELI = IDBELI;
    }

    public String getIDBELI() {
        return IDBELI;
    }

    public int getSubTotal(){
        return HRGBELI * JUMLAH;
    }
    public void setIDBELI(String IDBELI) {
        this.IDBELI = IDBELI;
    }

    public String getNODETAIL() {
        return NODETAIL;
    }

    public void setNODETAIL(String NODETAIL) {
        this.NODETAIL = NODETAIL;
    }

    public String getIDBRG() {
        return IDBRG;
    }

    public void setIDBRG(String IDBRG) {
        this.IDBRG = IDBRG;
    }

    public int getJUMLAH() {
        return JUMLAH;
    }

    public void setJUMLAH(int JUMLAH) {
        this.JUMLAH = JUMLAH;
    }

    public int getHRGBELI() {
        return HRGBELI;
    }

    public void setHRGBELI(int HRGBELI) {
        this.HRGBELI = HRGBELI;
    }
    
}
