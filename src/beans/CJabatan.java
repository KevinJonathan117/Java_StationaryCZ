
package beans;


public class CJabatan {
    private String IDJABATAN;
    private String NMJABATAN;

    public CJabatan(String IDJABATAN, String NMJABATAN) {
        this.IDJABATAN = IDJABATAN;
        this.NMJABATAN = NMJABATAN;
    }

    public String getIDJABATAN() {
        return IDJABATAN;
    }

    public void setIDJABATAN(String IDJABATAN) {
        this.IDJABATAN = IDJABATAN;
    }

    public String getNMJABATAN() {
        return NMJABATAN;
    }

    public void setNMJABATAN(String NMJABATAN) {
        this.NMJABATAN = NMJABATAN;
    }
    
}
