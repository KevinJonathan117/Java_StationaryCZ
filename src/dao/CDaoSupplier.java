
package dao;

import beans.CSupplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ui.MyConnection;

public class CDaoSupplier {
    
    public static ArrayList<CSupplier> getAllSupplier(Connection connection, String qry) {
        ArrayList<CSupplier> listSupplier = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CSupplier sup = new CSupplier(rs.getString("IDSUPPLIER"),
                        rs.getString("NMSUPPLIER"), rs.getString("ALAMAT"),
                        rs.getString("TELP"),  rs.getString("STATUS"));
                listSupplier.add(sup);
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
        return listSupplier;
    }
    
    public static void addSupplier(CSupplier sup, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO SUPPLIER(IDSUPPLIER, NMSUPPLIER, ALAMAT,TELP,STATUS) values (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, sup.getNMSUPPLIER());
            ps.setString(3, sup.getALAMAT());
            ps.setString(4, sup.getTELP());
            ps.setString(5, sup.getSTATUS());
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
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
        CSupplier sup = null;
        String maxisup = "S0000";
        String strangka="";
        String query = "SELECT max(IDSUPPLIER) MAXI FROM supplier ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxisup = rs.getString("MAXI");
            }
            strangka = maxisup.substring(1,5);
            int angka = Integer.parseInt(strangka)+1;
            strangka = angka+"";
            for (int i = 0; i < 4- (angka+"").length(); i++) {
                strangka = "0" + strangka;
            }
            strangka = "S" + strangka;
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
    public static CSupplier getSupplierById(int id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CSupplier sup = null;
        String query = "SELECT * FROM supplier WHERE idsupplier = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                sup = new CSupplier(rs.getString("IDSUPPLIER"),
                        rs.getString("NMSUPPLIER"),
                        rs.getString("ALAMAT"),
                        rs.getString("TELP"),
                        rs.getString("STATUS")
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } finally {
            try {
                MyConnection.closeResource(rs, ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return sup;
    }
    public static void updateSupplier(CSupplier sup, Connection connection){
        PreparedStatement ps = null;
        String query = "UPDATE supplier "
                + "SET NMSUPPLIER = ?, ALAMAT = ?, TELP = ? ,  STATUS = ? "
                + "WHERE IDSUPPLIER = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, sup.getNMSUPPLIER());
            ps.setString(2, sup.getALAMAT());
            ps.setString(3, sup.getTELP());
            ps.setString(4, sup.getSTATUS());
            ps.setString(5, sup.getIDSUPPLIER());
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }finally{
            try {
                MyConnection.closeResource(ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void deleteSupplier(String ID, Connection connection){
        PreparedStatement ps = null;
        String query = "DELETE FROM supplier "
                + "WHERE IDSUPPLIER = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,ID);            
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }finally{
            try {
                MyConnection.closeResource(ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static String getNamaSupplier(String aa, Connection connection){
        String query = "SELECT nmsupplier from supplier where idsupplier='" + aa + "' ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String namasup="";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                namasup = rs.getString("nmsupplier");
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
        return namasup;
    }
    public static String getIdSupplier(String aa, Connection connection){
        String query = "SELECT idsupplier from supplier where  nmsupplier='" +aa+ "'";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String idsup="";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                idsup = rs.getString("idsupplier");
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
        return idsup;
    }
}
