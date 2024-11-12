package im.sma.bysma.deliveryapp.order.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import im.sma.bysma.deliveryapp.order.event.OrderCreateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventPublisher {

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;
    @Value("${spring.rabbitmq.routing-key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void publishOrderCreatedEvent(OrderCreateEvent orderCreateEvent) {
        try {
            String message = objectMapper.writeValueAsString(orderCreateEvent);
            rabbitTemplate.convertAndSend(exchangeName, routingKey, message);

        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

}
