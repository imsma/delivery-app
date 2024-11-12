package im.sma.bysma.deliveryapp.delivery.dto;

import java.math.BigDecimal;

public record OrderItem(String itemName, BigDecimal price) {
    public static OrderItem instance(String name, BigDecimal price) {
        return new OrderItem(name, price);
    }
}
