package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TibiaEventRestController {

       private TibiaEventService tibiaEventService;

       @Autowired
       public TibiaEventRestController(TibiaEventService tibiaEventService) {
              this.tibiaEventService = tibiaEventService;
       }


       @GetMapping("/events")
       public List<TibiaEvent> getAllEvents()
       {
              return tibiaEventService.getTibiaEventList();
       }

       @GetMapping("/event/{id}")
       public TibiaEvent getEvent(@PathVariable String id)
       {
              return tibiaEventService.getTibiaEventById(id).orElseThrow();
       }







}
