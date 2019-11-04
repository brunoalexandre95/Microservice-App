package application.service;

import application.domain.Combat;
import application.dto.PlayerDTO;
import application.event.combatResult.CombatEvent;
import application.event.combatResult.CombatEventDispatcher;
import application.repository.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class CombatService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CombatRepository combatRepository;

    @Autowired
    private CombatEventDispatcher combatEventDispatcher;

    @Value("${playerHost}")
    private String playerHost;

    public Combat createAFightAndReturnResult() {

        PlayerDTO player1 = restTemplate.getForObject(
                playerHost + "/api/player/random",
                PlayerDTO.class);



        PlayerDTO player2 = restTemplate.getForObject(
                playerHost + "/api/player/random",
                PlayerDTO.class);

        Combat comb = new Combat();
        comb.setCombatDate(new Date());


        comb = combatRepository.save(comb);

        CombatEvent combatEvent = new CombatEvent(player1.getName(),player2.getName(), player1.getName());
        combatEventDispatcher.send(combatEvent);

        return comb;
    }



}
