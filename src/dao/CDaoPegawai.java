
package dao;

import beans.CPegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ui.MyConnection;

public class CDaoPegawai {
    
    public static ArrayList<CPegawai> getAllPegawai(Connection connection , String qry) {
        ArrayList<CPegawai> listPegawai = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CPegawai peg = new CPegawai(rs.getString("IDPEG"),
                        rs.getString("IDJABATAN"), rs.getString("NMPEG"),
                        rs.getString("USERNAME"), rs.getString("PASSWORD"),
                        rs.getString("STATUS"));
                listPegawai.add(peg);
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
        return listPegawai;
    }
    
    public static void addPegawai(CPegawai peg, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO PEGAWAI(IDPEG, IDJABATAN, NMPEG,USERNAME,PASSWORD,STATUS) values (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            String idbaru = getAutoID(connection);
            ps.setString(1, idbaru);
            ps.setString(2, peg.getIDJABATAN());
            ps.setString(3, peg.getNMPEG());
            ps.setString(4, peg.getUSERNAME());
            ps.setString(5, peg.getPASSWORD());
            ps.setString(6, peg.getSTATUS());
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
        CPegawai peg = null;
        String maxipeg = "P0000";
        String strangka="";
        String query = "SELECT max(idpeg) MAXI FROM pegawai ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxipeg = rs.getString("MAXI");
            }
            strangka = maxipeg.substring(1,5);
            int angka = Integer.parseInt(strangka)+1;
            strangka = angka+"";
            for (int i = 0; i < 4- (angka+"").length(); i++) {
                strangka = "0" + strangka;
            }
            strangka = "P" + strangka;
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
    public static CPegawai getPegawaiById(int id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        CPegawai peg = null;
        String query = "SELECT * FROM pegawai WHERE IDPEG = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                peg = new CPegawai(rs.getString("IDPEG"),
                        rs.getString("IDJABATAN"),
                        rs.getString("NMPEG"),
                        rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
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
        return peg;
    }
    public static void updatePegawai(CPegawai peg, Connection connection){
        PreparedStatement ps = null;
        String query = "UPDATE pegawai "
                + "SET IDJABATAN = ? , NMPEG = ? , USERNAME = ? , PASSWORD = ? , STATUS = ? "
                + "WHERE IDPEG = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, peg.getIDJABATAN());
            ps.setString(2, peg.getNMPEG());
            ps.setString(3, peg.getUSERNAME());
            ps.setString(4, peg.getPASSWORD());
            ps.setString(5, peg.getSTATUS());
            ps.setString(6, peg.getIDPEG());
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
    
    public static void deletePegawai(String ID, Connection connection) {
        PreparedStatement ps = null;
        String query = "DELETE FROM Pegawai WHERE IDPEG = ?";
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
