package application.controller;

import application.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tournament/")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("new")
    public ResponseEntity<String> createNewTournament(){
        return ResponseEntity.ok( tournamentService.createNewTournament());
    }

    @PostMapping("start")
    public ResponseEntity<String> startTournament(){
        return ResponseEntity.ok( tournamentService.startTournament());
    }

}
