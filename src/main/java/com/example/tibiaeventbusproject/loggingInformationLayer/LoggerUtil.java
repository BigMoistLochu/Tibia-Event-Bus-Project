package com.example.tibiaeventbusproject.loggingInformationLayer;

import com.example.tibiaeventbusproject.TibiaEventBusProjectApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

    private static Logger logger = Logger.getLogger(TibiaEventBusProjectApplication.class.getName());
    private static LoggerHandler handler;

    static {
        handler = new LoggerHandler();
        logger.addHandler(handler);
    }

    public static void logError(String msg)
    {
        logger.log(Level.SEVERE,msg);
        //wywoluje ta metode przez co handler przechwytuje to
    }

}
