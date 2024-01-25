package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaCharacterResources.TibiaCharacter;
import com.example.tibiaeventbusproject.services.TibiaCharacterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/tibia")
public class TibiaCharacterRestController {


    private TibiaCharacterService tibiaCharacterService;

    @Autowired
    public TibiaCharacterRestController(TibiaCharacterService tibiaCharacterService) {
        this.tibiaCharacterService = tibiaCharacterService;
    }

    //GET /api/tibia/characters: Pobieranie listy postaci użytkownika.
    @GetMapping("/characters")
    public List<TibiaCharacter> getCharacters()
    {
        return tibiaCharacterService.getAllTibiaCharacters();
    }

    //POST /api/tibia/characters: Dodanie nowej postaci.
    @PostMapping("/characters")
    public void addCharacter(@RequestBody TibiaCharacter tibiaCharacter)
    {
        tibiaCharacterService.addTibiaCharacter(tibiaCharacter);
    }

    //PUT /api/tibia/characters/{characterId}: Aktualizacja profilu postaci.
    @PutMapping("/characters/{characterId}")
    public void updateCharacter(@PathVariable String characterId,@RequestBody TibiaCharacter tibiaCharacter) throws JsonProcessingException {
        String passwordFromObject = tibiaCharacter.getPassword();
        //dostajesz obiekt, wyciagasz obiekt z bazy poprzedni, nadpisujesz elementy i wysylasz
        tibiaCharacterService.updateTibiaCharacter(characterId,passwordFromObject);
    }
    //DELETE /api/tibia/characters/{characterId}: Usunięcie postaci z konta użytkownika.
    @DeleteMapping("/characters/{characterId}")
    public void deleteCharacter(@PathVariable String characterId)
    {
        tibiaCharacterService.deleteTibiaCharacter(characterId);
    }



}
