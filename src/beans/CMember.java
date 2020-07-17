
package beans;

public class CMember {
    
    private String IDMEMBER;
    private String NMMEMBER;  
    private String HPMEMBER;
    private int SALDOMEMBER;
    private String STATUS;

    public CMember(String IDMEMBER, String NMMEMBER, String HPMEMBER, int SALDOMEMBER, String STATUS) {
        this.IDMEMBER = IDMEMBER;
        this.NMMEMBER = NMMEMBER;
        this.HPMEMBER = HPMEMBER;
        this.SALDOMEMBER = SALDOMEMBER;
        this.STATUS = STATUS;
    }

    public String getIDMEMBER() {
        return IDMEMBER;
    }

    public void setIDMEMBER(String IDMEMBER) {
        this.IDMEMBER = IDMEMBER;
    }

    public String getNMMEMBER() {
        return NMMEMBER;
    }

    public void setNMMEMBER(String NMMEMBER) {
        this.NMMEMBER = NMMEMBER;
    }

    public String getHPMEMBER() {
        return HPMEMBER;
    }

    public void setHPMEMBER(String HPMEMBER) {
        this.HPMEMBER = HPMEMBER;
    }

    public int getSALDOMEMBER() {
        return SALDOMEMBER;
    }

    public void setSALDOMEMBER(int SALDOMEMBER) {
        this.SALDOMEMBER = SALDOMEMBER;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
    
}
