package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@IdClass(CartDetailPK.class)
@Table(name = "cart_details")
public class CartDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "cart_header_id")
    private CartHeader cartHeader;
    @Id
    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;
    @Column(name = "bag_qty", columnDefinition = "int", nullable = false)
    private int bagQty;

    public CartDetail(CartHeader cartHeader, Bag bag, int bagQty) {
        this.cartHeader = cartHeader;
        this.bag = bag;
        this.bagQty = bagQty;
    }

    public CartDetail() {
    }

    public CartHeader getCartHeader() {
        return cartHeader;
    }

    public void setCartHeader(CartHeader cartHeader) {
        this.cartHeader = cartHeader;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public int getBagQty() {
        return bagQty;
    }

    public void setBagQty(int bagQty) {
        this.bagQty = bagQty;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "cartHeader=" + cartHeader +
                ", bag=" + bag +
                ", bagQty=" + bagQty +
                '}';
    }
}
