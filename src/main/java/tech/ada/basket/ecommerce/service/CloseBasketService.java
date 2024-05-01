package tech.ada.basket.ecommerce.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.basket.ecommerce.mapping.ConvertBasketToBasketResponse;
import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.model.enums.BasketStatus;
import tech.ada.basket.ecommerce.payload.request.BasketRequest;
import tech.ada.basket.ecommerce.payload.response.BasketInfoResponse;
import tech.ada.basket.ecommerce.payload.response.BasketResponse;
import tech.ada.basket.ecommerce.repository.BasketRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CloseBasketService {
    private final BasketRepository basketRepository;


    public void execute(BasketInfoResponse basketInfoResponse) {

        log.info("Closing basket {}", basketInfoResponse);

        Basket basket = basketRepository.findById(UUID.fromString(basketInfoResponse.getBasketId())).get();

        basket.setStatus(BasketStatus.COMPLETED);
        basketRepository.save(basket);
    }


}
