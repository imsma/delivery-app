package im.sma.bysma.deliveryapp.delivery.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import im.sma.bysma.deliveryapp.delivery.service.DeliverOrderComponent;
import im.sma.bysma.deliveryapp.delivery.event.OrderCreateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryListener {
    private final ObjectMapper objectMapper;
    private final DeliverOrderComponent deliverOrderComponent;

    @RabbitListener(queues = "${spring.rabbitmq.queue-name}")
    public void handleDeliveryEvent(String event) throws JsonProcessingException {
        try {
            log.info("Delivery event received: {}", event);
            OrderCreateEvent orderCreateEvent = objectMapper.readValue(event, OrderCreateEvent.class);
            deliverOrderComponent.deliverOrder(orderCreateEvent.orderItems());
        } catch (Exception e) {
            log.error("Error processing delivery event: {}", e.getMessage());
            throw e;
        }

    }

}
