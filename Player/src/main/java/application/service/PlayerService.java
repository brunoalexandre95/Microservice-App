package application.service;

import application.domain.Player;
import application.domain.Stats;
import application.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createNewPlayer(Player player){
        player.setStats(new Stats());
        return playerRepository.save(player);
    }


    public Player getRandomPlayer() {

        List<Long> ids = playerRepository.findAllIds();
        Random rand = new Random();
        int randomIndex = rand.nextInt(ids.size());

        Long playerId = ids.get(randomIndex);

        return playerRepository.findById(playerId);


    }
}
