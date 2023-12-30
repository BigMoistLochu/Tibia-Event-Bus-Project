package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import com.example.tibiaeventbusproject.repositories.TibiaEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TibiaEventService {

    private TibiaEventRepository tibiaEventRepository;

    @Autowired
    public TibiaEventService(TibiaEventRepository tibiaEventRepository) {
        this.tibiaEventRepository = tibiaEventRepository;
    }



    public void getTibiaEvent(TibiaEvent event)
    {
        tibiaEventRepository.insert(event);
    }


    public List<TibiaEvent> getTibiaEventList() {
        return tibiaEventRepository.findAll();
    }

    public Optional<TibiaEvent> getTibiaEventById(String id) {
        return tibiaEventRepository.findById(id);
    }
}
