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

        newInstanceMap.put("Frag",()->{
            System.out.println("Zwracam metode z lambdy i dodaje do kolejki event");
            FilterChainQueue.getInstance().addEventToFirstQueue("Frag!");
        });

        newInstanceMap.put("Dead",()->{
            System.out.println("dodaje do bazy dead event do tibia service");
            FilterChainQueue.getInstance().addEventToFirstQueue("DEAD!");
        });

        newInstanceMap.put("Balance",()->{
            System.out.println("dodaje do bazy balance event do tibia service");
            FilterChainQueue.getInstance().addEventToFirstQueue("BALANCE!");
        });

       return newInstanceMap;
    }


    protected static Map<String, FiltrMethod> getMapOfChains()
    {
        return map;
    }
}
