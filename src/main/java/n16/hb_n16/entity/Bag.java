package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="bags")
public class Bag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bagId;
    @ManyToOne
    @JoinColumn(name = "bag_category_id",nullable = false)
    private BagCategory bagCategory;
    @Column(name = "color",columnDefinition = "nvarchar(80)",nullable = false)
    private String color;
    @Column(name = "price", columnDefinition = "money", nullable = false)
    private BigDecimal price;
    @Column(name = "quantity", columnDefinition = "int", nullable = false)
    private int quantity;
    @OneToMany(mappedBy = "bag")
    private List<SaleOrderDetail> listSaleOrderDetails;

    @OneToMany(mappedBy = "bag")
    private List<BagImage> listBagImages;

    @OneToMany(mappedBy = "bag")
    private List<BagReview> listBagReviews;

    public Bag(BagCategory bagCategory, String color, BigDecimal price, int quantity, List<SaleOrderDetail> listSaleOrderDetails, List<BagImage> listBagImages, List<BagReview> listBagReviews) {
        this.bagCategory = bagCategory;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.listSaleOrderDetails = listSaleOrderDetails;
        this.listBagImages = listBagImages;
        this.listBagReviews = listBagReviews;
    }

    public Bag() {
    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public BagCategory getBagCategory() {
        return bagCategory;
    }

    public void setBagCategory(BagCategory bagCategory) {
        this.bagCategory = bagCategory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<SaleOrderDetail> getListSaleOrderDetails() {
        return listSaleOrderDetails;
    }

    public void setListSaleOrderDetails(List<SaleOrderDetail> listSaleOrderDetails) {
        this.listSaleOrderDetails = listSaleOrderDetails;
    }

    public List<BagImage> getListBagImages() {
        return listBagImages;
    }

    public void setListBagImages(List<BagImage> listBagImages) {
        this.listBagImages = listBagImages;
    }

    public List<BagReview> getListBagReviews() {
        return listBagReviews;
    }

    public void setListBagReviews(List<BagReview> listBagReviews) {
        this.listBagReviews = listBagReviews;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bagId=" + bagId +
                ", bagCategory=" + bagCategory +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", listSaleOrderDetails=" + listSaleOrderDetails +
                ", listBagImages=" + listBagImages +
                ", listBagReviews=" + listBagReviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return bagId == bag.bagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagId);
    }
}
