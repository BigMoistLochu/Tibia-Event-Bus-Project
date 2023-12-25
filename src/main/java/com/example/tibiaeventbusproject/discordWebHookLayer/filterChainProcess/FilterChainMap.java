package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.loginAndRegisterLayer.HashGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class FilterChainMap {



    private final static Map<String, FiltrMethod> map = createMap();
    private static Logger logger = LoggerFactory.getLogger(FilterChainMap.class);


    /**
     * This method create one instance of Map with all chains
     * @return
     */
    private static Map<String, FiltrMethod> createMap(){
        Map<String, FiltrMethod> newInstanceMap = new HashMap<>();

        newInstanceMap.put("Frag",(tibiaEvent)->{
            logger.info("Dodaje event: "+tibiaEvent.getState());
            FilterChainQueue.getInstance().addEventToFirstQueue(tibiaEvent);
        });

        newInstanceMap.put("Dead",(tibiaEvent)->{
            logger.info("Dodaje event: "+tibiaEvent.getState());
            FilterChainQueue.getInstance().addEventToFirstQueue(tibiaEvent);
        });

        newInstanceMap.put("Balance",(tibiaEvent)->{
            logger.info("Dodaje event: "+tibiaEvent.getState());
            FilterChainQueue.getInstance().addEventToFirstQueue(tibiaEvent);
        });

       return newInstanceMap;
    }


    protected static Map<String, FiltrMethod> getMapOfChains()
    {
        return map;
    }
}
