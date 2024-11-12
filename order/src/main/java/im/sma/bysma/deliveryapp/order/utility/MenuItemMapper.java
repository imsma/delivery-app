package im.sma.bysma.deliveryapp.order.utility;

import java.util.List;

import im.sma.bysma.deliveryapp.order.domain.MenuEntity;
import im.sma.bysma.deliveryapp.order.dto.MenuResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MenuItemMapper {

    public static List<MenuResponse> toResponse(List<MenuEntity> menuItems) {
        if (menuItems == null) {
            return null;
        }

        List<MenuResponse> menuResponses = menuItems.stream()
                .map(menuItem -> MenuResponse.instance(menuItem.getId(), menuItem.getItemName(), menuItem.getPrice()))
                .toList();

        return menuResponses;
    }

    public static MenuResponse toResponse(MenuEntity menuEntity) {
        if (menuEntity == null) {
            return null;
        }

        return MenuResponse.instance(menuEntity.getId(), menuEntity.getItemName(), menuEntity.getPrice());
    }

}
