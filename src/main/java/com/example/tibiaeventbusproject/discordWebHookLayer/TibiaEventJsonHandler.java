package com.example.tibiaeventbusproject.discordWebHookLayer;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TibiaEventJsonHandler {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String regex = "bototc\\.message\\(([^)]+)\\)"; //sprawdza czy wiadomosc ma forme bototc.message()

    /**
     * Filtr Received Message and parse json From Discord to TibiaEvent.class
     * @param message
     * @return
     */

    protected static TibiaEventDto getParsedTibiaEvent(String message)
    {
        if(doesMessageContainBotOTCMessage(message))
        {
            String json = extractJsonFromMessage(message);
            if(json!=null)
            {
                TibiaEventDto tibiaEventDto = getEventFromJson(json);
                if(tibiaEventDto !=null)
                {
                    return tibiaEventDto;
                }
            }
        }
        return null;
    }


    /**
     * Wszystko ponizej to sprawdzajace i parsujace funkcje
     * -------------------------------------------------------------------
     */

    private static boolean doesMessageContainBotOTCMessage(String message)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        return matcher.find();
    }

    private static String extractJsonFromMessage(String message)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if(matcher.find())
        {
            return matcher.group(1);
        }
        return null;
    }

    private static TibiaEventDto getEventFromJson(String json) {
        try {
            return mapper.readValue(json, TibiaEventDto.class);
        } catch (JsonProcessingException e) {
            System.out.println("Bledny String przy deserializacji jsona na obiekt w klasie MessageReceivedFilter");
        }
        return null;
    }












}
