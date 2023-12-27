package com.example.tibiaeventbusproject.loggingInformationLayer;

import com.example.tibiaeventbusproject.TibiaEventBusProjectApplication;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

    private final static LoggerHandler handler = new LoggerHandler();

    private static final HashMap<String,Logger> mapLoggers = new HashMap<>();


    public static Logger getLogger(Class<?> clazz)
    {
        if (clazz != null) {
            return getLoggerFromLoggerUtil(clazz.getName());
        } else {
            throw new IllegalArgumentException("Klasa loggera nie może być nullem");
        }
    }

    private static Logger getLoggerFromLoggerUtil(String nameClazz)
    {
        if (!mapLoggers.containsKey(nameClazz)) {
            Logger logger = Logger.getLogger(nameClazz);
            logger.addHandler(handler);
            mapLoggers.put(nameClazz, logger);
        }

        return mapLoggers.get(nameClazz);
    }



}
