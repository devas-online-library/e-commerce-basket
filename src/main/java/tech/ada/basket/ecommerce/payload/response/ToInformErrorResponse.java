package tech.ada.basket.ecommerce.payload.response;

import lombok.Data;

@Data
public class ToInformErrorResponse {

    private String basketId;
    private String error;

}
