package com.example.tibiaeventbusproject.models.tibiaEventResources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class TibiaEvent {

    @Id
    private String id;

    private String nick;

    private String state;

    private String time;

    private String hashAuth;



    public TibiaEvent() {}

    public TibiaEvent(String nick, String state, String time, String hashAuth) {
        this.nick = nick;
        this.state = state;
        this.time = time;
        this.hashAuth = hashAuth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHashAuth() {
        return hashAuth;
    }

    public void setHashAuth(String hashAuth) {
        this.hashAuth = hashAuth;
    }


}
