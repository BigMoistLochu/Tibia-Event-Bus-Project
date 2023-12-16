package com.example.tibiaeventbusproject;

import com.example.tibiaeventbusproject.discordWebHookLayer.WebHookThread;
import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.FilterChainQueueEater;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


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
        FilterChainQueueEater filterChainQueueEater = new FilterChainQueueEater(tibiaEventService);
        filterChainQueueEater.run();

//        System.out.println(tibiaEventService.getTibiaEventList());
        //dalej sie nic nie uruchomi bo ten watek ciagle sie wykonuje...
        //admin
        //pass
        //{
        //  "_id": ObjectId("eventId1"),
        //  "eventName": "Spotkanie",
        //  "date": "2023-12-31"
        //}

        //{
        //  "_id": ObjectId("userId123"),
        //  "username": "jan_kowalski",
        //  "events": [
        //    ObjectId("eventId1")
        //  ]
        //}

        //Czyli to bedzie tak ze bedzie sie tworzyl nowy event jako id,state,date

    }
}
