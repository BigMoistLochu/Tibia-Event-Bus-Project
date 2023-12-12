package com.example.tibiaeventbusproject.models;

public class TibiaCharacter {

    private String email;

    public TibiaCharacter(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TibiaCharacter{" +
                "email='" + email + '\'' +
                '}';
    }
}
