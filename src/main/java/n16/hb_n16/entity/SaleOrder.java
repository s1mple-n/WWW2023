package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sale_orders")
public class SaleOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_order_id")
    private int saleOrderId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;
    @Column(name = "order_date", columnDefinition = "datetime", nullable = false)
    private LocalDateTime orderDate;
    @Column(name = "due_date", columnDefinition = "datetime", nullable = false)
    private LocalDateTime dueDate;
    @Column(name = "ship_date", columnDefinition = "datetime")
    private LocalDateTime shipDate;
    @Column(name = "status", columnDefinition = "tinyint", nullable = false)
    private short status;
    @Column(name = "address", columnDefinition = "nvarchar(300)", nullable = false)
    private String address;
    @Column(name = "phone", columnDefinition = "varchar(10)", nullable = false)
    private String phone;
    @Column(name = "comment", columnDefinition = "nvarchar(300)")
    private String comment;
    @Column(name = "sub_total", columnDefinition = "money", nullable = false)
    private BigDecimal subTotal;
    @Column(name = "tax_vat", columnDefinition = "money", nullable = false)
    private BigDecimal taxVat;
    @Column(name = "freight", columnDefinition = "money", nullable = false)
    private BigDecimal freight;
    @Column(name = "total_due", columnDefinition = "money", nullable = false)
    private BigDecimal totalDue;
    @OneToMany(mappedBy = "saleOrder")
    private List<SaleOrderDetail> listSaleOrderDetails;

    public SaleOrder(User customer, LocalDateTime orderDate, LocalDateTime dueDate, LocalDateTime shipDate, short status, String address, String phone, String comment, BigDecimal subTotal, BigDecimal taxVat, BigDecimal freight, BigDecimal totalDue, List<SaleOrderDetail> listSaleOrderDetails) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.dueDate = dueDate;
        this.shipDate = shipDate;
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
        this.subTotal = subTotal;
        this.taxVat = taxVat;
        this.freight = freight;
        this.totalDue = totalDue;
        this.listSaleOrderDetails = listSaleOrderDetails;
    }

    public SaleOrder() {
    }

    public int getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(int saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDateTime shipDate) {
        this.shipDate = shipDate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTaxVat() {
        return taxVat;
    }

    public void setTaxVat(BigDecimal taxVat) {
        this.taxVat = taxVat;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    public List<SaleOrderDetail> getListSaleOrderDetails() {
        return listSaleOrderDetails;
    }

    public void setListSaleOrderDetails(List<SaleOrderDetail> listSaleOrderDetails) {
        this.listSaleOrderDetails = listSaleOrderDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleOrder saleOrder = (SaleOrder) o;
        return saleOrderId == saleOrder.saleOrderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleOrderId);
    }

    @Override
    public String toString() {
        return "SaleOrder{" +
                "saleOrderId=" + saleOrderId +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", dueDate=" + dueDate +
                ", shipDate=" + shipDate +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", subTotal=" + subTotal +
                ", taxVat=" + taxVat +
                ", freight=" + freight +
                ", totalDue=" + totalDue +
                ", listSaleOrderDetails=" + listSaleOrderDetails +
                '}';
    }
}
