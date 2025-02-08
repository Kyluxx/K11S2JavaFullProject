package JTable;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author kyluxx
 */
public class JurusanCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(SwingConstants.CENTER);
        String jurusan = (String) value;
        if (jurusan.equals("KA")) {
            setText("Komputer Akuntansi");
        } else if (jurusan.equals("SI")) {
            setText("Sistem Informasi");
        } else {
            setText("Tidak diketahui");
        }
        return this;
    }
}