package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaCharacterResources.TibiaCharacter;
import com.example.tibiaeventbusproject.services.TibiaCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tibia")
public class TibiaCharacterRestController {

    //9	POST /api/tibia/characters: Dodanie nowej postaci.	0,4	1,00%
    //10	GET /api/tibia/characters: Pobieranie listy postaci użytkownika.	0,8	2,00%
    //11	PUT /api/tibia/characters/{characterId}: Aktualizacja profilu postaci.	0,4	1,00%
    //12	DELETE /api/tibia/characters/{characterId}: Usunięcie postaci z konta użytkownika.	0,8	2,00%

    private TibiaCharacterService tibiaCharacterService;

    @Autowired
    public TibiaCharacterRestController(TibiaCharacterService tibiaCharacterService) {
        this.tibiaCharacterService = tibiaCharacterService;
    }

    @GetMapping("/characters")
    public List<TibiaCharacter> getAllCharacters()
    {
        return tibiaCharacterService.getAllTibiaCharacters();
    }
}
