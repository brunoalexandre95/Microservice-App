package application.configuration.rabbitMQ;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDispatcherExchangeConfiguration {

    @Bean
    public TopicExchange fighterJoinExchange(@Value("${fighter.join.exchange}") final String exchangeName) {
        return new TopicExchange(exchangeName);
    }
}
