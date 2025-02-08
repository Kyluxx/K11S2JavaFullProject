package JTable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author kyluxx
 */
public class WarnaCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Handle nilai warna dan tipe data
        if (value instanceof Color) {
            Color warna = (Color) value;
            if (isSelected) {
                // Tetap pertahankan warna selection default untuk highlight
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(warna);
            }
        } else {
            // Fallback untuk nilai non-Color
            setBackground(table.getBackground());
        }
        
        // Reset text untuk menghindari tampilan nilai objek
        setText("");
        return this;
    }
}