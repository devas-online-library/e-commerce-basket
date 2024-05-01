package tech.ada.basket.ecommerce.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema
public class BasketRequest {

        private String basketId;
        private Long clienteId;
        private Long sku;
        private double preco;
        private String quantidade;
}
