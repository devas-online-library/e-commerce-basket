package tech.ada.basket.ecommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.payload.request.BasketRequest;
import tech.ada.basket.ecommerce.payload.request.entities.Items;
import tech.ada.basket.ecommerce.payload.response.BasketResponse;
import tech.ada.basket.ecommerce.repository.BasketRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveItemToBasketService {

    private final BasketRepository basketRepository;

    public BasketResponse addItemToBasket(BasketRequest basketRequest) {
        log.info("Adding item to basket {}", basketRequest);

        Basket basket = basketRepository.findById(UUID.fromString(basketRequest.getBasketId())).get();

        Items item = new Items();
        item.setSku(basketRequest.getSku());
        item.setPrice(basketRequest.getPreco());
        item.setQuantity((basketRequest.getQuantidade()));

        basket.addItem(item);
        Basket savedBasket = basketRepository.save(basket);

        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setBasketId(savedBasket.getBasketId().toString());



        return basketResponse;
    }

}
