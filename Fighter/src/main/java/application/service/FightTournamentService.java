package application.service;

import application.domain.Fighter;
import application.event.dispatch.FighterJoinEvent;
import application.event.dispatch.FighterJoinEventDispatcher;
import application.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightTournamentService {

    @Autowired
    private FighterJoinEventDispatcher fighterJoinEventDispatcher;

    @Autowired
    private FighterRepository fighterRepository;

    public void joinNextTournament(Long fighterId) {
        Fighter fighter = fighterRepository.findById(fighterId);
        FighterJoinEvent event = new FighterJoinEvent(fighterId,fighter.getName());
        fighterJoinEventDispatcher.send(event);
    }
}
