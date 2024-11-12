package im.sma.bysma.deliveryapp.order.event;

import java.util.List;

import im.sma.bysma.deliveryapp.order.dto.OrderItem;

public record OrderCreateEvent(List<OrderItem> orderItems) {
    public static OrderCreateEvent instance(List<OrderItem> orderItems) {
        return new OrderCreateEvent(orderItems);
    }
}
