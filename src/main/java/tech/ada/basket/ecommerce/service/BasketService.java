package tech.ada.basket.ecommerce.service;

import tech.ada.basket.ecommerce.dto.BasketItemRequest;
import tech.ada.basket.ecommerce.model.Basket;

import java.util.Optional;

public interface BasketService {

    
    void addItemToBasket(BasketItemRequest basketItemRequest);

    Optional<Basket> getBasketById(Long basketId);

    void closeBasket(Long basketId);

    Basket createBasket(Basket basket);
}
