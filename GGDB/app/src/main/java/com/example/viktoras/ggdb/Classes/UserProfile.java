package com.example.viktoras.ggdb.Classes;
import java.sql.*;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.TextView;

/**
 * Created by Viktoras on 2015-11-29.
 * AB001 - Connection stringo pakeitimai
 * AB002 - Vartotojo prisijungimo pakeitimai
 */
public class UserProfile {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private boolean loggedIn;

    public void Logon(String userName, String password){

        String url = "ACER\\SQLEXPRESS";
        String hostIP = "10.3.3.125";
        String port = "49170";
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        System.out.println(userName+password);

        try{


            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            //String ConnectionString = "jdbc:jtds:sqlserver://"+hostIP + ":" + port +"\\SQLEXPRESS;databaseName=GGDB" + ";user=" + userName + ";password" + password +";" ;
            String ConnectionString = "jdbc:jtds:sqlserver://"+hostIP + ":" + port +"/GGDB"; //>><<AB001
            con = DriverManager.getConnection(ConnectionString, "admin", "troll");
            stat = con.createStatement();
            //>>AB002
            String queryString = "select * from dbo.Users where Users.Username = '"+userName+"' and Users.Password = '"+password+"';";
            rs = stat.executeQuery(queryString);
            while(rs.next()){
                firstName = rs.getString(5);
                lastName = rs.getString(6);
                loggedIn = true;
            }
            //<<AB002
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public UserProfile(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn(){
        return loggedIn;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
