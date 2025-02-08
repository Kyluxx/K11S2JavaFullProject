/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

/**
 *
 * @author Rosita_Nesya
 */
import au.com.bytecode.opencsv.CSVReader;
import java.sql.*;
import java.util.Date;
import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class CSVLoader {
    private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
    private static final String TABLE_REGEX = "\\$\\{table\\}";
    private static final String KEYS_REGEX = "\\$\\{keys\\}";
    private static final String VALUES_REGEX = "\\$\\{values\\}";
    
    private Connection connection;
    private char separator;

    public CSVLoader(Connection connection) {
        this.connection = connection;
        this.separator = ','; // Pemisah bawaan
    }

    public void loadCSV(String csvFile, String tableName, boolean truncateBeforeLoad) throws Exception {
        if (this.connection == null) {
            throw new SQLException("Koneksi tidak valid.");
        }

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile), separator)) {
            String[] headerRow = csvReader.readNext();
            if (headerRow == null) {
                throw new Error("Tidak ada kolom pada berkas CSV.");
            }

            // Membuat placeholder "?" untuk PreparedStatement
            String questionMarks = StringUtils.repeat("?,", headerRow.length);
            questionMarks = questionMarks.substring(0, questionMarks.length() - 1);

            // Membuat query SQL
            String query = SQL_INSERT.replaceAll(TABLE_REGEX, tableName)
                                    .replaceAll(KEYS_REGEX, StringUtils.join(headerRow, ","))
                                    .replaceAll(VALUES_REGEX, questionMarks);

            System.out.println("Query: " + query);

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                connection.setAutoCommit(false);

                // Hapus data lama jika diperlukan
                if (truncateBeforeLoad) {
                    connection.createStatement().execute("TRUNCATE TABLE " + tableName);
                }

                // Proses data CSV per batch
                final int batchSize = 1000;
                int count = 0;
                String[] nextLine;

                while ((nextLine = csvReader.readNext()) != null) {
                    int index = 1;
                    for (String value : nextLine) {
                        Date date = DateUtil.convertToDate(value);
                        if (date != null) {
                            ps.setDate(index++, new java.sql.Date(date.getTime()));
                        } else {
                            ps.setString(index++, value);
                        }
                    }
                    ps.addBatch();

                    if (++count % batchSize == 0) {
                        ps.executeBatch();
                    }
                }

                // Eksekusi batch sisa
                ps.executeBatch();
                connection.commit();
            }
        } catch (FileNotFoundException e) {
            throw new Error("Berkas tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Gagal memuat data ke database: " + e.getMessage());
        }
    }

    // Getter & Setter
    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }
}