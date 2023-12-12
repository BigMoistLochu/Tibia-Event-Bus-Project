package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import java.util.HashMap;
import java.util.Map;


public class FilterChainMap {



    private final static Map<String, FiltrMethod> map = createMap();


    /**
     * This method create one instance of Map with all chains
     * @return
     */
    private static Map<String, FiltrMethod> createMap(){
        Map<String, FiltrMethod> newInstanceMap = new HashMap<>();

        newInstanceMap.put("Frag",(tibiaEvent)->{
            System.out.println("Zwracam metode z lambdy i dodaje do kolejki event");
            FilterChainQueue.getInstance().addEventToFirstQueue(tibiaEvent);
        });

        newInstanceMap.put("Dead",(tibiaEvent)->{
            System.out.println("dodaje do bazy dead event do tibia service");
            FilterChainQueue.getInstance().addEventToFirstQueue(tibiaEvent);
        });

        newInstanceMap.put("Balance",(tibiaEvent)->{
            System.out.println("dodaje do bazy balance event do tibia service");
            FilterChainQueue.getInstance().addEventToFirstQueue(tibiaEvent);
        });

       return newInstanceMap;
    }


    protected static Map<String, FiltrMethod> getMapOfChains()
    {
        return map;
    }
}
