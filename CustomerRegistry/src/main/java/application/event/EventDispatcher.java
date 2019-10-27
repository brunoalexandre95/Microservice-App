package application.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class EventDispatcher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${customer-registry.exchange}")
    private String customerRegistryExchange;

    @Value("${customer-registry.registered.key}")
    private String registeredCustomerRoutingKey;

    public void send(final CustomerRegisteredEvent customerRegisteredEvent) {
        rabbitTemplate.convertAndSend(
                customerRegistryExchange,
                registeredCustomerRoutingKey,
                customerRegisteredEvent);
    }
}
