package com.example.tibiaeventbusproject.discordWebHookLayer;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TibiaEventJsonHandlerTest {


    @Test
    void getParsedTibiaEventShouldReturnNull() {

        // 1. Przygotowanie danych testowych
        String wrongMessage = "bototc.messag({\"nick\" : \"Masszny\",\"state\" : \"Frag\",\"time\" : \"2023/12/13 05:12:45\",\"hash\" : \"81ncasdkdam\"})";
        // 2. Wywołanie metody
        TibiaEventDto event = TibiaEventJsonHandler.getParsedTibiaEvent(wrongMessage);
        //3. Sprawdzenie wyników
        assertNull(event);

    }

    @Test
    void getParsedTibiaEventShouldReturnTibiaEventDto() {

        // 1. Przygotowanie danych testowych
        String correctJson = "bototc.message({\"nick\" : \"Masszny\",\"state\" : \"Frag\",\"time\" : \"2023/12/13 05:12:45\",\"hash\" : \"81ncasdkdam\"})";
        TibiaEventDto tibiaEventDtoByContructor = new TibiaEventDto("Masszny","Frag","2023/12/13 05:12:45","81ncasdkdam");
        // 2. Wywołanie metody
        TibiaEventDto tibiaEventFromMethod = TibiaEventJsonHandler.getParsedTibiaEvent(correctJson);
        //3. Sprawdzenie wyników
        assertEquals(tibiaEventFromMethod,tibiaEventDtoByContructor);

    }
}