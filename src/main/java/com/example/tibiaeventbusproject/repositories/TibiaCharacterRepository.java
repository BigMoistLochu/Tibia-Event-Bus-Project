package com.example.tibiaeventbusproject.repositories;

import com.example.tibiaeventbusproject.models.tibiaCharacterResources.TibiaCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TibiaCharacterRepository extends MongoRepository<TibiaCharacter,String> {

    TibiaCharacter getTibiaCharacterByEmail(String email);
}
