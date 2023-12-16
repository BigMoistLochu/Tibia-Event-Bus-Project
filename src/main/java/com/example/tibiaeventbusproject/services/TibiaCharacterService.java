package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.repositories.TibiaCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TibiaCharacterService {


    TibiaCharacterRepository repository;

    @Autowired
    public TibiaCharacterService(TibiaCharacterRepository repository) {
        this.repository = repository;
    }
}
