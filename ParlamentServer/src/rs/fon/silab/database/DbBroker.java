/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import rs.fon.silab.config.Config;
import rs.silab.domain.AbstractObject;

/**
 *
 * @author Branislav Vidojevic
 */
public class DbBroker {

    private Connection connection;
    private static DbBroker instance;

    public DbBroker() {
    }

    public static DbBroker getInstance() {
        if (instance == null) {
            instance = new DbBroker();
        }
        return instance;
    }

    public boolean connectToMySqlDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver has been loaded");
            String url = Config.getInstance().getDbUrl();
            String user = Config.getInstance().getUsername();
            String pass = Config.getInstance().getPassword();
            connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);
            System.out.println("Connection to database was successfull.");
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver has not been found!");
            return false;
        } catch (SQLException ex) {
            System.out.println("Database connection was not successfull!");
            return false;
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Connection can't be closed!");
        }
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("Commit can't be done!");
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.out.println("Rollback can't be done!");
        }
    }

    public synchronized List<AbstractObject> getAllAbstractObjects(AbstractObject o) throws SQLException {
        try {
            String query = "SELECT * FROM " + o.getTableName();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            List<AbstractObject> list = o.convertFromResultSetToList(rs);
            s.close();
            System.out.println("Result set has been converted!");
            return list;
        } catch (SQLException ex) {
            System.out.println("Error in converting result set into class " + o.getTableName());
            ex.printStackTrace();
            throw ex;
        }
    }

    public synchronized AbstractObject getAbstractObjectByPrimaryKey(AbstractObject o, int id) throws SQLException {
        String query;

        if (o.getComplexPrimaryKey() == null) {
            query = "SELECT * FROM " + o.getTableName() + " WHERE " + o.getPrimaryKeyName() + "=" + id;
        } else {
            query = "SELECT * FROM " + o.getTableName() + " WHERE " + o.getComplexPrimaryKey();
        }
        Statement s = (Statement) connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        List<AbstractObject> list = o.convertFromResultSetToList(rs);
        s.close();
        return list.get(0);
    }

    public synchronized boolean deleteAbstractObject(AbstractObject o) throws SQLException {
        try {
            String query;

            if (o.getComplexPrimaryKey() == null) {
                query = "DELETE FROM " + o.getTableName() + " WHERE " + o.getPrimaryKeyName() + "=" + o.getPrimaryKeyValue();
            } else {
                query = "DELETE FROM " + o.getTableName() + " WHERE " + o.getComplexPrimaryKey();
            }

            Statement s = (Statement) connection.createStatement();
            s.executeUpdate(query);
            commit();
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Couldn't delete abstract object: " + o.getTableName());
            throw ex;
        }
    }

    public synchronized void deleteAbstractObjects(List<AbstractObject> list) throws SQLException {
        for (AbstractObject o : list) {
            deleteAbstractObject(o);
        }
    }

    public synchronized boolean saveAbstractObject(AbstractObject o) throws SQLException {
        try {
            String query = "";
            query = "INSERT INTO " + o.getTableName() + "(" + o.getParameterNames() + ")" + " VALUES (" + o.getParameters() + ")";
            Statement s = (Statement) connection.createStatement();
            int i = s.executeUpdate(query);
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Couldn't save abstract object: " + o.getTableName());
            throw ex;
        }
    }

    public synchronized void saveAbstractObjects(List<AbstractObject> list) throws SQLException {
        for (AbstractObject o : list) {
            saveAbstractObject(o);
        }
    }

    public synchronized boolean updateAbstractObject(AbstractObject o) throws SQLException {
        try {
            String query = "";
            if (o.getComplexPrimaryKey() == null) {
                query = "UPDATE " + o.getTableName() + " SET " + o.getUpdateQuery() + " WHERE " + o.getPrimaryKeyName() + "=" + o.getPrimaryKeyValue();
            } else {
                query = "UPDATE " + o.getTableName() + " SET " + o.getUpdateQuery() + " WHERE " + o.getComplexPrimaryKey();
            }
            Statement s = (Statement) connection.createStatement();
            int i = s.executeUpdate(query);
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Couldn't update abstract object: " + o.getTableName());
            throw ex;
        }
    }

//    public synchronized boolean saveOrUpdateAbstractObject(AbstractObject o) {
//        try {
//            List<AbstractObject> list = getAllAbstractObjects(o);
//
//            String query = "";
//            if (!list.contains(o)) {
//                query = "INSERT INTO " + o.getTableName() + "(" + o.getParameterNames() + ")" + " VALUES (" + o.getParameters() + ")";
//            } else if (o.getPrimaryKeyName() != null) {
//                query = "UPDATE " + o.getTableName() + " SET " + o.getUpdateQuery() + " WHERE " + o.getPrimaryKeyName() + "=" + o.getPrimaryKeyValue();
//            }
//            Statement s = (Statement) connection.createStatement();
//            int i = s.executeUpdate(query);
//            s.close();
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
//    }
}
