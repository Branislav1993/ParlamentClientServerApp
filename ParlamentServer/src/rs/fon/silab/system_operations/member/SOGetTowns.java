/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.member;

import java.sql.SQLException;
import java.util.List;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Town;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOGetTowns extends AbstractSO {

    private List<AbstractObject> towns;

    public List<AbstractObject> getTowns() {
        return towns;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        towns = DbBroker.getInstance().getAllAbstractObjects(new Town());
    }

}
