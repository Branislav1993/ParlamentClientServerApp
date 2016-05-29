/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.party;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Party;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOSearchParties extends AbstractSO {

    private List<AbstractObject> parties;
    private String searchCriteria;

    public List<AbstractObject> getParties() {
        return parties;
    }

    public SOSearchParties(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        List<AbstractObject> allParties = DbBroker.getInstance().getAllAbstractObjects(new Party());
        parties = new LinkedList<>();

        for (AbstractObject ao : allParties) {
            Party p = (Party) ao;
            if (findStringMatches(p)) {
                parties.add(p);
            }
        }
    }

    private boolean findStringMatches(Party p) {
        String[] searchTerms = searchCriteria.split(" ");
        for (String searchTerm : searchTerms) {
            if (p.getName().toLowerCase().matches("(.*)" + searchTerm.toLowerCase() + "(.*)")) {
                return true;
            }
        }
        return false;
    }

}
