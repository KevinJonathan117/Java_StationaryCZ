
package dao;

import beans.CDetailRetur;
import beans.CReturBeli;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ui.MyConnection;


public class CDaoReturBeli {
    static ArrayList<CDetailRetur> arrdetretur = new ArrayList<CDetailRetur>();
    public static ArrayList<CDetailRetur> getDetail(){
        return arrdetretur;
    }
    public static ArrayList<CReturBeli> getAllRetur(Connection connection, String qry) {
        ArrayList<CReturBeli> listRetur = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CReturBeli detret = new CReturBeli(rs.getString("NORETUR"),
                        rs.getString("IDSUPPLIER"),rs.getString("TGLRETUR"),"");
                listRetur.add(detret);
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
        return listRetur;
    }
    public static ArrayList<CDetailRetur> getAllDetailRetur(Connection connection, String qry) {
        ArrayList<CDetailRetur> listdetailRetur = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CDetailRetur detret = new CDetailRetur(rs.getString("NORETUR"),
                        rs.getString("IDBARANG"),rs.getString("NODETAIL"),rs.getInt("JUMLAHRETUR"));
                listdetailRetur.add(detret);
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
        return listdetailRetur;
    }
    public static String getAutoID(Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        String maxikat = "R0000";
        String strangka = "";
        String query = "SELECT max(NORETUR) MAXI FROM RETURPEMBELIAN ";

        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxikat = rs.getString("MAXI");
            }
            if (maxikat==null){
                strangka = "R0001";
            }else
            {
                strangka = maxikat.substring(1, 5);
                int angka = Integer.parseInt(strangka) + 1;
                strangka = angka + "";
                for (int i = 0; i < 4 - (angka + "").length(); i++) {
                    strangka = "0" + strangka;
                }
                strangka = "R" + strangka;
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
    public static String getTglRetur(String nomor, Connection connection)
    {
        String query = "SELECT tglretur from returpembelian where noretur='" + nomor + "' ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String tglretur="";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                tglretur = rs.getString("tglretur");
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
        return tglretur;
    }
    public static int getHitungDetail()
    {
        return arrdetretur.size();
    }
    
    public static void removeRows(int idx){
        arrdetretur.remove(idx);
    }
    public static void simpanReturPembelian(CReturBeli retur, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO RETURPEMBELIAN(NORETUR, IDSUPPLIER, TGLRETUR,TGLDAPATBARANG ) values (?, ?,  ?,null)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, retur.getIDSUPPLIER());
            ps.setString(3, retur.getTGLRETUR());
            ps.execute();
            for (int i = 0; i < arrdetretur.size(); i++) {
                addDetailReturPembelian(arrdetretur.get(i),connection);
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
    public static void updateStokBarangRetur(CDetailRetur detreturbeli, Connection connection)
    {
        PreparedStatement ps = null;
        String query = "UPDATE detailbarang "
                + "SET stok = stok - ? "
                + "WHERE NODETAIL=? AND IDBARANG = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, detreturbeli.getJUMLAHRETUR());
            ps.setString(2, detreturbeli.getNODETAIL().substring(5));
            ps.setString(3, detreturbeli.getIDBARANG());            
            ps.execute();
            query = "UPDATE barang "
                + "SET stok = stok - ? "
                + "WHERE IDBARANG = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, detreturbeli.getJUMLAHRETUR());
            ps.setString(2, detreturbeli.getIDBARANG());            
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
    public static void addDetailReturPembelian(CDetailRetur detreturbeli, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO DETAIL_RETUR(NORETUR, IDBARANG, NODETAIL,JUMLAHRETUR ) values (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, detreturbeli.getNORETUR());
            ps.setString(2, detreturbeli.getIDBARANG());
            ps.setString(3, detreturbeli.getNODETAIL().substring(5));
            ps.setInt(4, detreturbeli.getJUMLAHRETUR());
            ps.execute();
            updateStokBarangRetur(detreturbeli,connection);
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
    public static void simpanArray(CDetailRetur detreturbeli, Connection connection){
        arrdetretur.add(detreturbeli);
    }
    
    public static void clearArray()
    {
        arrdetretur.clear();
    }

    public static void updateArray(CDetailRetur newdetretbeli,int idx) {
        arrdetretur.set(idx,newdetretbeli);
    }
    public static void updateStokBarangTerimaRetur(int jum, String nodetail, String idbrg, Connection connection)
    {
        PreparedStatement ps = null;
        String query = "UPDATE detailbarang "
                + "SET stok = stok + ? "
                + "WHERE NODETAIL=? AND IDBARANG = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, jum);
            ps.setString(2, nodetail);
            ps.setString(3, idbrg);            
            ps.execute();
            query = "UPDATE barang "
                + "SET stok = stok + ? "
                + "WHERE IDBARANG = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, jum);
            ps.setString(2, idbrg);            
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
    public static void updateTglDapatRetur(String nomor, String tgl, Connection connection) {
        PreparedStatement ps = null;
        String query = "update RETURPEMBELIAN SET TGLDAPATBARANG=? WHERE NORETUR=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tgl);
            ps.setString(2, nomor);
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
}
