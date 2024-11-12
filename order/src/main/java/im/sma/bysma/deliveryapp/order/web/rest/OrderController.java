package im.sma.bysma.deliveryapp.order.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import im.sma.bysma.deliveryapp.order.domain.MenuEntity;
import im.sma.bysma.deliveryapp.order.dto.MenuItemRequest;
import im.sma.bysma.deliveryapp.order.dto.MenuResponse;
import im.sma.bysma.deliveryapp.order.repository.MenuRepository;
import im.sma.bysma.deliveryapp.order.utility.MenuItemMapper;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private MenuRepository menuRepository;

    public OrderController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MenuResponse>> getMenu() {
        List<MenuEntity> menuList = menuRepository.findAll();
        List<MenuResponse> menuResponses = MenuItemMapper.toResponse(menuList);

        return new ResponseEntity<>(menuResponses, null, HttpStatus.OK);
    }

    @PostMapping("/menu")
    public MenuResponse createMenuItem(@RequestBody MenuItemRequest menuItemRequest) {
        MenuEntity menuEntity = MenuEntity.builder()
                .itemName(menuItemRequest.name())
                .price(menuItemRequest.price())
                .build();
        menuRepository.save(menuEntity);
        return MenuItemMapper.toResponse(menuEntity);
    }

}
