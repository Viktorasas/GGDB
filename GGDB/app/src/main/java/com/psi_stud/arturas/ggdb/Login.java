package com.psi_stud.arturas.ggdb;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Arturas on 2015-12-14.
 */
public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean Init() {
        String url = "ACER\\SQLEXPRESS";
        String hostIP = "192.168.1.65";
        String port = "49170";
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String ConnectionString = "jdbc:jtds:sqlserver://" + hostIP + ":" + port + "/GGDB;user=admin;password=troll;"; //>><<AB001
            con = DriverManager.getConnection(ConnectionString, "admin", "troll");
            stat = con.createStatement();
            String queryString = "select * from dbo.Users where Users.Username = '" + username + "' and Users.Password = '" + password + "';";
            rs = stat.executeQuery(queryString);
            while (rs.next()) {
                System.out.println(rs.getString(5) + " " + rs.getString(6));
                if (username == rs.getString(2) && password == rs.getString(3))
                    result =  true;
            }
            con.close();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            result =  false;
        }
        return result;
    }
}
