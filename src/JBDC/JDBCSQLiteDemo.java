/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JBDC;
// import paket pustaka yang diperlukan
import java.sql.*;

/**
 *
 * @author kyluxx
 */

public class JDBCSQLiteDemo {
    // nama driver JDBC dan URL database
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:dbTokoBuku.db";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // mendaftarkan driver JDBC
            Class.forName(JDBC_DRIVER);

            // melakukan koneksi untuk membuat database
            System.out.println("Menghubungkan ke database dbTokoBuku...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Berhasil terhubung ke database dbTokoBuku...");

            //Clear old file dulu
            stmt = conn.createStatement();
            String sql = "DROP TABLE tbBarang";
            stmt.executeUpdate(sql);
            System.out.println("Tabel tbBarang berhasil di remove");
            // eksekusi query untuk membuat tabel
            System.out.println("Membuat tabel tbBarang dalam dbTokoBuku...");
            stmt = conn.createStatement();
            sql = "CREATE TABLE tbBarang (KodeBrg TEXT NOT NULL, " +
                         "namaBrg TEXT, satuanBrg TEXT, " +
                         "hargaBrg INT, PRIMARY KEY(KodeBrg))";
            stmt.executeUpdate(sql);
            System.out.println("Tabel tbBarang berhasil dibuat...");

            // eksekusi query untuk memasukkan data ke tabel
            stmt = conn.createStatement();
            System.out.println("Memasukkan record-record ke tbBarang...");
            sql = "INSERT INTO tbBarang VALUES " +
                  "('PS-01', 'Pensil 2B FABER CASTELL', 'Pos', 2500)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO tbBarang VALUES " +
                  "('PS-02', 'Pensil 2B STADDTLER', 'Pos', 2500)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO tbBarang VALUES " +
                  "('PH-01', 'Penghapus FABER CASTELL', 'Pos', 2500)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO tbBarang VALUES " +
                  "('KR-01', 'Kertas A4 PAPER ONE', 'Rim', 25000)";
            stmt.executeUpdate(sql);

            System.out.println("Record-record berhasil dimasukkan...");

            // eksekusi query untuk menampilkan data-data tadi
            sql = "SELECT kodeBrg, namaBrg, satuanBrg, hargaBrg FROM tbBarang";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // ambil berdasarkan nama kolom
                String kodeBrg = rs.getString("kodeBrg");
                String namaBrg = rs.getString("namaBrg");
                String satuanBrg = rs.getString("satuanBrg");
                int hargaBrg = rs.getInt("hargaBrg");

                // tampilkan nilainya
                System.out.print("Kode Barang: " + kodeBrg);
                System.out.print(", Nama Barang: " + namaBrg);
                System.out.print(", Satuan Barang: " + satuanBrg);
                System.out.println(", Harga Barang: " + hargaBrg);
            }

            rs.close();

            // eksekusi query untuk mengubah data kodeBrg=PS-02
            System.out.println("Mengubah record-record kodeBrg=PS-02...");
            sql = "UPDATE tbBarang SET hargaBrg=2000 WHERE kodeBrg='PS-02'";
            stmt.executeUpdate(sql);
            System.out.println("Record kodeBrg=PS-02 berhasil diubah...");

            // eksekusi query untuk menampilkan data-data tadi
            sql = "SELECT kodeBrg, namaBrg, satuanBrg, hargaBrg FROM tbBarang";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // ambil berdasarkan nama kolom
                String kodeBrg = rs.getString("kodeBrg");
                String namaBrg = rs.getString("namaBrg");
                String satuanBrg = rs.getString("satuanBrg");
                int hargaBrg = rs.getInt("hargaBrg");

                // tampilkan nilainya
                System.out.print("Kode Barang: " + kodeBrg);
                System.out.print(", Nama Barang: " + namaBrg);
                System.out.print(", Satuan Barang: " + satuanBrg);
                System.out.println(", Harga Barang: " + hargaBrg);
            }

            rs.close();

            // eksekusi query untuk menghapus data
            System.out.println("Menghapus record kodeBrg=PS-02...");
            sql = "DELETE FROM tbBarang WHERE kodeBrg='PS-02'";
            stmt.executeUpdate(sql);
            System.out.println("Record kodeBrg=PS-02 berhasil dihapus...");

            // eksekusi query untuk menampilkan data-data tadi
            sql = "SELECT kodeBrg, namaBrg, satuanBrg, hargaBrg FROM tbBarang";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // ambil berdasarkan nama kolom
                String kodeBrg = rs.getString("kodeBrg");
                String namaBrg = rs.getString("namaBrg");
                String satuanBrg = rs.getString("satuanBrg");
                int hargaBrg = rs.getInt("hargaBrg");

                // tampilkan nilainya
                System.out.print("Kode Barang: " + kodeBrg);
                System.out.print(", Nama Barang: " + namaBrg);
                System.out.print(", Satuan Barang: " + satuanBrg);
                System.out.println(", Harga Barang: " + hargaBrg);
            }

            rs.close();
        } catch (SQLException se) {
            // penanganan error untuk JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // penanganan error untuk Class.forName
            e.printStackTrace();
        } finally {
            // blok finally digunakan untuk menutup koneksi
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                // tidak ada yang bisa kita lakukan
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // akhir finally
        } // akhir try
        System.out.println("Sampai jumpa!");
    } // akhir main
} // akhir JDBCSQLiteDemo