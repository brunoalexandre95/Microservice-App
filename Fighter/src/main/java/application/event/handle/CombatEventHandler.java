package application.event.handle;

import application.domain.Fighter;
import application.repository.FighterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class CombatEventHandler {

    @Autowired
    private FighterRepository fighterRepository;

    @RabbitListener(queues = "${combat.queue}")
    void handleCombatEvent(CombatEvent event) {
        log.info("Combat Event received with winner: {}", event.getWinner());
        try {
            String f1 = event.getFighterOne();
            String f2 = event.getFighterTwo();
            String winner = event.getWinner();

            Fighter fighterOne = fighterRepository.findByName(f1);
            Fighter fighterTwo = fighterRepository.findByName(f2);

            if(f1.equals(winner)){
                fighterOne.incrementVictories();
                fighterTwo.incrementLosses();
            }
            else{
                fighterOne.incrementLosses();
                fighterTwo.incrementVictories();
            }

            fighterRepository.save(fighterOne);
            fighterRepository.save(fighterTwo);

        } catch (final Exception e) {
            log.error("Error when trying to process Combat event", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
