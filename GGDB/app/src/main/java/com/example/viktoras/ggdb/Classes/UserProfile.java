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
 */
public class UserProfile {
    private String userName;
    private String password;

    public void Logon(String userName, String password){

        String url = "ACER\\SQLEXPRESS";
        String hostIP = "192.168.1.66";
        String port = "49170";
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        System.out.println(userName+password);

        try{


            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String ConnectionString = "jdbc:sqlserver://"+hostIP + ":" + port +"\\SQLEXPRESS;databaseName=GGDB" + ";user=" + userName + ";password" + password +";" ;

            con = DriverManager.getConnection(ConnectionString);
            stat = con.createStatement();
            String queryString = "select * from sysobjects where type = u";
            rs = stat.executeQuery(queryString);
            while (rs.next()) {
                System.out.println(rs.getString(1));


            }

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
