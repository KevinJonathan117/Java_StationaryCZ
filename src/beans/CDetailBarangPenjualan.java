/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Joshua
 */
public class CDetailBarangPenjualan {
    private String NODETAIL;
    private String IDBARANG;
    private String DESKRIPSI ;
    private int STOK;
    private int HARGA;
    
    public CDetailBarangPenjualan(String NODETAIL, String IDBARANG, String DESKRIPSI, int STOK, int HARGA) {
        this.NODETAIL = NODETAIL;
        this.IDBARANG = IDBARANG;
        this.DESKRIPSI = DESKRIPSI;
        this.STOK = STOK;
        this.HARGA = HARGA;
    }

    public String getNODETAIL() {
        return NODETAIL;
    }

    public void setNODETAIL(String NODETAIL) {
        this.NODETAIL = NODETAIL;
    }

    public String getIDBARANG() {
        return IDBARANG;
    }

    public void setIDBARANG(String IDBARANG) {
        this.IDBARANG = IDBARANG;
    }

    public String getDESKRIPSI() {
        return DESKRIPSI;
    }

    public void setDESKRIPSI(String DESKRIPSI) {
        this.DESKRIPSI = DESKRIPSI;
    }

    public int getSTOK() {
        return STOK;
    }

    public void setSTOK(int STOK) {
        this.STOK = STOK;
    }

    public int getHARGA() {
        return HARGA;
    }

    public void setHARGA(int HARGA) {
        this.HARGA = HARGA;
    }

}
