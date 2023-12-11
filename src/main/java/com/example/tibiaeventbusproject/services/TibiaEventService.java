package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.repositories.TibiaEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TibiaEventService {

    private TibiaEventRepository tibiaEventRepository;

    @Autowired
    public TibiaEventService(TibiaEventRepository tibiaEventRepository) {
        this.tibiaEventRepository = tibiaEventRepository;
    }

    public void getTibiaEvent(String s)
    {
        System.out.println("Dopiero teraz obsluzylem element: "+s);
    }

}
