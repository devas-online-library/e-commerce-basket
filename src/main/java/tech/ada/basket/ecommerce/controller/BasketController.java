package tech.ada.basket.ecommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tech.ada.basket.ecommerce.dto.BasketItemRequest;
import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.service.BasketService;

import java.util.Optional;


@RestController
public class BasketController {


    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/baskets/create")
    public ResponseEntity<Basket> createBasket(@RequestBody Basket basket) {
        Basket createdBasket = basketService.createBasket(basket);
        return new ResponseEntity<>(createdBasket, HttpStatus.CREATED);
    }

    @PostMapping("/baskets/add-items")
    public ResponseEntity<Void> addItemToBasket(@RequestBody BasketItemRequest basketItemRequest) {
        basketService.addItemToBasket(basketItemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/baskets/{basketId}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Long basketId) {
        Optional<Basket> basket = basketService.getBasketById(basketId);
        return basket.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/baskets/{basketId}/close")
    public ResponseEntity<Void> closeBasket(@PathVariable Long basketId) {
        basketService.closeBasket(basketId);
        return ResponseEntity.noContent().build();
    }
}
