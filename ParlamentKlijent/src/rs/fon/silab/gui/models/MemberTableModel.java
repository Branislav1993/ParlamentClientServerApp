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
import rs.silab.domain.Member;

/**
 *
 * @author Branislav Vidojevic
 */
public class MemberTableModel extends AbstractTableModel {

    private static final String[] COLUMNS = new String[]{"ID", "Name", "Last name", "Birth date", "email", "Birth place", "Residence place", "Gender"};
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    private List<Member> members;

    public MemberTableModel(List<Member> members) {
        if (members == null) {
            this.members = new LinkedList<>();
        } else {
            this.members = members;
        }
    }

    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member m = members.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return m.getId();
            case 1:
                return m.getName();
            case 2:
                return m.getLastName();
            case 3:
                if (m.getDateOfBirth() != null) {
                    return SDF.format(m.getDateOfBirth());
                } else {
                    return "";
                }
            case 4:
                return m.getEmail();
            case 5:
                return m.getPlaceOfBirth();
            case 6:
                return m.getPlaceOfResidence();
            case 7:
                if (m.getGender() == 0) {
                    return "Female";
                }
                return "Male";
            default:
                return "NN";
        }
    }

    public Member getMemberByIndex(int index) {
        if (index >= members.size() || index < 0) {
            return null;
        }
        return members.get(index);
    }

    public void deleteMemberByIndex(int index) {
        members.remove(index);
        fireTableDataChanged();
    }

    public List<Member> getMembers() {
        return members;
    }

}
