package tech.ada.basket.ecommerce.payload.request.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class Items {
    private Long clientId;
    private Long sku;
    private double price;
    private String quantity;
}
