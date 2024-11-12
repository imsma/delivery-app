package im.sma.bysma.deliveryapp.delivery.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import im.sma.bysma.deliveryapp.delivery.dto.OrderItem;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeliverOrderComponent {

    public void deliverOrder(List<OrderItem> orderItems) {
        BigDecimal totalPrice = orderItems.stream()
                .map(OrderItem::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        log.info("Order delivered with total price: {}", totalPrice);
    }
}
