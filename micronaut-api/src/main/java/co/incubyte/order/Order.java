package co.incubyte.order;

import co.incubyte.product.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @UuidGenerator
    private String id;
    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order() {
    }

    public Order(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;

    }

    public String getId() {
        return id;
    }

    public void setId(String orderId) {
        this.id = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
