package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@IdClass(SaleOrderDetailPK.class)
@Table(name = "sale_order_details")
public class SaleOrderDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "sale_order_id")
    private SaleOrder saleOrder;
    @Id
    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;
    @Column(name = "order_qty", columnDefinition = "int", nullable = false)
    private int orderQty;
    @Column(name = "unit_price", columnDefinition = "money", nullable = false)
    private BigDecimal unitPrice;
    @Column(name = "line_total", columnDefinition = "money", nullable = false)
    private BigDecimal lineTotal;

    public SaleOrderDetail(SaleOrder saleOrder, Bag bag, int orderQty, BigDecimal unitPrice, BigDecimal lineTotal) {
        this.saleOrder = saleOrder;
        this.bag = bag;
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
        this.lineTotal = lineTotal;
    }

    public SaleOrderDetail() {
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }

    @Override
    public String toString() {
        return "SaleOrderDetail{" +
                "saleOrder=" + saleOrder +
                ", bag=" + bag +
                ", orderQty=" + orderQty +
                ", unitPrice=" + unitPrice +
                ", lineTotal=" + lineTotal +
                '}';
    }
}
