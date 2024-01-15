package com.example.tibiaeventbusproject.repositories;

import com.example.tibiaeventbusproject.models.tibiaGuide.TibiaGuide;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TibiaGuideRepository extends MongoRepository<TibiaGuide,Long> {
}
