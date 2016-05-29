/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.speech;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Speech;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOCreateSpeeches extends AbstractSO {

    private List<AbstractObject> speeches;
    private boolean success = false;

    public boolean isSuccess() {
        return success;
    }

    public SOCreateSpeeches(List<AbstractObject> speeches) {
        this.speeches = speeches;
    }

    @Override
    protected void executeSpecificOperation() {
        try {
            DbBroker.getInstance().saveAbstractObjects(speeches);
            success = true;
        } catch (SQLException ex) {
            success = false;
        }
    }

}
