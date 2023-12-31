package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import com.example.tibiaeventbusproject.repositories.TibiaEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TibiaEventService {

    private TibiaEventRepository repository;

    @Autowired
    public TibiaEventService(TibiaEventRepository tibiaEventRepository) {
        this.repository = tibiaEventRepository;
    }



    public void getTibiaEvent(TibiaEvent event) {
        repository.insert(event);
    }


    public List<TibiaEvent> getTibiaEventList() {
        return repository.findAll();
    }

    public Optional<TibiaEvent> getTibiaEventById(String id) {
        return repository.findById(id);
    }
}
