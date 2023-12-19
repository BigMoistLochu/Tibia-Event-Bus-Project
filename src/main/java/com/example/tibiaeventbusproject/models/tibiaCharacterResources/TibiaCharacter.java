package com.example.tibiaeventbusproject.models.tibiaCharacterResources;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class TibiaCharacter {

    @Id
    private String id;
    private String email;

    private String password;

    private String hashAuth;

    public TibiaCharacter() {}

    public TibiaCharacter(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashAuth() {
        return hashAuth;
    }

    public void setHashAuth(String hashAuth) {
        this.hashAuth = hashAuth;
    }
}
