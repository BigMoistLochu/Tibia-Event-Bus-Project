package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaGuide.TibiaGuide;
import com.example.tibiaeventbusproject.services.TibiaGuideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/guides")
public class TibiaGuideRestController {


    private final TibiaGuideService tibiaGuideService;

    public TibiaGuideRestController(TibiaGuideService tibiaGuideService) {
        this.tibiaGuideService = tibiaGuideService;
    }


    //GET /api/guides: Pobieranie listy poradników.
    @GetMapping("/")
    public List<TibiaGuide> getAllGuides() {
        return tibiaGuideService.getAllTibiaGuides();
    }

    //POST /api/guides: Dodawanie nowego poradnika.
    @PostMapping("/")
    public void createTibiaGuide(@RequestBody TibiaGuide tibiaGuide) {
        tibiaGuideService.createTibiaGuide(tibiaGuide);
    }

    //PUT /api/guides/{guideId}: Aktualizacja poradnika.
    @PutMapping("/{guideId}")
    public void changeTibiaGuide(@PathVariable String guideId,@RequestBody TibiaGuide tibiaGuide) {
        tibiaGuideService.updateTibiaGuide(guideId,tibiaGuide);
    }

    //DELETE /api/guides/{guideId}: Usunięcie poradnika.
    @DeleteMapping("/{guideId}")
    public void changeTibiaGuide(@PathVariable String guideId) {
        tibiaGuideService.deleteTibiaGuide(guideId);
    }


}
