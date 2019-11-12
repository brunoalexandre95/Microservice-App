package application.configuration.rabbitMQ;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDispatcherExchangeConfiguration {

    @Bean
    public TopicExchange customerRegistryExchange(@Value("${combat.exchange}") final String exchangeName) {
        return new TopicExchange(exchangeName);
    }

}
