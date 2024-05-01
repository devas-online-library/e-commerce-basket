package tech.ada.basket.ecommerce.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketItemRequest {

    private Long basketId;
    private String sku;
    private double price;
    private int quantity;

    public BasketItemRequest(Long basketId, String sku, double price, int quantity) {
        this.basketId = basketId;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }

}
