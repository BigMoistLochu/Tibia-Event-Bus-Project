package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;


import com.example.tibiaeventbusproject.loggingInformationLayer.LoggerUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilterChainMap {



    private final static Map<String, FiltrMethod> map = createMap();
    private static Logger logger = LoggerUtil.getLogger(FilterChainMap.class);


    /**
     * This method create one instance of Map with all chains
     * @return
     */
    private static Map<String, FiltrMethod> createMap(){
        Map<String, FiltrMethod> newInstanceMap = new HashMap<>();

        newInstanceMap.put("Frag",(tibiaEvent)->{
            logger.log(Level.SEVERE,"jestem z klasy ChainMap");
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
