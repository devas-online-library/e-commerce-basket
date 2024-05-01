package tech.ada.basket.ecommerce.payload.response;

import lombok.Data;

@Data
public class BasketInfoResponse {
    private String basketId;
    private String clientId;
    private double totalValue;
}
