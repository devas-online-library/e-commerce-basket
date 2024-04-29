package tech.ada.basket.ecommerce.formatter;

import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.model.BasketItem;

public class BasketToJson implements BasketFormatter{

    @Override
    public String formatBasket(Basket basket) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"id_carrinho\": \"" + basket.getBasketId() + "\",\n");
        json.append("  \"id_cliente\": \"" + basket.getCustomerId() + "\",\n");
        json.append("  \"valor_total\": " + basket.getTotalValue() + ",\n");
        json.append("  \"status\": \"" + basket.getStatus().name() + "\",\n");
        json.append("  \"itens\": [\n");
        for (int i = 0; i < basket.getItems().size(); i++) {
            BasketItem item = basket.getItems().get(i);
            json.append("    {\n");
            json.append("      \"sku\": \"" + item.getSku() + "\",\n");
            json.append("      \"preco\": " + item.getPrice() + ",\n");
            json.append("      \"quantidade\": \"" + item.getQuantity() + "\"\n");
            json.append("    }");
            if (i < basket.getItems().size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }
        json.append("  ]\n");
        json.append("}");
        return json.toString();
    }
}
