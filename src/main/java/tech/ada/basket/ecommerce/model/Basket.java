package tech.ada.basket.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;
import tech.ada.basket.ecommerce.model.enums.BasketStatus;
import tech.ada.basket.ecommerce.payload.request.entities.Items;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "baskets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private UUID basketId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "total_value")
    private double totalValue;

    @Enumerated(EnumType.STRING)
    private BasketStatus status;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id", referencedColumnName = "basket_id")*/

    private List<Items> items;

    public void addItem(Items item) {
        items.add(item);
        totalValue += item.getPrice() * Integer.parseInt(item.getQuantity());
    }

}
