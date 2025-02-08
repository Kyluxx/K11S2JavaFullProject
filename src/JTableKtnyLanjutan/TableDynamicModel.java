package JTableKtnyLanjutan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rosita_Nesya
 */
public class TableDynamicModel extends AbstractTableModel {

    private List<String> columnNames = new ArrayList<>();
    private List<List> data = new ArrayList<>();

    {
        columnNames.add("Nama");
        columnNames.add("Jurusan");
        columnNames.add("Umur");
        columnNames.add("Jenis Kelamin");
    }

    public void addRow(List rowData) {
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        try {
            return columnNames.get(col);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row).get(col);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data.get(row).set(col, value);
        fireTableDataChanged();
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
    