package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.tibiaCharacterResources.TibiaCharacter;
import com.example.tibiaeventbusproject.repositories.TibiaCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TibiaCharacterService {


    TibiaCharacterRepository repository;

    @Autowired
    public TibiaCharacterService(TibiaCharacterRepository repository) {
        this.repository = repository;
    }

    public List<TibiaCharacter> getAllTibiaCharacters() {
        return repository.findAll();
    }

    public void addTibiaCharacter(TibiaCharacter character) {
        repository.insert(character);
    }

    public void deleteTibiaCharacter(String id) {
        TibiaCharacter tibiaCharacter = repository.findById(id).get();
        repository.delete(tibiaCharacter);
    }

    public void updateTibiaCharacter(String id,String password) {
        TibiaCharacter tibiaCharacter = repository.findById(id).get();
        tibiaCharacter.setPassword(password);
        repository.save(tibiaCharacter);
    }

    public TibiaCharacter getTibiaCharacterByHash(String email) {
        return repository.getTibiaCharacterByEmail(email);
    }

    public boolean ifExistTibiaCharacterByHash(String hash) {
        return repository.existsByHashAuth(hash);
    }

}
