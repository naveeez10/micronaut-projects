package co.incubyte.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @UuidGenerator
    private String id;
    private Integer quantity;

    public Order() {
    }

    public Order(Integer quantity) {
        this.quantity = quantity;
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
