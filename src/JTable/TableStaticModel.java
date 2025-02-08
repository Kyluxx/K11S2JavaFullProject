/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JTable;

import java.awt.Color;
import javax.swing.table.AbstractTableModel;

public class TableStaticModel extends AbstractTableModel {
    private final String[] columnNames = {"Nama", "Jurusan", "Tinggi", "Gender", "Warna", "IPK", "DoB"};
    
    private final Object[][] data = {
        {"Hendri Julianior", "SI", 150, true, Color.RED, 2.5f, "1996-09-30"},         // Diperbaiki: new Integer() → autoboxing, Color.red → Color.RED
        {"Josephine Liolim", "KA", 165, false, new Color(0xFFCCFF), 2.8f, "1996-08-17"},
        {"Hanjusri", "KA", 170, true, new Color(0xFFCC00), 3.8f, "1995-12-25"},
        {"Henry Limantara", "SI", 150, false, Color.RED, 1.5f, "1996-05-01"},
        {"Fiska Amelia", "KA", 150, false, Color.GREEN, 1.8f, "1996-02-14"},          // Diperbaiki: Color.green → Color.GREEN
        {"Wijaya Rimba", "KA", 175, true, Color.BLUE, 3.8f, "1995-11-25"}             // Diperbaiki: Color.blue → Color.BLUE
    };

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];  // Ditambahkan: Implementasi method getValueAt
    }

/* JTable menggunakan ini untuk menentukan default renderer/editor
 * untuk setiap sel. Jika kita tidak mengimplementasikan ini, maka
 * kolom terakhir akan berisi teks ("true"/"false"), daripada sebuah
 * check box.
 */
public Class getColumnClass(int c) {
    return getValueAt(0, c).getClass();
}

/* Tidak perlu mengimplementasikan metode ini kecuali Anda menginginkan
 * tabel Anda bisa diedit (editable).
 */
public boolean isCellEditable(int row, int col) {
    // Ingat, alamat data/cell adalah tetap,
    // tidak peduli di mana cell muncul di layar.
    // Perintah ini membuat kolom 1 tidak bisa diedit
    if (col < 1) {
        return false;
    } else {
        return true;
    }
}

/* Tidak perlu mengimplementasikan metode ini kecuali Anda menginginkan
 * data tabel Anda bisa diubah (changeable).
 */
public void setValueAt(Object value, int row, int col) {
    data[row][col] = value;
    fireTableCellUpdated(row, col);
}
    
}