
package beans;

public class CPenjualan {
    private String IDJUAL;
    private String IDMEMBER;
    private String IDPEG;
    private String TGLJUAL;
    private int DISCJUAL;
    private int TOTALHRG;

    public CPenjualan(String IDJUAL, String IDMEMBER, String IDPEG, String TGLJUAL, int DISCJUAL, int TOTALHRG) {
        this.IDJUAL = IDJUAL;
        this.IDMEMBER = IDMEMBER;
        this.IDPEG = IDPEG;
        this.TGLJUAL = TGLJUAL;
        this.DISCJUAL = DISCJUAL;
        this.TOTALHRG = TOTALHRG;
    }

    public String getIDJUAL() {
        return IDJUAL;
    }

    public void setIDJUAL(String IDJUAL) {
        this.IDJUAL = IDJUAL;
    }

    public String getIDMEMBER() {
        return IDMEMBER;
    }

    public void setIDMEMBER(String IDMEMBER) {
        this.IDMEMBER = IDMEMBER;
    }

    public String getIDPEG() {
        return IDPEG;
    }

    public void setIDPEG(String IDPEG) {
        this.IDPEG = IDPEG;
    }

    public String getTGLJUAL() {
        return TGLJUAL;
    }

    public void setTGLJUAL(String TGLJUAL) {
        this.TGLJUAL = TGLJUAL;
    }

    public int getDISCJUAL() {
        return DISCJUAL;
    }

    public void setDISCJUAL(int DISCJUAL) {
        this.DISCJUAL = DISCJUAL;
    }

    public int getTOTALHRG() {
        return TOTALHRG;
    }

    public void setTOTALHRG(int TOTALHRG) {
        this.TOTALHRG = TOTALHRG;
    }
    
    
}
