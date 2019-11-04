package application.service;

import application.domain.Combat;
import application.domain.Tournament;
import application.domain.TournamentFighter;
import application.event.combatResult.CombatEvent;
import application.event.combatResult.CombatEventDispatcher;
import application.repository.CombatRepository;
import application.repository.TournamentFighterRepository;
import application.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentFighterRepository tournamentFighterRepository;

    @Autowired
    private CombatRepository combatRepository;

    @Autowired
    private CombatEventDispatcher combatEventDispatcher;

    public String createNewTournament(){
        List<Tournament> tournaments = tournamentRepository.findByFinishedFalse();
        if(tournaments.size() > 0){
            return "Already a tournament in process!";
        }
        tournamentRepository.save(new Tournament());
        return "Tournament Created.";
    }

    public String startTournament() {
        List<Tournament> tournaments = tournamentRepository.findByFinishedFalse();
        if(tournaments.size() == 0){
            return "There is no tournament in process!";
        }
        List<TournamentFighter> fighters = tournaments.get(0).getTournamentFighters();

        boolean finish = false;
        while(!finish){

            TournamentFighter f1 = null;
            TournamentFighter f2 = null;

            for(int i = 0; i < fighters.size(); i++){

                if(f1 == null && !fighters.get(i).isEliminated()){
                    f1 = fighters.get(i);
                    continue;
                }

                if(f2 == null && !fighters.get(i).isEliminated()){
                    f2 = fighters.get(i);
                }

                if(f1 != null && f2 != null){
                    Combat combat = new Combat();
                    combat.setFighterA(f1);
                    combat.setFighterB(f2);
                    combat.setCombatDate(new Date());
                    combat.setWinner(f1);
                    combat.setTournament(tournaments.get(0));
                    combatRepository.save(combat);
                    f2.setEliminated(true);
                    tournamentFighterRepository.save(f2);

                    CombatEvent event = new CombatEvent(f1.getName(),f2.getName(),f2.getName());
                    combatEventDispatcher.send(event);

                }
            }

            if(f1 == null || f2 == null){
                finish = true;
            }
        }

        Optional<String> champion = fighters.stream().filter(f -> !f.isEliminated()).map(f->f.getName()).findFirst();
        return champion.get();

    }
}
