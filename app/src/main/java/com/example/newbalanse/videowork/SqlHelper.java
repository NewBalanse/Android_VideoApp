package com.example.newbalanse.videowork;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

/**
 * Created by NewBalanse on 29.03.2018.
 */

public class SqlHelper implements Serializable {

    private String RoleUser;
    private String Login;
    private String Mail;
    private String Name;
    private String LastName;

    public SqlHelper(String roleUser, String login, String mail, String name, String lastName) {
        RoleUser = roleUser;
        Login = login;
        Mail = mail;
        Name = name;
        LastName = lastName;
    }

    public SqlHelper() {
        RoleUser = "";
        Login = "";
        Mail = "";
        Name = "";
        LastName = "";
    }

    public String getRoleUser() {
        return RoleUser;
    }

    public void setRoleUser(String roleUser) {
        RoleUser = roleUser;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
