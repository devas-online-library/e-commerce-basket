package tech.ada.basket.ecommerce.rest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tech.ada.basket.ecommerce.payload.request.BasketRequest;
import tech.ada.basket.ecommerce.payload.response.BasketResponse;

import tech.ada.basket.ecommerce.service.CheckBasketService;
import tech.ada.basket.ecommerce.service.SaveItemToBasketService;


@RestController
@RequestMapping(name = "/baskets")
@RequiredArgsConstructor
public class BasketController {


    private final SaveItemToBasketService saveItemToBasketService;
    private final CheckBasketService checkBasketService;

    @PostMapping(value = "/baskets")
    @Operation(summary = "Add item to basket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item successfully added"),
            @ApiResponse(responseCode = "400", description = "Error adding item"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public BasketResponse addItem(@RequestBody BasketRequest basketRequest){
        return saveItemToBasketService.addItemToBasket(basketRequest);
    }

    @GetMapping(value = "/baskets/{id}")
    @Operation(summary = "Check basket itens and total value")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Baskets data"),
            @ApiResponse(responseCode = "404", description = "Error when checking basket"),
    })
    public BasketResponse checkBasket(@PathVariable(name = "id") String basketId) {
        return checkBasketService.execute(basketId);
    }


}
