package com.example.taks.models;

public class AccountModel {
    private final String type = "a";
    private String email;
    private String password;

    public AccountModel( String email, String password) {
        this.email = email;
        this.password = password;
    }
}
