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
import rs.silab.domain.Member;
import rs.silab.domain.Town;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOGetMembers extends AbstractSO {

    List<AbstractObject> members;

    public List<AbstractObject> getMembers() {
        return members;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        members = DbBroker.getInstance().getAllAbstractObjects(new Member());
        for (AbstractObject ao : members) {
            Member m = (Member) ao;
            Town placeOfBirth = (Town) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Town(), m.getPlaceOfBirth().getId());
            Town placeOfResidence = (Town) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Town(), m.getPlaceOfResidence().getId());
            m.setPlaceOfBirth(placeOfBirth);
            m.setPlaceOfResidence(placeOfResidence);
        }
    }

}
