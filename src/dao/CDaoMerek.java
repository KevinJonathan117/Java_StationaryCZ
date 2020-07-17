
package dao;

import beans.CMerek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ui.MyConnection;

public class CDaoMerek {
    
    public static ArrayList<CMerek> getAllMerek(Connection connection, String qry) {
        ArrayList<CMerek> listMerek = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMerek merek = new CMerek(rs.getString("IDMEREK"),
                        rs.getString("NMMEREK"),rs.getString("STATUS"));
                listMerek.add(merek);
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
        return listMerek;
    }
    
    public static void addMerek(CMerek merek, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO MEREK(IDMEREK, NMMEREK, STATUS) values (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, merek.getNMMEREK());
            ps.setString(3, merek.getSTATUS());
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
        CMerek merek = null;
        String maxisup = "S0000";
        String strangka="";
        String query = "SELECT max(IDMEREK) MAXI FROM merek ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxisup = rs.getString("MAXI");
            }
            strangka = maxisup.substring(2,5);
            int angka = Integer.parseInt(strangka)+1;
            strangka = angka+"";
            for (int i = 0; i < 3- (angka+"").length(); i++) {
                strangka = "0" + strangka;
            }
            strangka = "ME" + strangka;
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
    public static CMerek getMerekById(String id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CMerek sup = null;
        String query = "SELECT * FROM Merek WHERE IDMEREK = ? or NMMEREK = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                sup = new CMerek(rs.getString("IDMEREK"),
                        rs.getString("NMMEREK"),
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
        return sup;
    }
    public static void updateMerek(CMerek merek, Connection connection){
        PreparedStatement ps = null;
        String query = "UPDATE Merek "
                + "SET NMMEREK = ?,  STATUS = ? "
                + "WHERE IDMEREK = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, merek.getNMMEREK());
            ps.setString(2, merek.getSTATUS());
            ps.setString(3, merek.getIDMEREK());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                MyConnection.closeResource(ps);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void deleteMerek(String ID, Connection connection) {
        PreparedStatement ps = null;
        String query = "DELETE FROM merek "
                + "WHERE idmerek = ?";
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
