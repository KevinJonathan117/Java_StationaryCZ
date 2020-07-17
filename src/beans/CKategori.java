
package beans;

public class CKategori {
    private String IDKATEGORI;
    private String NMKATEGORI;  
    private String STATUS;

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public CKategori(String IDKATEGORI, String NMKATEGORI, String STATUS) {
        this.IDKATEGORI = IDKATEGORI;
        this.NMKATEGORI = NMKATEGORI;
        this.STATUS = STATUS;
    }

    

    public String getIDKATEGORI() {
        return IDKATEGORI;
    }

    public void setIDKATEGORI(String IDKATEGORI) {
        this.IDKATEGORI = IDKATEGORI;
    }

    public String getNMKATEGORI() {
        return NMKATEGORI;
    }

    public void setNMKATEGORI(String NMKATEGORI) {
        this.NMKATEGORI = NMKATEGORI;
    }
    
}
