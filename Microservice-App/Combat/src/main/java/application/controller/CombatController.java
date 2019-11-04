package application.controller;

import application.domain.Combat;
import application.service.CombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/combat/")
public class CombatController {

    @Autowired
    private CombatService combatService;

    @GetMapping("random")
    public ResponseEntity<Combat> getRandomCombat(){
        return ResponseEntity.status(HttpStatus.OK).body(combatService.createAFightAndReturnResult());
    }

}
