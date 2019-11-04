package application.controller;

import application.service.FightTournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fighter/")
public class FightController {

    @Autowired
    private FightTournamentService fightTournamentService;

    @PostMapping("joinTournament/{fighterId}")
    public ResponseEntity joinNextTournament(@PathVariable Long fighterId){
        fightTournamentService.joinNextTournament(fighterId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
