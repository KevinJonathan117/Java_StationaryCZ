
package beans;

public class CPegawai {
    private String IDPEG;
    private String IDJABATAN;
    private String NMPEG;
    private String USERNAME;
    private String PASSWORD;
    private String STATUS;
    
    public CPegawai(String IDPEG, String IDJABATAN, String NMPEG, String USERNAME, String PASSWORD, String STATUS) {
        this.IDPEG = IDPEG;
        this.IDJABATAN = IDJABATAN;
        this.NMPEG = NMPEG;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.STATUS = STATUS;
    }

    public String getIDPEG() {return IDPEG; }

    public void setIDPEG(String IDPEG) {
        this.IDPEG = IDPEG;
    }

    public String getIDJABATAN() {
        return IDJABATAN;
    }

    public void setIDJABATAN(String IDJABATAN) {
        this.IDJABATAN = IDJABATAN;
    }

    public String getNMPEG() {
        return NMPEG;
    }

    public void setNMPEG(String NMPEG) {
        this.NMPEG = NMPEG;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
}
