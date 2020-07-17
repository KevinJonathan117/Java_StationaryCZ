package dao;

import beans.CKategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ui.MyConnection;

public class CDaoKategori {

    public static ArrayList<CKategori> getAllKategori(Connection connection, String qry) {
        ArrayList<CKategori> listKategori = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CKategori merek = new CKategori(rs.getString("IDKATEGORI"),
                        rs.getString("NMKATEGORI"), rs.getString("STATUS"));
                listKategori.add(merek);
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
        return listKategori;
    }

    public static void addKategori(CKategori kategori, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO KATEGORI(IDKATEGORI, NMKATEGORI, STATUS) values (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, kategori.getNMKATEGORI());
            ps.setString(3, kategori.getSTATUS());
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
        CKategori kategori = null;
        String maxikat = "K0000";
        String strangka = "";
        String query = "SELECT max(IDKATEGORI) MAXI FROM kategori ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxikat = rs.getString("MAXI");
            }
            strangka = maxikat.substring(1, 5);
            int angka = Integer.parseInt(strangka) + 1;
            strangka = angka + "";
            for (int i = 0; i < 4 - (angka + "").length(); i++) {
                strangka = "0" + strangka;
            }
            strangka = "K" + strangka;
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

    public static CKategori getKategoriById(String id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CKategori kat = null;
        String query = "SELECT * FROM KATEGORI WHERE IDKATEGORI = ? OR NMKATEGORI=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, id);            
            rs = ps.executeQuery();
            while (rs.next()) {
                kat = new CKategori(rs.getString("IDKATEGORI"),
                        rs.getString("NMKATEGORI"),
                        rs.getString("STATUS")
                );
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
        return kat;
    }

    public static void updateKategori(CKategori kategori, Connection connection) {
        PreparedStatement ps = null;
        String query = "UPDATE kategori "
                + "SET NMKATEGORI = ?,  STATUS = ? "
                + "WHERE IDKATEGORI = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, kategori.getNMKATEGORI());
            ps.setString(2, kategori.getSTATUS());
            ps.setString(3, kategori.getIDKATEGORI());
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

    public static void deleteKategori(String ID, Connection connection) {
        PreparedStatement ps = null;
        String query = "DELETE FROM kategori "
                + "WHERE idkategori = ?";
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
}
