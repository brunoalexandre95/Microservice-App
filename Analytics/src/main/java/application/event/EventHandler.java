package application.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class EventHandler {

    @RabbitListener(queues = "${customer.queue}")
    void handleMultiplicationSolved(final CustomerRegisteredEvent event) {
        log.info("Customer Event received: {}", event.getFirstName());
        try {
           //do nothing for now
        } catch (final Exception e) {
            log.error("Error when trying to process Customer event", e);
            // Avoids the event to be re-queued and reprocessed.
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
