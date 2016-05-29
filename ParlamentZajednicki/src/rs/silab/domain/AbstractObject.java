/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.silab.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractObject implements Serializable {

    public abstract String getTableName();

    public abstract String getParameters();
    
     public abstract String getParameterNames();

    public abstract String getPrimaryKeyName();

    public abstract Integer getPrimaryKeyValue();

    public abstract List<AbstractObject> convertFromResultSetToList(ResultSet rs);

    public abstract String getUpdateQuery();
    
    public abstract String getComplexPrimaryKey();

}
