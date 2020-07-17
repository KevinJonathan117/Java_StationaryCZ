
package dao;

import beans.CMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ui.MyConnection;

public class CDaoMember {
    
    public static ArrayList<CMember> getAllMember(Connection connection, String qry) {
        ArrayList<CMember> listMember = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMember mem = new CMember(rs.getString("IDMEMBER"),
                        rs.getString("NMMEMBER"), rs.getString("HPMEMBER"),
                        rs.getInt("SALDOMEMBER"),  rs.getString("STATUS"));
                listMember.add(mem);
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
        return listMember;
    }
    
    public static void addMember(CMember mem, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO MEMBER(IDMEMBER, NMMEMBER, HPMEMBER,SALDOMEMBER,STATUS) values (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, mem.getNMMEMBER());
            ps.setString(3, mem.getHPMEMBER());
            ps.setInt(4, mem.getSALDOMEMBER());
            ps.setString(5, mem.getSTATUS());
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
        CMember mem = null;
        String maximem = "M0000";
        String strangka="";
        String query = "SELECT max(idmember) MAXI FROM member ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maximem = rs.getString("MAXI");
            }
            strangka = maximem.substring(1,5);
            int angka = Integer.parseInt(strangka)+1;
            strangka = angka+"";
            for (int i = 0; i < 4- (angka+"").length(); i++) {
                strangka = "0" + strangka;
            }
            strangka = "M" + strangka;
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
    public static CMember getMemberById(int id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CMember mem = null;
        String query = "SELECT * FROM Member WHERE IDMEMBER = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                mem = new CMember(rs.getString("IDMEMBER"),
                        rs.getString("NMMEMBER"),
                        rs.getString("HPMEMBER"),
                        rs.getInt("SALDOMEMBER"),
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
        return mem;
    }
    public static void updateMember(CMember mem, Connection connection){
        PreparedStatement ps = null;
        String query = "UPDATE member "
                + "SET NMMEMBER = ?, HPMEMBER = ?, SALDOMEMBER = ? ,  STATUS = ? "
                + "WHERE IDMEMBER = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, mem.getNMMEMBER());
            ps.setString(2, mem.getHPMEMBER());
            ps.setInt(3, mem.getSALDOMEMBER());
            ps.setString(4, mem.getSTATUS());
            ps.setString(5, mem.getIDMEMBER());
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
    public static void deleteMember(String ID, Connection connection) {
        PreparedStatement ps = null;
        String query = "DELETE FROM Member "
                + "WHERE idmember = ?";
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
