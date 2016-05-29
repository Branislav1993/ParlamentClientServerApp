/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.party;

import java.sql.SQLException;
import java.util.List;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Party;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOGetParties extends AbstractSO {

    private List<AbstractObject> parties;

    public List<AbstractObject> getParties() {
        return parties;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        parties = DbBroker.getInstance().getAllAbstractObjects(new Party());
    }

}
