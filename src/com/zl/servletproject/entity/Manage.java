package com.zl.servletproject.entity;

public class Manage {
    private String username;
    private  String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Manage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manage() {
    }

    @Override
    public String toString() {
        return "Manage{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
