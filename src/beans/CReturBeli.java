
package beans;

public class CReturBeli {
    private String NORETUR;
    private String IDSUPPLIER;
    private String TGLRETUR;
    private String TGLDAPATBARANG;

    public CReturBeli(String NORETUR, String IDSUPPLIER, String TGLRETUR, String TGLDAPATBARANG) {
        this.NORETUR = NORETUR;
        this.IDSUPPLIER = IDSUPPLIER;
        this.TGLRETUR = TGLRETUR;
        this.TGLDAPATBARANG = TGLDAPATBARANG;
    }

    public String getNORETUR() {
        return NORETUR;
    }

    public void setNORETUR(String NORETUR) {
        this.NORETUR = NORETUR;
    }

    public String getIDSUPPLIER() {
        return IDSUPPLIER;
    }

    public void setIDSUPPLIER(String IDSUPPLIER) {
        this.IDSUPPLIER = IDSUPPLIER;
    }

    public String getTGLRETUR() {
        return TGLRETUR;
    }

    public void setTGLRETUR(String TGLRETUR) {
        this.TGLRETUR = TGLRETUR;
    }

    public String getTGLDAPATBARANG() {
        return TGLDAPATBARANG;
    }

    public void setTGLDAPATBARANG(String TGLDAPATBARANG) {
        this.TGLDAPATBARANG = TGLDAPATBARANG;
    }
    
}
