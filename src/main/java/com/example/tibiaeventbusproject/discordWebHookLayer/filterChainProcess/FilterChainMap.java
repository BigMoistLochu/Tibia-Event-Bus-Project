package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FilterChainMap {


    private static TibiaEventService tibiaEventService;

    private final static Map<String, Filtr> map = createMap();


    @Autowired
    public FilterChainMap(TibiaEventService tibiaEventService) {
        this.tibiaEventService = tibiaEventService;
    }


    /**
     * This method create one instance of Map with all chains
     * @return
     */
    private static Map<String,Filtr> createMap(){
        Map<String,Filtr> newInstanceMap = new HashMap<>();

        newInstanceMap.put("kill",()->{
            System.out.println("Zwracam metode z lambdy i dodaje do kolejki event");
            FilterChainQueue.getInstance().addEventToQueue("KILL!");
        });

        newInstanceMap.put("dead",()->{
            System.out.println("dodaje do bazy dead event do tibia service");
            tibiaEventService.getTibiaEvent("essa dead!");
        });

        newInstanceMap.put("balance",()->{
            System.out.println("dodaje do bazy balance event do tibia service");
            tibiaEventService.getTibiaEvent("essa balance!");
        });

       return newInstanceMap;
    }


    protected static Map<String,Filtr> getMapOfChains()
    {
        return map;
    }
}
