package rs.silab.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Town extends AbstractObject {

    private Integer id;
    private String name;

    public Town() {
    }

    public Town(Integer id, String name) {
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
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Town other = (Town) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "mesto";
    }

    @Override
    public String getParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKeyName() {
        return "idmesto";
    }

    @Override
    public Integer getPrimaryKeyValue() {
        return id;
    }

    @Override
    public List<AbstractObject> convertFromResultSetToList(ResultSet rs) {
        List<AbstractObject> towns = new ArrayList<>();
        try {
            while (rs.next()) {
                Integer id = rs.getInt("idmesto");
                String name = rs.getString("ime");
                Town t = new Town(id, name);
                towns.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error in convertFromResultSetToList Town.class");
        }
        return towns;
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getParameterNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getComplexPrimaryKey() {
        return null;
    }

}
