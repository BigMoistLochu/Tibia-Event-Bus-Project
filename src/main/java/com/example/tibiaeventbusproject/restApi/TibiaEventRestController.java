package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.FilterChainQueue;
import com.example.tibiaeventbusproject.models.TibiaEvent;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TibiaEventRestController {

       private TibiaEventService tibiaEventService;

       @Autowired
       public TibiaEventRestController(TibiaEventService tibiaEventService) {
              this.tibiaEventService = tibiaEventService;
       }


       @GetMapping("/events")
       public List<TibiaEvent> getAllEvets()
       {
              return tibiaEventService.getTibiaEventList();
       }

}
