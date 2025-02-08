/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JBDC;
import java.sql.*;

/**
 * @author kyluxx
 */
public class JDBCMySQLDemo {
    
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = 
    "jdbc:mysql://mysql-kyluxx.alwaysdata.net/kyluxx_db";
    private static final String USER = "kyluxx";
    private static final String PASS = "goatedKY!";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String sql;
        try {
            // Langkah 1: Registrasi Driver dan Koneksi ke MySQL
            Class.forName(JDBC_DRIVER);
            System.out.println("Menghubungkan ke MySQL...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Berhasil menghubungkan ke MySQL...");
            stmt = conn.createStatement();
            // Langkah 2: Membuat Database
            /*
            System.out.println("Membuat database dbfokoBuku...");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS dbfokoBuku";
            stmt.executeUpdate(sql);
            System.out.println("Berhasil membuat database dbfokoBuku...");
            
            // Langkah 3: Mengakses Database
            System.out.println("Mengakses database dbfokoBuku...");
            sql = "USE dbfokoBuku";
            stmt.executeUpdate(sql);
            System.out.println("Berhasil mengakses database dbfokoBuku...");
            */

            // Langkah 4: Membuat Tabel
            System.out.println("Membuat tabel tbBarang...");
            sql = "CREATE TABLE IF NOT EXISTS tbBarangC ("
                + "kodeBrg CHAR(5) NOT NULL, "
                + "namaBrg VARCHAR(50), "
                + "satuanBrg VARCHAR(8), "
                + "hargaBrg INTEGER, "
                + "PRIMARY KEY(kodeBrg))";
            stmt.executeUpdate(sql);
            System.out.println("Tabel tbBarang berhasil dibuat...");

            // Truncating table first to make sure it doesnt overlap (the data)
            System.out.println("Truncating tabel tbBarang...");
            sql = "TRUNCATE TABLE tbBarangC";
            stmt.executeUpdate(sql);
            System.out.println("Tabel tbBarang berhasil di-truncate...");
            
            // Langkah 5: Insert Data
            System.out.println("Memasukkan data ke tbBarang...");
            String[] insertQueries = {
                "INSERT INTO tbBarangC VALUES ('PS-01', 'Pensil 2B FABER CASTELL', 'Pos', 2500)",
                "INSERT INTO tbBarangC VALUES ('PS-02', 'Pensil 2B STAEDTLER', 'Pos', 2500)",
                "INSERT INTO tbBarangC VALUES ('PH-01', 'Penghapus FABER CASTELL', 'Pos', 2500)",
                "INSERT INTO tbBarangC VALUES ('KR-01', 'Kertas A4 PAPER ONE', 'Rim', 25000)"
            };
            for (String query : insertQueries) {
                stmt.executeUpdate(query);
            }
            System.out.println("Data berhasil dimasukkan...");

            // Langkah 6: Tampilkan Data Awal
            System.out.println("\nData Awal:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbBarangC");
            while (rs.next()) {
                System.out.print("Kode: " + rs.getString("kodeBrg"));
                System.out.print(", Nama: " + rs.getString("namaBrg"));
                System.out.print(", Satuan: " + rs.getString("satuanBrg"));
                System.out.println(", Harga: " + rs.getInt("hargaBrg"));
            }
            rs.close();

            // Langkah 7: Update Data PS-02
            System.out.println("\nMengubah harga PS-02...");
            stmt.executeUpdate("UPDATE tbBarang SET hargaBrg=2000 WHERE kodeBrg='PS-02'");
            System.out.println("Harga PS-02 berhasil diubah!");

            // Langkah 8: Hapus Data PS-02
            System.out.println("\nMenghapus data PS-02...");
            stmt.executeUpdate("DELETE FROM tbBarang WHERE kodeBrg='PS-02'");
            System.out.println("Data PS-02 berhasil dihapus!");

            // Langkah 9: Tampilkan Data Akhir
            System.out.println("\nData Akhir:");
            rs = stmt.executeQuery("SELECT * FROM tbBarangC");
            while (rs.next()) {
                System.out.print("Kode: " + rs.getString("kodeBrg"));
                System.out.print(", Nama: " + rs.getString("namaBrg"));
                System.out.print(", Satuan: " + rs.getString("satuanBrg"));
                System.out.println(", Harga: " + rs.getInt("hargaBrg"));
            }
            rs.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Tutup koneksi dan statement
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("\nKoneksi ditutup. Sampai jumpa!");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}