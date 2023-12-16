package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TibiaEventRestController {

       private TibiaEventService tibiaEventService;

       @Autowired
       public TibiaEventRestController(TibiaEventService tibiaEventService) {
              this.tibiaEventService = tibiaEventService;
       }


       @GetMapping("/events")
       public List<TibiaEvent> getAllEvets(HttpServletResponse response)
       {
              Cookie cookie = new Cookie("Ciacho1","ka83d");
              response.addCookie(cookie);
              return tibiaEventService.getTibiaEventList();
       }


       //1.TibiaEvent miedzy chatem a baza danych powinien byc Dto bo nie chcemy pracowac
       //ciagle na entity a uzywac mappera ktory bedzie zamienial dto na entity
       //2.Register/Login Layer, generowanie hashu->Weryfikacja go





}
