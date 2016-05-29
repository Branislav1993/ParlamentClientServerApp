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
public class AddMemberPartiesTableModel extends AbstractTableModel {

    private List<Party> parties;
    private static final String[] columns = new String[]{"Party name"};

    public AddMemberPartiesTableModel(List<Party> parties) {
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
                return p.getName();
            default:
                return "NN";
        }
    }

    public Party getPartyByIndex(int index) {
        return parties.get(index);
    }

}
