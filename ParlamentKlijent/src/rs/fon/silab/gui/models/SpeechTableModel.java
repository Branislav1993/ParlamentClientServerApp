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
import rs.silab.domain.Speech;

/**
 *
 * @author Branislav Vidojevic
 */
public class SpeechTableModel extends AbstractTableModel {

    private static final String[] columns = new String[]{"ID", "Member name", "Session date"};
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    private List<Speech> speeches;

    public SpeechTableModel(List<Speech> speeches) {
        if (speeches == null) {
            this.speeches = new LinkedList<>();
        } else {
            this.speeches = speeches;
        }
    }

    @Override
    public int getRowCount() {
        return speeches.size();
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
        Speech s = speeches.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return s.getMember().getName() + " " + s.getMember().getLastName();
            case 2:
                return SDF.format(s.getSessionDate());
            default:
                return "NN";
        }
    }

    public Speech getSpeechByIndex(int index) {
        if (index >= speeches.size() || index < 0) {
            return null;
        }
        return speeches.get(index);
    }

    public void deleteSpeechByIndex(int index) {
        speeches.remove(index);
        fireTableDataChanged();
    }

    public void addSpeech(Speech s) {
        speeches.add(s);
        fireTableDataChanged();
    }

    public List<Speech> getSpeeches() {
        return speeches;
    }

}
