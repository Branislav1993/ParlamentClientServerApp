/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.member;

import java.sql.SQLException;
import rs.fon.silab.database.DbBroker;
import rs.fon.silab.system_operations.AbstractSO;
import rs.silab.domain.AbstractObject;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOCreateMember extends AbstractSO {

    private AbstractObject member;
    private boolean success = false;

    public boolean isSuccess() {
        return success;
    }

    public SOCreateMember(AbstractObject member) {
        this.member = member;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        success = DbBroker.getInstance().saveAbstractObject(member);
    }

}
