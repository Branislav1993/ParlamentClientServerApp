/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.silab.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import rs.silab.util.Util;

/**
 *
 * @author Branislav Vidojevic
 */
public class PartyMembership extends AbstractObject {

    private Member member;
    private Party party;
    private Date fromDate;
    private Date toDate;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public PartyMembership(Member member, Party party, Date fromDate, Date toDate) {
        this.member = member;
        this.party = party;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public PartyMembership() {
    }

    @Override
    public String toString() {
       return "PartyMembership: memberID: " + member.getId() + "partyID: " + party.getId() + "fromDate: " + fromDate + "toDate: " + toDate;
    }

    @Override
    public String getTableName() {
        return "clanpolitickeorganizacije";
    }

    @Override
    public String getParameters() {
        return String.format("'%s', '%s', '%s', '%s'", member.getId(), party.getId(), fromDate == null ? "null" : Util.SDF.format(fromDate), toDate == null ? "null" : Util.SDF.format(toDate));
    }

    @Override
    public String getParameterNames() {
        return "idposlanika,idpolitickeorganizacije,datumpristupanja,datumizlaska";
    }

    @Override
    public String getPrimaryKeyName() {
        return null;
    }

    @Override
    public Integer getPrimaryKeyValue() {
        return null;
    }

    @Override
    public List<AbstractObject> convertFromResultSetToList(ResultSet rs) {
        List<AbstractObject> partyMemberships = new ArrayList<>();
        try {
            while (rs.next()) {

                Integer memberId = rs.getInt("idposlanika");
                Integer partyId = rs.getInt("idpolitickeorganizacije");
                Date fromDate = rs.getDate("datumpristupanja");
                Date toDate = rs.getDate("datumizlaska");
                PartyMembership pm = new PartyMembership(new Member(memberId), new Party(partyId), fromDate, toDate);
                partyMemberships.add(pm);
            }
        } catch (SQLException ex) {
            System.out.println("Error in convertFromResultSetToList PartyMembership.class");
        }
        return partyMemberships;
    }

    @Override
    public String getUpdateQuery() {
        return "`idposlanika`=" + member.getId() + ",`idpolitickeorganizacije`=" + party.getId() + ",`datumpristupanja`=" + Util.SDF.format(fromDate) + ",`datumizlaska`=" + Util.SDF.format(toDate);
    }

    @Override
    public String getComplexPrimaryKey() {
        return " WHERE idposlanika=" + member.getId() + " AND idpolitickeorganizacije=" + party.getId();
    }

}
