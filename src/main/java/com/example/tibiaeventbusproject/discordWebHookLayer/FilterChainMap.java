package com.example.tibiaeventbusproject.discordWebHookLayer;

import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class FilterChainMap {

    private final static HashMap<String,Filtr> map = new HashMap<>();
    private static TibiaEventService tibiaEventService;

    @Autowired
    public FilterChainMap(TibiaEventService tibiaEventService) {
        this.tibiaEventService = tibiaEventService;
    }

    public static HashMap<String,Filtr> getFilterChains()
    {
        map.put("kill",()->{
            tibiaEventService.getTibiaEvent("wykonuje kill dodanie Eventu do bazy danych");
        });

        map.put("dead",()->{
            tibiaEventService.getTibiaEvent("wykonuje dead dodanie Eventu do bazy danych");
        });

        return map;
    }
}
