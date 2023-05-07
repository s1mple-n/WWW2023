package n16.hb_n16.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SaleOrderDetailPK implements Serializable {
    private int saleOrder;
    private int bag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleOrderDetailPK that = (SaleOrderDetailPK) o;
        return saleOrder == that.saleOrder && bag == that.bag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleOrder, bag);
    }
}
