/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.system_operations.member;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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
public class SOGetMemberSpeeches extends AbstractSO {

    private List<AbstractObject> speeches;
    private Member member;

    public SOGetMemberSpeeches(Member member) {
        this.member = member;
        speeches = new LinkedList<>();
    }

    public List<AbstractObject> getSpeeches() {
        return speeches;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        List<AbstractObject> pms = DbBroker.getInstance().getAllAbstractObjects(new Speech());
        for (AbstractObject ao : pms) {
            Speech s = (Speech) ao;
            if (Objects.equals(this.member.getId(), s.getMember().getId())) {
                Member m = (Member) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Member(), s.getMember().getId());
                PlenarySession ps = (PlenarySession) DbBroker.getInstance().getAbstractObjectByPrimaryKey(new PlenarySession(), s.getSession().getId());
                s.setMember(m);
                s.setSession(ps);
                speeches.add(s);
            }
        }
    }

}
