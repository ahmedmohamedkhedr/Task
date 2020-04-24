package com.example.taks.models;

public class ListModel {
    private String name;
    private String email;

    public ListModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
