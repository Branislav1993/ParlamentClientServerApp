/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.speech;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Member;
import rs.silab.domain.PlenarySession;
import rs.silab.domain.Speech;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOSearchSpeeches extends AbstractSO {

    private List<AbstractObject> speeches;
    private String searchCriteria;

    public List<AbstractObject> getSpeeches() {
        return speeches;
    }

    public SOSearchSpeeches(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        List<AbstractObject> allParties = DbBroker.getInstance().getAllAbstractObjects(new Speech());
        speeches = new LinkedList<>();

        for (AbstractObject ao : allParties) {
            Speech s = (Speech) ao;
            if (findStringMatches(s)) {
                Member m = (Member) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Member(), s.getMember().getId());
                PlenarySession ps = (PlenarySession) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new PlenarySession(), s.getSession().getId());
                s.setMember(m);
                s.setSession(ps);
                speeches.add(s);
            }
        }
    }

    private boolean findStringMatches(Speech s) {
        if (s.getText().toLowerCase().contains(searchCriteria)) {
            return true;
        }
        return false;
    }

}
