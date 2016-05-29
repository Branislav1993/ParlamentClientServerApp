/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.gui.models;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.silab.domain.Party;

/**
 *
 * @author Branislav Vidojevic
 */
public class PartiesTableModel extends AbstractTableModel {

    private static final String[] columns = new String[]{"ID", "Name"};
    private List<Party> parties;

    public PartiesTableModel(List<Party> parties) {
        if (parties == null) {
            this.parties = new LinkedList<>();
        } else {
            this.parties = parties;
        }
    }

    @Override
    public int getRowCount() {
        return parties.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Party p = parties.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getName();
            default:
                return "NN";
        }
    }

    public Party getPartyByIndex(int index) {
         if (index >= parties.size() || index < 0) {
            return null;
        }
        return parties.get(index);
    }
    
    public void deletePartyByIndex(int index) {
        parties.remove(index);
        fireTableDataChanged();
    }

}
