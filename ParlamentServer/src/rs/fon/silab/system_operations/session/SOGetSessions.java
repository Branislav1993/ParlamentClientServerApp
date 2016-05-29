/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.session;

import java.sql.SQLException;
import java.util.List;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.PlenarySession;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOGetSessions extends AbstractSO {

    List<AbstractObject> sessions;

    public List<AbstractObject> getSessions() {
        return sessions;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        sessions = DbBroker.getInstance().getAllAbstractObjects(new PlenarySession());
    }

}
