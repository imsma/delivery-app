package im.sma.bysma.deliveryapp.order.dto;

import java.util.List;
import java.util.UUID;

public record CreateOrderRequest(List<UUID> itemIDs) {
    public static CreateOrderRequest instance(List<UUID> itemIDs) {
        return new CreateOrderRequest(itemIDs);
    }
}
