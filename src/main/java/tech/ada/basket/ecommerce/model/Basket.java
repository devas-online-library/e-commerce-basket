package tech.ada.basket.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.ada.basket.ecommerce.formatter.BasketFormatter;

import java.util.List;

@Entity
@Table(name = "baskets")
@Getter
@Setter
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long basketId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "total_value")
    private double totalValue;

    @Enumerated(EnumType.STRING)
    private BasketStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id", referencedColumnName = "basket_id")
    private List<BasketItem> items;

    @Transient
    private BasketFormatter<String> formatter;

    public Basket(BasketFormatter<String> formatter) {
        this.formatter = formatter;
    }

    public Basket() {
    }

    public void addItem(BasketItem item) {
        items.add(item);
        totalValue += item.getPrice() * item.getQuantity();
    }

    public String formatBasket() {
        return formatter.formatBasket(this);
    }
}
