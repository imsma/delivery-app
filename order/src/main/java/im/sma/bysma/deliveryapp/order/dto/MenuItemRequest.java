package im.sma.bysma.deliveryapp.order.dto;

import java.math.BigDecimal;

public record MenuItemRequest(String name, BigDecimal price) {
    public static MenuItemRequest instance(String name, BigDecimal price) {
        return new MenuItemRequest(name, price);
    }
}
