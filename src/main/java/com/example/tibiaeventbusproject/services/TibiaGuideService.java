package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.tibiaGuide.TibiaGuide;
import com.example.tibiaeventbusproject.repositories.TibiaGuideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TibiaGuideService {

        private final TibiaGuideRepository tibiaGuideRepository;

        public TibiaGuideService(TibiaGuideRepository tibiaGuideRepository) {
            this.tibiaGuideRepository = tibiaGuideRepository;
        }


        public List<TibiaGuide> getAllTibiaGuides() {

            return tibiaGuideRepository.findAll();
        }

        public void createTibiaGuide(TibiaGuide tibiaGuide)
        {
            tibiaGuideRepository.save(tibiaGuide);
        }

    public void updateTibiaGuide(String id,TibiaGuide tibiaGuideForUptade)
    {
        TibiaGuide tibiaGuide = tibiaGuideRepository.findById(id).get();
        tibiaGuide.setDescription(tibiaGuideForUptade.getDescription());
        tibiaGuide.setName(tibiaGuideForUptade.getName());
        tibiaGuideRepository.save(tibiaGuide);
    }

    public void  deleteTibiaGuide(String id)
    {
        tibiaGuideRepository.deleteById(id);
    }




}
