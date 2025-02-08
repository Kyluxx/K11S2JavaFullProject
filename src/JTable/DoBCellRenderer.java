package JTable;


import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class DoBCellRenderer extends DefaultTableCellRenderer {

    private Date doBValue;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(SwingConstants.CENTER);

        if (value instanceof String) {
            String doB = (String) value;

            try {
                doBValue = new SimpleDateFormat("yyyy-MM-dd").parse(doB);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (doBValue != null) {
                setText(new SimpleDateFormat("dd-MMM-yyyy").format(doBValue));
            } else {
                setText(doB); // Tampilkan tanggal asli jika gagal di-parse
            }
        }


        return this;
    }
}