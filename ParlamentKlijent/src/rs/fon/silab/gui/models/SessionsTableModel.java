/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.gui.models;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.silab.domain.PlenarySession;

/**
 *
 * @author Branislav Vidojevic
 */
public class SessionsTableModel extends AbstractTableModel {

    private static final String[] columns = new String[]{"ID", "Date"};
    private List<PlenarySession> sessions;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

    public SessionsTableModel(List<PlenarySession> sessions) {
        if (sessions == null) {
            this.sessions = new LinkedList<>();
        } else {
            this.sessions = sessions;
        }
    }

    @Override
    public int getRowCount() {
        return sessions.size();
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
        PlenarySession s = sessions.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return SDF.format(s.getDate());
            default:
                return "NN";
        }
    }

    public PlenarySession getSessionByIndex(int index) {
        if (index >= sessions.size() || index < 0) {
            return null;
        }
        return sessions.get(index);
    }

    public void deleteSessionByIndex(int index) {
        sessions.remove(index);
        fireTableDataChanged();
    }

    public List<PlenarySession> getSessions() {
        return sessions;
    }
}
