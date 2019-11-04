package application.service;

import application.domain.Fighter;
import application.domain.Stats;
import application.dto.FighterDTO;
import application.dto.FighterDTOMapper;
import application.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    public Fighter createNewFighter(Fighter fighter){
        fighter.setStats(new Stats());
        return fighterRepository.save(fighter);
    }


}
