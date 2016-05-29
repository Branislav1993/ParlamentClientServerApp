/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.member;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Member;
import rs.silab.domain.Town;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOSearchMembers extends AbstractSO {

    private List<AbstractObject> members;
    private String searchCriteria;

    public List<AbstractObject> getMembers() {
        return members;
    }

    public SOSearchMembers(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        List<AbstractObject> allMembers = DbBroker.getInstance().getAllAbstractObjects(new Member());
        System.out.println("allMembers size: " + allMembers.size());
        members = new LinkedList<>();

        for (AbstractObject ao : allMembers) {
            Member m = (Member) ao;
            if (findStringMatches(m)) {
                System.out.println("Usao u uslov");
                Town placeOfBirth = (Town) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Town(), m.getPlaceOfBirth().getId());
                Town placeOfResidence = (Town) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Town(), m.getPlaceOfResidence().getId());
                m.setPlaceOfBirth(placeOfBirth);
                m.setPlaceOfResidence(placeOfResidence);
                members.add(m);
            }
        }
    }

    private boolean findStringMatches(Member m) {
        System.out.println(m);
        String[] searchTerms = searchCriteria.split(" ");
        for (String searchTerm : searchTerms) {
            if (m.getName().toLowerCase().matches("(.*)" + searchTerm.toLowerCase() + "(.*)") || m.getLastName().toLowerCase().matches("(.*)" + searchTerm.toLowerCase() + "(.*)")) {
                return true;
            }
        }
        return false;
    }

}
