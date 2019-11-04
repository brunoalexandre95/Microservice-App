package application.event.combatResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CombatEventDispatcher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${combat.exchange}")
    private String combatExchange;

    @Value("${combat.registered.key}")
    private String combatRoutingKey;

    public void send(final CombatEvent combatEvent) {
        rabbitTemplate.convertAndSend(
                combatExchange,
                combatRoutingKey,
                combatEvent);
    }
}
