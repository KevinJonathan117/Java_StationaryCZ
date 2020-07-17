/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Kevin
 */
public class CDetailJual {
    private String IDJUAL;
    private String IDBARANG;
    private int NODETAIL;
    private int JUMLAH;
    private int HRGJUAL;

    public CDetailJual(String IDJUAL, String IDBARANG, int NODETAIL, int JUMLAH, int HRGJUAL) {
        this.IDJUAL = IDJUAL;
        this.IDBARANG = IDBARANG;
        this.NODETAIL = NODETAIL;
        this.JUMLAH = JUMLAH;
        this.HRGJUAL = HRGJUAL;
    }

    public String getIDJUAL() {
        return IDJUAL;
    }

    public void setIDJUAL(String IDJUAL) {
        this.IDJUAL = IDJUAL;
    }

    public String getIDBARANG() {
        return IDBARANG;
    }

    public void setIDBARANG(String IDBARANG) {
        this.IDBARANG = IDBARANG;
    }

    public int getNODETAIL() {
        return NODETAIL;
    }

    public void setNODETAIL(int NODETAIL) {
        this.NODETAIL = NODETAIL;
    }

    public int getJUMLAH() {
        return JUMLAH;
    }

    public void setJUMLAH(int JUMLAH) {
        this.JUMLAH = JUMLAH;
    }

    public int getHRGJUAL() {
        return HRGJUAL;
    }

    public void setHRGJUAL(int HRGJUAL) {
        this.HRGJUAL = HRGJUAL;
    }
    
}
