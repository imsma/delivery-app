package im.sma.bysma.deliveryapp.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record MenuResponse(UUID id,
        String name,
        BigDecimal price) {
    public static MenuResponse instance(UUID id, String name, BigDecimal price) {
        return new MenuResponse(id, name, price);
    }
}