/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations;

import rs.fon.silab.database.DbBroker;

/**
 *
 * @author Branislav Vidojevic
 */
public abstract class AbstractSO {

    public final void executeOperation() throws Exception {
        try {
            DbBroker.getInstance().connectToMySqlDatabase();
            executeSpecificOperation();
            DbBroker.getInstance().commit();
            DbBroker.getInstance().closeConnection();
        } catch (Exception e) {
            DbBroker.getInstance().rollback();
            DbBroker.getInstance().closeConnection();
        }
    }

    protected abstract void executeSpecificOperation() throws Exception;
}
