package com.example.tibiaeventbusproject.models.tibiaEventResources;

public class TibiaEventMapper {

    public static TibiaEvent convertDtoToEntity(TibiaEventDto eventDto)
    {
        TibiaEvent tibiaEvent = new TibiaEvent();
        tibiaEvent.setNick(eventDto.getNick());
        tibiaEvent.setState(eventDto.getState());
        tibiaEvent.setTime(eventDto.getTime());
        tibiaEvent.setHashAuth(eventDto.getHashAuth());

        //mozna tutaj zrobic czekowanie czy wszystko jest okey,
        // lub tez wymusic zmiane np czasu i konwertowania ze stringa na DataTime...

        return tibiaEvent;
    }






}
