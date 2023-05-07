package n16.hb_n16.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartDetailPK implements Serializable {
    private int cartHeader;
    private int bag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDetailPK that = (CartDetailPK) o;
        return cartHeader == that.cartHeader && bag == that.bag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartHeader, bag);
    }
}
