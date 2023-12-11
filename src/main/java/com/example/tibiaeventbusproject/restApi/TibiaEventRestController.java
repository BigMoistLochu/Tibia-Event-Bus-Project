package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.FilterChainQueue;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TibiaEventRestController {

       private TibiaEventService tibiaEventService;

       @Autowired
       public TibiaEventRestController(TibiaEventService tibiaEventService) {
              this.tibiaEventService = tibiaEventService;
       }


       //ponizej wyswietlanie elementow dotyczacych Tibia event

}
