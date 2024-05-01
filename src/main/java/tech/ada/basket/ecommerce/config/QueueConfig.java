package tech.ada.basket.ecommerce.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Value("${domain.basket.queue}")
    private String basketQueueResponse;

    @Value("${domain.payment.queue}")
    private String paymentQueueResponse;

    @Value("${domain.ship.queue}")
    private String shipQueueResponse;

    @Value("${domain.stock.queue}")
    private String stockQueueResponse;

    @Value("${domain.error.routingkey}")
    private String errorRoutingKey;

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    public Queue basketQueue() {
        return new Queue(basketQueueResponse, true);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(paymentQueueResponse, true);
    }

    @Bean
    Binding paymentBinding(Queue paymentQueue, TopicExchange exchange) {
        return BindingBuilder.bind(paymentQueue).to(exchange).with(errorRoutingKey);
    }

    @Bean
    public Queue stockQueue() {
        return new Queue(stockQueueResponse, true);
    }

    @Bean
    Binding stockBinding(Queue stockQueue, TopicExchange exchange) {
        return BindingBuilder.bind(stockQueue).to(exchange).with(errorRoutingKey);
    }

    @Bean
    public Queue shipQueue() {
        return new Queue(shipQueueResponse, true);
    }

    @Bean
    Binding shipBinding(Queue shipQueue, TopicExchange exchange) {
        return BindingBuilder.bind(shipQueue).to(exchange).with(errorRoutingKey);
    }
}
