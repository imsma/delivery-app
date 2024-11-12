package im.sma.bysma.deliveryapp.order.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import im.sma.bysma.deliveryapp.order.domain.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {

}
