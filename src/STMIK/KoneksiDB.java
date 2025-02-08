package STMIK;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rosita_Nesya
 */

import java.sql.*;
public class KoneksiDB {

    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                //String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                String url = 
    "jdbc:mysql://mysql-kyluxx.alwaysdata.net/kyluxx_db";

                String user = "kyluxx";
                String password = "goatedKY!";

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // Updated driver class name
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error membuat koneksi!!!");
            }
        }
        return koneksi;
    }
}