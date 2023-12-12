package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.TibiaEvent;
import com.example.tibiaeventbusproject.repositories.TibiaEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TibiaEventService {

//    private TibiaEventRepository tibiaEventRepository;
//
//    @Autowired
//    public TibiaEventService(TibiaEventRepository tibiaEventRepository) {
//        this.tibiaEventRepository = tibiaEventRepository;
//    }

    private final List<TibiaEvent> tibiaEventList = new ArrayList<>();

    public void getTibiaEvent(TibiaEvent event)
    {
        System.out.println(event.toString());
        tibiaEventList.add(event);
    }

    public List<TibiaEvent> getTibiaEventList() {
        return tibiaEventList;
    }
}
