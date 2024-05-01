package tech.ada.basket.ecommerce.mapping;

import lombok.experimental.UtilityClass;
import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.payload.response.BasketResponse;

@UtilityClass
public class ConvertBasketToBasketResponse {

    public BasketResponse convertToBasketResponse(Basket basket) {
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setBasketId(String.valueOf(basket.getBasketId()));
        basketResponse.setBasketStatus(basket.getStatus());

        return basketResponse;
    }
}
