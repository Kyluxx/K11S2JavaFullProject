/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

/**
 *
 * @author Rosita_Nesya
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {

    // Daftar semua format date yang ingin diurai
    private static List<SimpleDateFormat> dateFormats = new ArrayList<>();

    static {
        dateFormats.add(new SimpleDateFormat("M/dd/yyyy"));
        dateFormats.add(new SimpleDateFormat("dd.M.yyyy"));
        dateFormats.add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
        dateFormats.add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
        dateFormats.add(new SimpleDateFormat("dd.MMM.yyyy"));
        dateFormats.add(new SimpleDateFormat("dd-MMM-yyyy"));
        dateFormats.add(new SimpleDateFormat("dd-MM-yyyy"));
    }

    /**
     * Konversi berbagai format String ke java.util.Date
     *
     * @param input Date sebagai string
     * @return objek java.util.Date jika input string terurai dengan sukses, jika tidak return null
     */
    public static Date convertToDate(String input) {
        if (input == null) {
            return null;
        }

        for (SimpleDateFormat format : dateFormats) {
            try {
                format.setLenient(false);
                return format.parse(input);
            } catch (ParseException e) {
                // Coba format lainnya
            }
        }

        return null; // Jika tidak ada format yang cocok
    }
}