
package dao;

import beans.CJabatan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ui.MyConnection;

public class CDaoJabatan {
    
    public static ArrayList<CJabatan> getAllJabatan(Connection connection) {
        ArrayList<CJabatan> listJabatan = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = "SELECT * FROM jabatan ";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CJabatan jab = new CJabatan(rs.getString("IDJABATAN"),
                        rs.getString("NMJABATAN"));
                listJabatan.add(jab);
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
        return listJabatan;
    }
    
    public static ArrayList<CJabatan> getJabatan(Connection connection) {
        ArrayList<CJabatan> listJabat = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = "SELECT * FROM jabatan WHERE idjabatan != 'J1'";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CJabatan jab = new CJabatan(rs.getString("IDJABATAN"),
                        rs.getString("NMJABATAN"));
                listJabat.add(jab);
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
        return listJabat;
    }
    
    public static CJabatan getJabatanById(int id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CJabatan jab = null;
        String query = "SELECT * FROM jabatan WHERE idpeg = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next ()) {
                jab = new CJabatan(rs.getString("IDJABATAN"),
                        rs.getString("NMJABATAN")
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
        return jab;
    }
    public static void updateJabatan(CJabatan peg, Connection connection){
        PreparedStatement ps = null;
        String query = "UPDATE pegawai "
                + "SET NMJABATAN = ? "
                + "WHERE IDJABATAN = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, peg.getNMJABATAN());
            ps.setString(2, peg.getIDJABATAN());
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
