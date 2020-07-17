
package beans;

public class CMerek {
    private String IDMEREK;
    private String NMMEREK;  
    private String STATUS;

    public CMerek(String IDMEREK, String NMMEREK, String STATUS) {
        this.IDMEREK = IDMEREK;
        this.NMMEREK = NMMEREK;
        this.STATUS = STATUS;
    }

    public String getIDMEREK() {
        return IDMEREK;
    }

    public void setIDMEREK(String IDMEREK) {
        this.IDMEREK = IDMEREK;
    }

    public String getNMMEREK() {
        return NMMEREK;
    }

    public void setNMMEREK(String NMMEREK) {
        this.NMMEREK = NMMEREK;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
}
