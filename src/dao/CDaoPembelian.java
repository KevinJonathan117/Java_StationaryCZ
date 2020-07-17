
package dao;

import beans.CDetailBeli;
import beans.CKategori;
import beans.CPembelian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ui.MyConnection;

public class CDaoPembelian {
    
    static ArrayList<CDetailBeli> arrdetbeli = new ArrayList<CDetailBeli>();
    public static ArrayList<CDetailBeli> getDetail(){
        return arrdetbeli;
    }
    public static String getAutoID(Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CKategori kategori = null;
        String maxikat = "Z0000";
        String strangka = "";
        String query = "SELECT max(IDBELI) MAXI FROM PEMBELIAN ";

        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxikat = rs.getString("MAXI");
            }
            if (maxikat==null){
                strangka = "Z0001";
            }else
            {
                strangka = maxikat.substring(1, 5);
                int angka = Integer.parseInt(strangka) + 1;
                strangka = angka + "";
                for (int i = 0; i < 4 - (angka + "").length(); i++) {
                    strangka = "0" + strangka;
                }
                strangka = "Z" + strangka;
            }            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(rs, ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return strangka;
    }

    public static int getHitungDetail()
    {
        return arrdetbeli.size();
    }
    public static int hitung_total()
    {
        int tot = 0;
        for (int i = 0; i < arrdetbeli.size(); i++) {
            tot+=arrdetbeli.get(i).getHRGBELI() * arrdetbeli.get(i).getJUMLAH();
        }
        return tot;
    }
    public static void removeRows(int idx){
        arrdetbeli.remove(idx);
    }
    public static void addPembelian(CPembelian pembelian, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO PEMBELIAN(IDBELI, IDPEG, IDSUPPLIER,TGLBELI,TOTALHRG ) values (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, pembelian.getIDPEG());
            ps.setString(3, pembelian.getIDSUPPLIER());
            ps.setString(4, pembelian.getTGLBELI());
            ps.setInt(5, pembelian.getTOTALHRG());
            ps.execute();
            for (int i = 0; i < arrdetbeli.size(); i++) {
                addDetailPembelian(arrdetbeli.get(i),connection);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
     public static int getHargaBeliAkhir(String aa,String bb, Connection connection){
        String query = "SELECT hrgbeli from detail_beli where idbarang='" + aa + "' and nodetail='" + bb + "' ";
        query += " and idbeli in (select max(idbeli) from detail_beli where  idbarang='" + aa + "' and nodetail='" + bb + "') ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String hrg="";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                hrg = rs.getString("hrgbeli");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(rs, ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (hrg=="") return -1;
        else return Integer.parseInt(hrg);
    }
    public static String getNamaBarang(String aa, Connection connection){
        String query = "SELECT nmbarang from barang where idbarang='" + aa + "' ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String namabrg="";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                namabrg = rs.getString("nmbarang");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(rs, ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return namabrg;
    }
    public static String getDescripsiDetailBarang(String aa, String bb, Connection connection){
        String iddet=bb.substring(5);
        String query = "SELECT deskripsi from detailbarang where nodetail='" + iddet + "' and idbarang='" + aa + "' ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String namades="";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                namades = rs.getString("deskripsi");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(rs, ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return namades;
    }
    public static void addDetailPembelian(CDetailBeli detbeli, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO DETAIL_BELI(IDBELI, IDBARANG, NODETAIL,JUMLAH,HRGBELI ) values (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, detbeli.getIDBELI());
            ps.setString(2, detbeli.getIDBRG());
            ps.setString(3, detbeli.getNODETAIL().substring(5));
            ps.setInt(4, detbeli.getJUMLAH());
            ps.setInt(5, detbeli.getHRGBELI());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void simpanArray(CDetailBeli detbeli, Connection connection){
        arrdetbeli.add(detbeli);
    }
    
    public static void clearArray()
    {
        arrdetbeli.clear();
    }

    public static void updateArray(CDetailBeli newdetbeli,int idx) {
        arrdetbeli.set(idx,newdetbeli);
    }

    public static void simpanPembelian(CPembelian pem, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO PEMBELIAN(IDBELI, IDPEG, IDSUPPLIER,TGLBELI,TOTALHRG) values (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            //String idbaru = getAutoID(connection);
            ps.setString(1, pem.getIDBELI());
            ps.setString(2, pem.getIDPEG());
            ps.setString(3, pem.getIDSUPPLIER());
            ps.setString(4, pem.getTGLBELI());
            ps.setInt(5, pem.getTOTALHRG());
            ps.execute();
            for (int i = 0; i < arrdetbeli.size(); i++) {
                query = "INSERT INTO DETAIL_BELI (IDBELI,IDBARANG,NODETAIL,JUMLAH,HRGBELI) VALUES(?,?,?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, pem.getIDBELI());
                ps.setString(2, arrdetbeli.get(i).getIDBRG());
                ps.setString(3, arrdetbeli.get(i).getNODETAIL().substring(5));
                ps.setInt(4, arrdetbeli.get(i).getJUMLAH());
                ps.setInt(5, arrdetbeli.get(i).getHRGBELI());
                ps.execute();
                query = "UPDATE DETAILBARANG SET STOK = STOK + ? WHERE IDBARANG=? AND NODETAIL=? ";
                ps = connection.prepareStatement(query);
                ps.setInt(1, arrdetbeli.get(i).getJUMLAH());
                ps.setString(2, arrdetbeli.get(i).getIDBRG());
                ps.setString(3, arrdetbeli.get(i).getNODETAIL().substring(5));
                ps.execute();
                query = "UPDATE BARANG SET STOK = STOK + ? WHERE IDBARANG=?  ";
                ps = connection.prepareStatement(query);
                ps.setInt(1, arrdetbeli.get(i).getJUMLAH());
                ps.setString(2, arrdetbeli.get(i).getIDBRG());
                ps.execute();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void tambah_jumlah_beli(int pketemu, int jumtambah) {
        arrdetbeli.get(pketemu).setJUMLAH(arrdetbeli.get(pketemu).getJUMLAH() + jumtambah);
    }
}
