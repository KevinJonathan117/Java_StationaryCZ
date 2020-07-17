
package beans;

public class CBarang {
    private String IDBARANG;
    private String IDKATEGORI;
    private String IDMEREK ;
    private String NMBARANG;
    private String NMGAMBAR;
    private int HRGJUALBARANG;
    private String  STATUS;
    private int STOK ;
    
  
    public CBarang(String IDBARANG, String IDKATEGORI, String IDMEREK, String NMBARANG, String NMGAMBAR, int HRGJUALBARANG, int STOK, String STATUS) {
        this.IDBARANG = IDBARANG;
        this.IDKATEGORI = IDKATEGORI;
        this.IDMEREK = IDMEREK;
        this.NMBARANG = NMBARANG;
        this.NMGAMBAR = NMGAMBAR;
        this.HRGJUALBARANG = HRGJUALBARANG;
        this.STOK = STOK;
        this.STATUS = STATUS;
    }

    public String getIDBARANG() {
        return IDBARANG;
    }

    public void setIDBARANG(String IDBARANG) {
        this.IDBARANG = IDBARANG;
    }

    public String getIDKATEGORI() {
        return IDKATEGORI;
    }

    public void setIDKATEGORI(String IDKATEGORI) {
        this.IDKATEGORI = IDKATEGORI;
    }

    public String getIDMEREK() {
        return IDMEREK;
    }

    public void setIDMEREK(String IDMEREK) {
        this.IDMEREK = IDMEREK;
    }

    public String getNMBARANG() {
        return NMBARANG;
    }

    public void setNMBARANG(String NMBARANG) {
        this.NMBARANG = NMBARANG;
    }

    public String getNMGAMBAR() {
        return NMGAMBAR;
    }

    public void setNMGAMBAR(String NMGAMBAR) {
        this.NMGAMBAR = NMGAMBAR;
    }

    public int getHRGJUALBARANG() {
        return HRGJUALBARANG;
    }

    public void setHRGJUALBARANG(int HRGJUALBARANG) {
        this.HRGJUALBARANG = HRGJUALBARANG;
    }

    public int getSTOK() {
        return STOK;
    }

    public void setSTOK(int STOK) {
        this.STOK = STOK;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
    
    
}
