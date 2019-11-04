package application.controller;

import application.domain.Fighter;
import application.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fighter/")
public class FighterController {

    @Autowired
    private FighterService fighterService;

    @PostMapping("create")
    public ResponseEntity<Fighter> createNewFighter(@RequestBody Fighter newFighter){
        return ResponseEntity.status(HttpStatus.CREATED).body(fighterService.createNewFighter(newFighter));
    }

}
