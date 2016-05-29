package rs.silab.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Party extends AbstractObject {

    private Integer id;
    private String name;

    public Party() {
    }

    public Party(Integer id) {
        this.id = id;
    }

    public Party(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Party [partyId=" + id + ", name=" + name + "]";
    }

    @Override
    public String getTableName() {
        return "politickaorganizacija";
    }

    @Override
    public String getParameters() {
        return String.format("'%s'", name);
    }

    @Override
    public String getPrimaryKeyName() {
        return "idpolitickaorganizacija";
    }

    @Override
    public Integer getPrimaryKeyValue() {
        return id;
    }

    @Override
    public List<AbstractObject> convertFromResultSetToList(ResultSet rs) {
        List<AbstractObject> parties = new ArrayList<>();
        try {
            while (rs.next()) {

                Integer id = rs.getInt("idpolitickaorganizacija");
                String name = rs.getString("ime");
                Party p = new Party(id, name);
                parties.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error in convertFromResultSetToList Party.class");
        }
        return parties;
    }

    @Override
    public String getUpdateQuery() {
        return "ime='" + name + "'";
    }

    @Override
    public String getParameterNames() {
        return "ime";
    }

    @Override
    public String getComplexPrimaryKey() {
        return null;
    }
}
