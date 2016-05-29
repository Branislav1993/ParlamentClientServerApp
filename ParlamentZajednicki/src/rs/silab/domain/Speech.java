package rs.silab.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import rs.silab.util.Util;

public class Speech extends AbstractObject {

    private Integer id;
    private String text;
    private Member member;
    private Date sessionDate;
    private PlenarySession session;

    public Speech(Integer id, String text, Member member, Date sessionDate, PlenarySession session) {
        this.id = id;
        this.text = text;
        this.member = member;
        this.sessionDate = sessionDate;
        this.session = session;
    }

    public Speech() {
    }

    public PlenarySession getSession() {
        return session;
    }

    public void setSession(PlenarySession session) {
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    @Override
    public String toString() {
        return "Speech [id=" + id + ", text=" + text + ", sessionDate="
                + sessionDate + "]";
    }

    @Override
    public String getTableName() {
        return "obracanje";
    }

    @Override
    public String getParameters() {
        return String.format("'%s', '%s', '%s', '%s'", member.getId(), session.getId(), text, Util.SDF.format(sessionDate));
    }

    @Override
    public String getParameterNames() {
        return "idposlanika,idplenarnesednice,tekst,datumsednice";
    }

    @Override
    public String getPrimaryKeyName() {
        return "idobracanje";
    }

    @Override
    public Integer getPrimaryKeyValue() {
        return id;
    }

    @Override
    public List<AbstractObject> convertFromResultSetToList(ResultSet rs) {
        List<AbstractObject> speeches = new ArrayList<>();
        try {
            while (rs.next()) {

                Integer id = rs.getInt("idobracanje");
                Integer idPoslanik = rs.getInt("idposlanika");
                Integer idSednica = rs.getInt("idplenarnesednice");
                String text = rs.getString("tekst");
                Date sessionDate = rs.getDate("datumsednice");
                Speech s = new Speech(id, text, new Member(idPoslanik), sessionDate, new PlenarySession(idSednica));
                speeches.add(s);
            }
        } catch (SQLException ex) {
            System.out.println("Error in convertFromResultSetToList Member.class");
        }
        return speeches;
    }

    @Override
    public String getUpdateQuery() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "idposlanika=" + member.getId() + ",idplenarnesednice=" + session.getId() + ",tekst='" + text + "',datumsednice='" + sdf.format(sessionDate) + "'";
    }

    @Override
    public String getComplexPrimaryKey() {
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Speech other = (Speech) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
