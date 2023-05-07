package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cart_headers")
public class CartHeader implements Serializable {
    @Id
    private int customerId;
    @Column(name = "total_price", columnDefinition = "money", nullable = false)
    private BigDecimal totalPrice;
    @Column(name = "total_quantity", columnDefinition = "int", nullable = false)
    private int totalQuantity;
    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private User customer;

    public CartHeader(BigDecimal totalPrice, int totalQuantity, User customer) {
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.customer = customer;
    }

    public CartHeader() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartHeader that = (CartHeader) o;
        return customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "CartHeader{" +
                "customerId=" + customerId +
                ", totalPrice=" + totalPrice +
                ", totalQuantity=" + totalQuantity +
                ", customer=" + customer +
                '}';
    }
}
