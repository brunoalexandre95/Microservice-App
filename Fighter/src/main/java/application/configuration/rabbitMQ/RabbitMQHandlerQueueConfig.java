package application.configuration.rabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHandlerQueueConfig {

    @Bean
    public Queue customerAnalyticsQueue(@Value("${combat.queue}") final String queueName) {
        return new Queue(queueName, true);
    }

    @Bean
    Binding binding(final Queue queue, @Value("${combat.exchange}") final String exchangeName,
                    @Value("${combat.registered.key}") final String routingKey) {
        return BindingBuilder.bind(queue).to(new TopicExchange(exchangeName)).with(routingKey);
    }
}
