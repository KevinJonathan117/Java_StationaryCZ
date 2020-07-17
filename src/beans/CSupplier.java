
package beans;

public class CSupplier {
    private String IDSUPPLIER;
    private String NMSUPPLIER;
    private String ALAMAT;
    private String TELP;
    private String STATUS;

    public CSupplier(String IDSUPPLIER, String NMSUPPLIER, String ALAMAT, String TELP, String STATUS) {
        this.IDSUPPLIER = IDSUPPLIER;
        this.NMSUPPLIER = NMSUPPLIER;
        this.ALAMAT = ALAMAT;
        this.TELP = TELP;
        this.STATUS = STATUS;
    }

    public String getIDSUPPLIER() {
        return IDSUPPLIER;
    }

    public void setIDSUPPLIER(String IDSUPPLIER) {
        this.IDSUPPLIER = IDSUPPLIER;
    }

    public String getNMSUPPLIER() {
        return NMSUPPLIER;
    }

    public void setNMJABATAN(String NMSUPPLIER) {
        this.NMSUPPLIER = NMSUPPLIER;
    }

    public String getALAMAT() {
        return ALAMAT;
    }

    public void setALAMAT(String ALAMAT) {
        this.ALAMAT = ALAMAT;
    }

    public String getTELP() {
        return TELP;
    }

    public void setTELP(String TELP) {
        this.TELP = TELP;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
}
