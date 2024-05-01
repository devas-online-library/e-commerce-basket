package tech.ada.basket.ecommerce.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.basket.ecommerce.mapping.ConvertBasketToBasketResponse;
import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.payload.response.BasketResponse;
import tech.ada.basket.ecommerce.repository.BasketRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckBasketService {

    private final BasketRepository basketRepository;

    @Transactional
    public BasketResponse execute(String basketId) {
        Basket basket = basketRepository.getReferenceById(UUID.fromString(basketId));
        return ConvertBasketToBasketResponse.convertToBasketResponse(basket);
    }

}
