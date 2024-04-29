package tech.ada.basket.ecommerce.formatter;

import tech.ada.basket.ecommerce.model.Basket;

public interface BasketFormatter <T> {
    T formatBasket(Basket basket);
}

