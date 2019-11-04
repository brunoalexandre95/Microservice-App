package application.event.dispatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class FighterJoinEventDispatcher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${fighter.join.exchange}")
    private String fighterJoinExchange;

    @Value("${fighter.join.registered.key}")
    private String fighterJoinRoutingKey;

    public void send(final FighterJoinEvent fighterJoinEvent) {
        rabbitTemplate.convertAndSend(
                fighterJoinExchange,
                fighterJoinRoutingKey,
                fighterJoinEvent);
    }
}
