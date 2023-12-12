package com.example.tibiaeventbusproject.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TibiaEvent {

    @JsonProperty("nick")
    private String nick;

    @JsonProperty("state")
    private String state;

    @JsonProperty("time")
    private String time;

    @JsonProperty("hash")
    private String hashAuth;

    public TibiaEvent(){}


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    @Override
    public String toString() {
        return "TibiaEvent{" +
                "nick='" + nick + '\'' +
                ", state='" + state + '\'' +
                ", time='" + time + '\'' +
                ", hashAuth='" + hashAuth + '\'' +
                '}';
    }
}
