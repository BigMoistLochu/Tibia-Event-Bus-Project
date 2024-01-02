package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.tibiaCharacterResources.TibiaCharacter;
import com.example.tibiaeventbusproject.services.TibiaCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<TibiaCharacter> getCharacters()
    {
        return tibiaCharacterService.getAllTibiaCharacters();
    }

    ///api/tibia/characters/{characterId}
    @PutMapping("/characters/{characterId}")
    public void updateCharacter(@PathVariable String characterId, @RequestBody TibiaCharacter tibiaCharacter)
    {
        //dostajesz obiekt, wyciagasz obiekt z bazy poprzedni, nadpisujesz elementy i wysylasz
        System.out.println("uptade");
        System.out.println(tibiaCharacter.getEmail());

    }
    //DELETE /api/tibia/characters/{characterId}:
    @DeleteMapping("/characters/{characterId}")
    public void deleteCharacter(@PathVariable String characterId)
    {
        System.out.println("delete");
    }

}
