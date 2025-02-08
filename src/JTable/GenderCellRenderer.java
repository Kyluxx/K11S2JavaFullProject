package JTable;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author kyluxx
 */
public class GenderCellRenderer extends DefaultTableCellRenderer {
    private Icon priaIcon;
    private Icon wanitaIcon;

    public GenderCellRenderer() {
        super();
        // Menggunakan path relatif yang benar dan memperhatikan case sensitivity
        priaIcon = new ImageIcon(getClass().getResource("./male-3-16.png"));
        wanitaIcon = new ImageIcon(getClass().getResource("./female-16.png"));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Handle null value dan tipe data tidak valid
        if (value instanceof Boolean) {
            Boolean isPria = (Boolean) value;
            if (isPria) {
                setIcon(priaIcon);
                setText("Pria");
            } else {
                setIcon(wanitaIcon);
                setText("Wanita");
            }
        } else {
            setIcon(null);
            setText("Tidak valid");
        }
        
        return this;
    }
}