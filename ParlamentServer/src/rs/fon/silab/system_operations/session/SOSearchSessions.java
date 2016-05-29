/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.session;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.PlenarySession;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOSearchSessions extends AbstractSO {

    private List<AbstractObject> sessions;
    private String searchCriteria;

    public List<AbstractObject> getSessions() {
        return sessions;
    }

    public SOSearchSessions(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        List<AbstractObject> allSessions = DbBroker.getInstance().getAllAbstractObjects(new PlenarySession());
        sessions = new LinkedList<>();

        for (AbstractObject ao : allSessions) {
            PlenarySession ps = (PlenarySession) ao;
            if (findStringMatches(ps)) {
                sessions.add(ps);
            }
        }
    }

    private boolean findStringMatches(PlenarySession ps) {
        return ps.getTranscriptText().toLowerCase().contains(searchCriteria);
    }

}
