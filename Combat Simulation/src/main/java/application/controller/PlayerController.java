package application.controller;

import application.domain.Player;
import application.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player/")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("create")
    public ResponseEntity<Player> createNewPlayer(@RequestBody Player newPlayer){
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.createNewPlayer(newPlayer));
    }

    @GetMapping("random")
    public ResponseEntity<Player> getRandomPlayer(){
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.getRandomPlayer());
    }

}
