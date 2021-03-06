package com.psi_stud.arturas.ggdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Created by Arturas on 2015-12-16.
 */
public class SQLService {

    private Connection connection;
    String hostIP = "192.168.43.52";
    String port = "49170";

    public SQLService(){
        loadDriver();
        openConnection();
    }

    private void loadDriver() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("ERROR: Rules not found!");
            System.exit(1);
        }
    }

    private void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://" + hostIP + ":" + port + "/GGDB;", "admin", "troll") ;
        }
        catch (SQLException sqle) {
            System.out.println("ERROR: Can't connect to the database!");
            System.exit(1);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("ERROR: Can't close connection!");
        }
    }

    public int updateDB(String query) throws SQLException {
        Statement stmt = null;
        int count = -1;

        try {
            stmt = connection.createStatement();
            count = stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                if(stmt != null) stmt.close();
            } catch (SQLException e) {
                System.out.println("ERROR: Unexpected SQL error!");
            }
        }

        return count;
    }

    public LinkedList<LinkedList<String>> queryDB(String query) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()){
                LinkedList<String> row = new LinkedList<String>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String temp = rs.getString(i);
                    if(temp == null) temp = "";
                    row.add(temp);
                }
                result.add(row);
            }

        } catch (SQLException e) {
            System.out.println("ERROR: Couldn't execute query!");
        } finally {
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
            } catch (SQLException e) {
                System.out.println("ERROR: Unexpected SQL error!");
            }
        }

        return result;
    }
}
