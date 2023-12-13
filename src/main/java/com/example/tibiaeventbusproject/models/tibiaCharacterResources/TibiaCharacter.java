package com.example.tibiaeventbusproject.models.tibiaCharacterResources;

public class TibiaCharacter {

    private String email;

    //email to jako login
    //haslo
    //HashWygenerowany przy rejestracji(czyli jesli wszystko git

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
