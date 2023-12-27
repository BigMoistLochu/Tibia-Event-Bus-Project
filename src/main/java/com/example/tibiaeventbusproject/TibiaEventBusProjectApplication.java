package com.example.tibiaeventbusproject;

import com.example.tibiaeventbusproject.discordWebHookLayer.TibiaEventJsonHandler;
import com.example.tibiaeventbusproject.discordWebHookLayer.WebHookThread;
import com.example.tibiaeventbusproject.loggingInformationLayer.LoggerHandler;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.*;



@SpringBootApplication
public class TibiaEventBusProjectApplication implements CommandLineRunner {

    private TibiaEventService tibiaEventService;

    @Autowired
    public TibiaEventBusProjectApplication(TibiaEventService tibiaEventService) {
        this.tibiaEventService = tibiaEventService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TibiaEventBusProjectApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        //Thread responsible for listening to discord, It is not in the project because it contains a token
        WebHookThread webHookThread = new WebHookThread();
        webHookThread.run();
        //Thread responsible for processing messages and uploading them to the database
//        FilterChainQueueEater filterChainQueueEater = new FilterChainQueueEater(tibiaEventService);
//        filterChainQueueEater.run();

        //admin pass




        //Logger logger = LoggerFactory.getLogger(TibiaEventJsonHandler.class);
//        Logger logger = Logger.getLogger(TibiaEventBusProjectApplication.class.getName());
//
//        LoggerHandler loggerHandler = new LoggerHandler();
//        logger.addHandler(loggerHandler);
//
//        //klasa ktora lapie jest oddziena do przetwarzania
//        //potrzebujemy klasy ktora przetrzyma:
//
//
//        logger.log(Level.SEVERE,"wowoluje z poziomu tej klasy ");




    }
}
