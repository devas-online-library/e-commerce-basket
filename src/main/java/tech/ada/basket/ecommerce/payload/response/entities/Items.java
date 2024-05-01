package tech.ada.basket.ecommerce.payload.response.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class Items {
    private String sku;
    private Double preco;
    private Double quantidade;

}