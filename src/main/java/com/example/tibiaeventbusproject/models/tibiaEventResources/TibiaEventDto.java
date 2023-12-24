package com.example.tibiaeventbusproject.models.tibiaEventResources;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TibiaEventDto {

    @JsonProperty("nick")
    private String nick;

    @JsonProperty("state")
    private String state;

    @JsonProperty("time")
    private String time;

    @JsonProperty("hash")
    private String hashAuth;

    public TibiaEventDto(){}

    public TibiaEventDto(String nick, String state, String time, String hashAuth) {
        this.nick = nick;
        this.state = state;
        this.time = time;
        this.hashAuth = hashAuth;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TibiaEventDto that)) return false;
        return Objects.equals(getNick(), that.getNick()) && Objects.equals(getState(), that.getState()) && Objects.equals(getTime(), that.getTime()) && Objects.equals(getHashAuth(), that.getHashAuth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNick(), getState(), getTime(), getHashAuth());
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
