package tech.ada.basket.ecommerce.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.model.enums.BasketStatus;
import tech.ada.basket.ecommerce.payload.response.ToInformErrorResponse;
import tech.ada.basket.ecommerce.repository.BasketRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentErrorHandlerService {
    private final BasketRepository basketRepository;

    public void execute(ToInformErrorResponse toInformErrorResponse) {
        log.info("Handling payment error response {}", toInformErrorResponse);
        Basket basket = basketRepository.findById(UUID.fromString(toInformErrorResponse.getBasketId())).get();
        basket.setStatus(BasketStatus.PENDING);
        basketRepository.save(basket);
    }
}