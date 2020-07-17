
package dao;

import beans.CMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ui.MyConnection;


public class CDaoTopUp {
    
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
    
     public static CMember getMemberById(String id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CMember mem = null;
        String query = "SELECT * FROM Member WHERE IDMEMBER = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
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
    
    
    public static void updateSaldoMember(CMember mem,int saldotambahan, Connection connection){
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
    
    
    
   }
