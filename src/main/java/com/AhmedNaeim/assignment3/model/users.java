package com.AhmedNaeim.assignment3.model;

public class users {

    private String password;
    private long id;
    private String name;
    private String role;

    public users() {
    }

    public users(long id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return this.id;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setRole(String role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
