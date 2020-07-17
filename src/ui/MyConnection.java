/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rabbit
 */
public class MyConnection {
    private static final String url = "jdbc:mysql://localhost:3306/stationarycz";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }

    public static void closeResource(ResultSet rs, PreparedStatement ps) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }
    
    public static void closeResource(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }
}
