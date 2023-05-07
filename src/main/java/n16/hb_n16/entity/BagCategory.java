package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bag_categories")
public class BagCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bag_category_id")
    private int bagCategoryId;
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    @Column(name = "name", columnDefinition = "nvarchar(MAX)", nullable = false)
    private String name;
    @Column(name = "size", columnDefinition = "varchar(80)", nullable = false)
    private String size;
    @Column(name = "weight", columnDefinition = "real", nullable = false)
    private double weight;
    @Column(name = "cover_photo", columnDefinition = "text", nullable = false)
    private String coverPhoto;
    @Column(name = "short_description", columnDefinition = "nvarchar(255)", nullable = false)
    private String shortDescription;
    @Column(name = "long_description", columnDefinition = "nvarchar(MAX)", nullable = false)
    private String longDescription;
    @Column(name = "import_date", columnDefinition = "date", nullable = false)
    private LocalDate importDate;
    @OneToMany(mappedBy = "bagCategory")
    private List<Bag> listBags;

    public BagCategory(Brand brand, String name, String size, double weight, String coverPhoto, String shortDescription, String longDescription, LocalDate importDate, List<Bag> listBags) {
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.coverPhoto = coverPhoto;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.importDate = importDate;
        this.listBags = listBags;
    }

    public BagCategory() {
    }

    public int getBagCategoryId() {
        return bagCategoryId;
    }

    public void setBagCategoryId(int bagCategoryId) {
        this.bagCategoryId = bagCategoryId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public List<Bag> getListBags() {
        return listBags;
    }

    public void setListBags(List<Bag> listBags) {
        this.listBags = listBags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagCategory that = (BagCategory) o;
        return bagCategoryId == that.bagCategoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagCategoryId);
    }

    @Override
    public String toString() {
        return "BagCategory{" +
                "bagCategoryId=" + bagCategoryId +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", importDate=" + importDate +
                ", listBags=" + listBags +
                '}';
    }
}
