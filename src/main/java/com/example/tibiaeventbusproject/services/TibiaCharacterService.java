package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.tibiaCharacterResources.TibiaCharacter;
import com.example.tibiaeventbusproject.repositories.TibiaCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TibiaCharacterService {


    TibiaCharacterRepository repository;

    @Autowired
    public TibiaCharacterService(TibiaCharacterRepository repository) {
        this.repository = repository;
    }

    public List<TibiaCharacter> getAllTibiaCharacters()
    {
        return repository.findAll();
    }

    public TibiaCharacter getTibiaCharacterByHash(String email)
    {
        return repository.getTibiaCharacterByEmail(email);
    }

    public boolean ifExistTibiaCharacterByHash(String hash)
    {
        return repository.existsByHashAuth(hash);
    }

}
