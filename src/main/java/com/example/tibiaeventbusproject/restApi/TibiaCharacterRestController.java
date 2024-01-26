package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaCharacterResources.TibiaCharacter;
import com.example.tibiaeventbusproject.services.TibiaCharacterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addCharacter(@RequestBody TibiaCharacter tibiaCharacter) {
        if(tibiaCharacter!=null) {
            tibiaCharacterService.addTibiaCharacter(tibiaCharacter);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //PUT /api/tibia/characters/{characterId}: Aktualizacja profilu postaci.
    @PutMapping("/characters/{characterId}")
    public ResponseEntity updateCharacterPassword(@PathVariable String characterId,@RequestBody TibiaCharacter tibiaCharacter) throws JsonProcessingException {
        if(tibiaCharacter!=null)
        {
            String passwordFromObject = tibiaCharacter.getPassword();
            tibiaCharacterService.updateTibiaCharacter(characterId,passwordFromObject);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //DELETE /api/tibia/characters/{characterId}: Usunięcie postaci z konta użytkownika.
    @DeleteMapping("/characters/{characterId}")
    public void deleteCharacter(@PathVariable String characterId)
    {
        tibiaCharacterService.deleteTibiaCharacter(characterId);
    }



}
