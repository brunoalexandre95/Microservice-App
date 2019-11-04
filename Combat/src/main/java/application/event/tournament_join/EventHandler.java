package application.event.tournament_join;

import application.event.combatResult.CombatEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class EventHandler {

    @RabbitListener(queues = "${fighter.join.queue}")
    void handleMultiplicationSolved(TournamentFighterJoinEvent event) {
        log.info("Tournament Fighter Join Event received with fighter: {}", event.getFighterName());
        try {
           //do nothing for now
        } catch (final Exception e) {
            log.error("Error when trying to process Combat event", e);
            // Avoids the event to be re-queued and reprocessed.
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
