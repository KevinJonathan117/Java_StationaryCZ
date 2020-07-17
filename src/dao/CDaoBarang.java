
package dao;

import beans.CBarang;
import beans.CDetailBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ui.MyConnection;


public class CDaoBarang {
    
     public static ArrayList<CBarang> getAllBarang(Connection connection, String qry) {
        ArrayList<CBarang> listBarang = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CBarang brg = new CBarang(rs.getString("IDBARANG"), rs.getString("IDKATEGORI"), rs.getString("IDMEREK"),
                        rs.getString("NMBARANG"), rs.getString("NMGAMBAR"),rs.getInt("HRGJUALBARANG"),rs.getInt("STOK"),rs.getString("STATUS"));
                listBarang.add(brg);
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
        return listBarang;
    }
    
     public static ArrayList<CDetailBarang> getAllDetailBarang(Connection connection, String qry) {
        ArrayList<CDetailBarang> listDetailBarang = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CDetailBarang detbrg = new CDetailBarang(rs.getString("NODETAIL"), rs.getString("IDBARANG"), rs.getString("DESKRIPSI"),
                        rs.getInt("STOK"));
                listDetailBarang.add(detbrg);
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
        return listDetailBarang;
    }
     public static void addBarang(CBarang barang, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO BARANG(IDBARANG, IDKATEGORI, IDMEREK,NMBARANG,NMGAMBAR, HRGJUALBARANG,STOK, STATUS ) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, barang.getIDKATEGORI());
            ps.setString(3, barang.getIDMEREK());
            ps.setString(4, barang.getNMBARANG());
            ps.setString(5, barang.getNMGAMBAR());
            ps.setInt(6, barang.getHRGJUALBARANG());
            ps.setInt(7, barang.getSTOK());
            ps.setString(8, barang.getSTATUS());
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
     
     public static void addDetailBarang(CDetailBarang detbarang, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO DETAILBARANG(NODETAIL, IDBARANG, DESKRIPSI, STOK ) values (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoIDDetail(connection,detbarang.getIDBARANG());
            ps.setString(1, idbaru);
            ps.setString(2, detbarang.getIDBARANG());
            ps.setString(3, detbarang.getDESKRIPSI());
            ps.setInt(4, detbarang.getSTOK());
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
     public static String getAutoID(Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CBarang barang = null;
        String maxibrg = "B0000";
        String strangka = "";
        String query = "SELECT max(IDBARANG) MAXI FROM barang ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxibrg = rs.getString("MAXI");
            }
            strangka = maxibrg.substring(1, 5);
            int angka = Integer.parseInt(strangka) + 1;
            strangka = angka + "";
            for (int i = 0; i < 4 - (angka + "").length(); i++) {
                strangka = "0" + strangka;
            }
            strangka = "I" + strangka;
            JOptionPane.showMessageDialog(null, strangka);
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
     public static String getAutoIDDetail(Connection connection,String idid) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CBarang barang = null;
        int maxibrg=0;
        String strangka = "";
        String query = "SELECT max(nodetail) MAXI FROM detailbarang where IDBARANG='" + idid + "'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxibrg = rs.getInt("MAXI");
            }
            maxibrg++;
            JOptionPane.showMessageDialog(null, maxibrg);
            return maxibrg+"";
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
     
     public static CBarang getBarangById(int id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CBarang brg = null;
        String query = "SELECT * FROM BARANG WHERE IDBARANG = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                brg = new CBarang(rs.getString("IDBARANG"), rs.getString("IDKATEGORI"), rs.getString("IDMEREK"),
                        rs.getString("NMBARANG"), rs.getString("NMGAMBAR"),rs.getInt("HRGJUALBARANG"),rs.getInt("STOK"),
                        rs.getString("STATUS"));
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
        return brg;
    }
     
     
     public static void updateBarang(CBarang barang, Connection connection) {
        PreparedStatement ps = null;
        String query = "UPDATE barang "
                + "SET IDKATEGORI = ?, IDMEREK = ?, NMBARANG = ?, NMGAMBAR = ?, HRGJUALBARANG = ?, STOK = ?, STATUS = ?"
                + "WHERE IDBARANG = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, barang.getIDKATEGORI());
            ps.setString(2, barang.getIDMEREK());
            ps.setString(3, barang.getNMBARANG());
            ps.setString(4, barang.getNMGAMBAR());
            ps.setInt(5, barang.getHRGJUALBARANG());
            ps.setInt(6, barang.getSTOK());
            ps.setString(7, barang.getSTATUS());
            ps.setString(8, barang.getIDBARANG());
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
          
     public static void deleteBarang(String ID, Connection connection) {
        PreparedStatement ps = null;
        String query = "DELETE FROM barang "
                + "WHERE idbarang = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void UpdateDetailBarang(CDetailBarang newdetbrg, Connection connection) {
        PreparedStatement ps = null;
        String query = "UPDATE detailbarang "
                + "SET deskripsi = ?, stok = ? "
                + "WHERE NODETAIL=? AND IDBARANG = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, newdetbrg.getDESKRIPSI());
            ps.setInt(2, newdetbrg.getSTOK());
            ps.setString(3, newdetbrg.getNODETAIL());
            ps.setString(4, newdetbrg.getIDBARANG());            
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
