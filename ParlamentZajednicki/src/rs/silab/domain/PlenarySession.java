package rs.silab.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import rs.silab.util.Util;

public class PlenarySession extends AbstractObject {

    private Integer id;
    private String agenda;
    private String transcriptText;
    private Date date;

    public PlenarySession() {
    }

    PlenarySession(Integer id) {
        this.id = id;
    }

    public PlenarySession(Integer id, String agenda, String transcriptText, Date date) {
        this.id = id;
        this.agenda = agenda;
        this.transcriptText = transcriptText;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getTranscriptText() {
        return transcriptText;
    }

    public void setTranscriptText(String transcriptText) {
        this.transcriptText = transcriptText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PlenarySession [id=" + id + ", agenda=" + agenda + ", transcriptText=" + transcriptText + "]";
    }

    @Override
    public String getTableName() {
        return "plenarnasednica";
    }

    @Override
    public String getParameters() {
        return String.format("'%s', '%s', '%s'", agenda, Util.SDF.format(date), transcriptText);
    }

    @Override
    public String getParameterNames() {
        return "tekstdnevnogreda,datumplenarnesednice,teksttranskriptaplenarnesednice";
    }

    @Override
    public String getPrimaryKeyName() {
        return "idplenarnasednica";
    }

    @Override
    public Integer getPrimaryKeyValue() {
        return id;
    }

    @Override
    public List<AbstractObject> convertFromResultSetToList(ResultSet rs) {
        List<AbstractObject> sessions = new ArrayList<>();
        try {
            while (rs.next()) {

                Integer id = rs.getInt("idplenarnasednica");
                String agenda = rs.getString("tekstdnevnogreda");
                String transcrpit = rs.getString("teksttranskriptaplenarnesednice");
                Date date = rs.getDate("datumplenarnesednice");
                PlenarySession ps = new PlenarySession(id, agenda, transcrpit, date);
                sessions.add(ps);
            }
        } catch (SQLException ex) {
            System.out.println("Error in convertFromResultSetToList Member.class");
        }
        return sessions;
    }

    @Override
    public String getUpdateQuery() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "tekstdnevnogreda='" + agenda + "',datumplenarnesednice='" + sdf.format(date) + "',teksttranskriptaplenarnesednice='" + transcriptText + "'";
    }

    @Override
    public String getComplexPrimaryKey() {
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final PlenarySession other = (PlenarySession) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
