/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;
import java.sql.*;
/**
 *
 * @author Rosita_Nesya
 */
public class CSVToDatabase {
    // driver dan url database
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBC_CONNECTION_URL = 
    "jdbc:mysql://mysql-kyluxx.alwaysdata.net/kyluxx_db";

    static final String USER = "kyluxx";
    static final String PASS = "goatedKY!";

    public static void main(String[] args) {
        try {
            CSVLoader loader = new CSVLoader(getCon());
            loader.loadCSV("src/CSV/JAVADATA.csv", "tbBarang", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection getCon() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_CONNECTION_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
