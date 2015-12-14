package com.psi_stud.arturas.ggdb;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Arturas on 2015-12-14.
 */
public class Login {
    private String username;
    private String password;
    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void Init(){
        String url = "ACER\\SQLEXPRESS";
        String hostIP = "10.3.3.125";
        String port = "49170";
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;

        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        }
        catch (Exception e){

        }

    }
}
