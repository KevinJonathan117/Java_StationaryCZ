
package beans;

public class CDetailBarang {
    private String NODETAIL;
    private String IDBARANG;
    private String DESKRIPSI ;
    private int STOK;

    public CDetailBarang(String NODETAIL ,String IDBARANG, String DESKRIPSI, int STOK) {
        this.NODETAIL = NODETAIL;
        this.IDBARANG = IDBARANG;
        this.DESKRIPSI = DESKRIPSI;
        this.STOK = STOK;
    }

    public String getNODETAIL() {
        return NODETAIL;
    }

    public void setNODETAIL(String NODETAIL) {
        this.NODETAIL = NODETAIL;
    }

    public String getIDBARANG() {
        return IDBARANG;
    }

    public void setIDBARANG(String IDBARANG) {
        this.IDBARANG = IDBARANG;
    }

    public String getDESKRIPSI() {
        return DESKRIPSI;
    }

    public void setDESKRIPSI(String DESKRIPSI) {
        this.DESKRIPSI = DESKRIPSI;
    }

    public int getSTOK() {
        return STOK;
    }

    public void setSTOK(int STOK) {
        this.STOK = STOK;
    }
    
}
