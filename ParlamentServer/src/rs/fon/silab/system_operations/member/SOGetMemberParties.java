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
import rs.silab.domain.Party;
import rs.silab.domain.PartyMembership;

/**
 *
 * @author Branislav Vidojevic
 */
public class SOGetMemberParties extends AbstractSO {

    private List<AbstractObject> parties;
    private Member member;

    public SOGetMemberParties(Member member) {
        this.member = member;
        parties = new LinkedList<>();
    }

    public List<AbstractObject> getParties() {
        return parties;
    }

    @Override
    protected void executeSpecificOperation() throws SQLException {
        List<AbstractObject> pms = DbBroker.getInstance().getAllAbstractObjects(new PartyMembership());
        for (AbstractObject ao : pms) {
            PartyMembership pm = (PartyMembership) ao;
            if (Objects.equals(this.member.getId(), pm.getMember().getId())) {
                AbstractObject validParty = DbBroker.getInstance().getAbstractObjectByPrimaryKey(new Party(), pm.getParty().getId());
                parties.add(validParty);
            }
        }
    }

}
