package dao;

import beans.CDetailBarang;
import beans.CDetailBarangPenjualan;
import beans.CDetailBeli;
import beans.CDetailJual;
import beans.CKategori;
import beans.CPenjualan;
import static dao.CDaoBarang.getAutoID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import ui.MyConnection;

public class CDaoPenjualan {

    static ArrayList<CDetailJual> arrdetjual = new ArrayList<CDetailJual>();
    static String idbaru;
    public static ArrayList<CDetailJual> getDetail() {
        return arrdetjual;
    }

    public static String getAutoID(Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        String maxikat = "Y0000";
        String strangka = "";
        String query = "SELECT max(IDJUAL) MAXI FROM PENJUALAN ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxikat = rs.getString("MAXI");
            }
            if (maxikat == null) {
                strangka = "Y0001";
            } else {
                strangka = maxikat.substring(1, 5);
                int angka = Integer.parseInt(strangka) + 1;
                strangka = angka + "";
                for (int i = 0; i < 4 - (angka + "").length(); i++) {
                    strangka = "0" + strangka;
                }
                strangka = "Y" + strangka;
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

    public static ArrayList<CDetailBarangPenjualan> getAllDetailBarang(Connection connection, String qry) {
        ArrayList<CDetailBarangPenjualan> listDetailBarang = new ArrayList<>();    
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = qry;
            
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
          
            while (rs.next()) {
                CDetailBarangPenjualan detbrg = new CDetailBarangPenjualan(rs.getString("IDBARANG"), rs.getString("NODETAIL"), rs.getString("DESKRIPSI"),
                        rs.getInt("STOK"), rs.getInt("hrgjualbarang"));
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
    
    
    public static void addPenjualan(CPenjualan penjualan, Connection connection) throws ParseException {
        PreparedStatement ps = null;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date myDate = formatter.parse(penjualan.getTGLJUAL());
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        idbaru = getAutoID(connection);
        String query = "INSERT INTO PENJUALAN(IDJUAL, IDMEMBER, IDPEG,TGLJUAL,DISCJUAL, TOTALHRG ) values (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, idbaru);
            ps.setString(2, penjualan.getIDMEMBER());
            ps.setString(3, penjualan.getIDPEG());
            ps.setDate(4, sqlDate);
            ps.setInt(5, penjualan.getDISCJUAL());
            ps.setInt(6, penjualan.getTOTALHRG());
            ps.execute();
            for (int i = 0; i < arrdetjual.size(); i++) {
                addDetailPenjualan(arrdetjual.get(i), connection);
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

    public static void addDetailPenjualan(CDetailJual dpenjualan, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO DETAIL_JUAL(IDJUAL, IDBARANG, NODETAIL,JUMLAH,HRGJUAL) values ( ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, idbaru);
            ps.setString(2, dpenjualan.getIDBARANG());
            ps.setInt(3, dpenjualan.getNODETAIL());
            ps.setInt(4, dpenjualan.getJUMLAH());
            ps.setInt(5, dpenjualan.getHRGJUAL());
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

    public static int getHitungDetail() {
        return arrdetjual.size();
    }

    public static int hitung_total() //hitung total harga per item yg dibeli brp
    {
        int tot = 0;
        for (int i = 0; i < arrdetjual.size(); i++) {
            tot += arrdetjual.get(i).getHRGJUAL() * arrdetjual.get(i).getJUMLAH();
        }
        return tot;
    }

    public static void removeRows(int idx) {
        arrdetjual.remove(idx);
    }

    public static String getNamaBarang(String aa, Connection connection) {
        String query = "SELECT nmbarang from barang where idbarang='" + aa + "' ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String namabrg = "";
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

    public static String getDescripsiDetailBarang(String aa, String bb, Connection connection) {
        String iddet = bb.substring(5);
        String query = "SELECT deskripsi from detailbarang where nodetail='" + iddet + "' and idbarang='" + aa + "' ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        String namades = "";
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

    public static void simpanArray(CDetailJual detjual, Connection connection) {
        arrdetjual.add(detjual);
    }

    public static void clearArray() {
        arrdetjual.clear();
    }

    public static void updateArray(CDetailJual newdetjual, int idx) {
        arrdetjual.set(idx, newdetjual);
    }

    public static int getTotalByMonth(int id, Connection connection) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        int total = 0;
        String query = "";
        if (id == 1) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Jan%'";
        } else if (id == 2) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Feb%'";
        } else if (id == 3) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Mar%'";
        } else if (id == 4) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Apr%'";
        } else if (id == 5) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%May%'";
        } else if (id == 6) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Jun%'";
        } else if (id == 7) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Jul%'";
        } else if (id == 8) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Aug%'";
        } else if (id == 9) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Sep%'";
        } else if (id == 10) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Oct%'";
        } else if (id == 11) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Nov%'";
        } else if (id == 12) {
            query = "SELECT * FROM penjualan WHERE TGLJUAL LIKE '%Dec%'";
        }
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = total + rs.getInt("TOTALHRG");
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
        return total;
    }

    public static void simpanPenjualan(CPenjualan jual, Connection connection) {
        PreparedStatement ps = null;
        String query = "INSERT INTO PENJUALAN(IDJUAL, IDMEMBER, IDPEG,TGLJUAL,DISCJUAL, TOTALHRG ) values (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            //String idbaru = getAutoID(connection);
            ps.setString(1, jual.getIDJUAL());
            ps.setString(2, jual.getIDMEMBER());
            ps.setString(3, jual.getIDPEG());
            ps.setString(4, jual.getTGLJUAL());
            ps.setInt(5, jual.getTOTALHRG());
            ps.execute();
            for (int i = 0; i < arrdetjual.size(); i++) {
                query = "INSERT INTO DETAIL_JUAL(IDJUAL, IDBARANG, NODETAIL,JUMLAH,HRGJUAL) values ( ?, ?, ?, ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, jual.getIDJUAL());
                ps.setString(2, arrdetjual.get(i).getIDBARANG());
                ps.setInt(3, arrdetjual.get(i).getNODETAIL());
                ps.setInt(4, arrdetjual.get(i).getJUMLAH());
                ps.setInt(5, arrdetjual.get(i).getHRGJUAL());
                ps.execute();
                query = "UPDATE DETAILBARANG SET STOK = STOK - ? WHERE IDBARANG=? AND NODETAIL=? ";
                ps = connection.prepareStatement(query);
                ps.setInt(1, arrdetjual.get(i).getJUMLAH());
                ps.setString(2, arrdetjual.get(i).getIDBARANG());
                ps.setInt(3, arrdetjual.get(i).getNODETAIL());
                ps.execute();
                query = "UPDATE BARANG SET STOK = STOK - ? WHERE IDBARANG=?  ";
                ps = connection.prepareStatement(query);
                ps.setInt(1, arrdetjual.get(i).getJUMLAH());
                ps.setString(2, arrdetjual.get(i).getIDBARANG());
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

    public static void tambah_jumlah_jual(int pketemu, int jumtambah) {
        arrdetjual.get(pketemu).setJUMLAH(arrdetjual.get(pketemu).getJUMLAH() + jumtambah);
    }

}
