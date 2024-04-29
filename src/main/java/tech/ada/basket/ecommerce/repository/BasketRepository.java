package tech.ada.basket.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.basket.ecommerce.model.Basket;

public interface BasketRepository extends JpaRepository <Basket, Long> {
}
