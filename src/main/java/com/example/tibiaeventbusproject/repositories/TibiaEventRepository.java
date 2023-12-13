package com.example.tibiaeventbusproject.repositories;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TibiaEventRepository extends MongoRepository<TibiaEvent,String> {

}
