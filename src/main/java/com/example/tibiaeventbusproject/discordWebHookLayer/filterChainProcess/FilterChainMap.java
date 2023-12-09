package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FilterChainMap {

    //Map<String, String> map = Map.of("key1","value1", "key2", "value2");

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
        Map<String,Filtr> newInstancemap = new HashMap<>();

        newInstancemap.put("kill",()->{
            System.out.println("dodaje do bazy kill event do tibia service");
            tibiaEventService.getTibiaEvent("essa kill!");
        });

        newInstancemap.put("dead",()->{
            System.out.println("dodaje do bazy dead event do tibia service");
            tibiaEventService.getTibiaEvent("essa dead!");
        });

        newInstancemap.put("balance",()->{
            System.out.println("dodaje do bazy balance event do tibia service");
            tibiaEventService.getTibiaEvent("essa balance!");
        });

       return newInstancemap;
    }


    public static Map<String,Filtr> getMapOfChains()
    {
        return map;
    }
}
