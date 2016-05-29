/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.speech;

import java.sql.SQLException;
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
public class SOGetSpeeches extends AbstractSO {

    List<AbstractObject> speeches;

    public List<AbstractObject> getSpeeches() {
        return speeches;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        speeches = DbBroker.getInstance().getAllAbstractObjects(new Speech());
        for (AbstractObject ao : speeches) {
            Speech s = (Speech) ao;
            Member m = (Member) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Member(), s.getMember().getId());
            PlenarySession ps = (PlenarySession) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new PlenarySession(), s.getSession().getId());
            s.setMember(m);
            s.setSession(ps);
        }
    }

}
