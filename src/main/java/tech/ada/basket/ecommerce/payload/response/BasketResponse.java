package tech.ada.basket.ecommerce.payload.response;

import lombok.Data;
import tech.ada.basket.ecommerce.model.enums.BasketStatus;
import tech.ada.basket.ecommerce.payload.response.entities.Items;

import java.util.List;

@Data
public class BasketResponse {
    private String basketId;
    private String clientId;
    private double totalValue;
    private BasketStatus basketStatus;
    private List<Items> items;
}
