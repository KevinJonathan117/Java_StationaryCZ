
package beans;

public class CPembelian {
    private String IDBELI;
    private String IDPEG;
    private String IDSUPPLIER;
    private String TGLBELI;
    private int TOTALHRG; 

    public CPembelian(String IDBELI, String IDPEG, String IDSUPPLIER, String TGLBELI, int TOTALHRG) {
        this.IDBELI = IDBELI;
        this.IDPEG = IDPEG;
        this.IDSUPPLIER = IDSUPPLIER;
        this.TGLBELI = TGLBELI;
        this.TOTALHRG = TOTALHRG;
    }

    public String getIDBELI() {
        return IDBELI;
    }

    public void setIDBELI(String IDBELI) {
        this.IDBELI = IDBELI;
    }

    public String getIDPEG() {
        return IDPEG;
    }

    public void setIDPEG(String IDPEG) {
        this.IDPEG = IDPEG;
    }

    public String getIDSUPPLIER() {
        return IDSUPPLIER;
    }

    public void setIDSUPPLIER(String IDSUPPLIER) {
        this.IDSUPPLIER = IDSUPPLIER;
    }

    public String getTGLBELI() {
        return TGLBELI;
    }

    public void setTGLBELI(String TGLBELI) {
        this.TGLBELI = TGLBELI;
    }

    public int getTOTALHRG() {
        return TOTALHRG;
    }

    public void setTOTALHRG(int TOTALHRG) {
        this.TOTALHRG = TOTALHRG;
    }
    
}
