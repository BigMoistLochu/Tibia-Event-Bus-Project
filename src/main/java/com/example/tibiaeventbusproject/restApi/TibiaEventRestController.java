package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/tibia")
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

       @PutMapping("/event/{id}")
       public void updateEvent(@PathVariable String id,@RequestBody TibiaEvent tibiaEvent)
       {
              //updateevent

       }

       @DeleteMapping("/event/{id}")
       public void deleteEvent(@PathVariable String id)
       {
              //delete event
       }








}
