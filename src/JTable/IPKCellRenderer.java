/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JTable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Rosita_Nesya
 */
public class IPKCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(SwingConstants.CENTER);

        if (value instanceof Float) {
            float ipk = (Float) value;

            if (ipk >= 3) {
                setForeground(Color.blue);
            } else if (ipk >= 2) {
                setForeground(Color.green);
            } else {
                setForeground(Color.red);
            }

            setText(String.format("%.2f", ipk));
        }


        return this;
    }
}