package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "brands")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "name", columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<BagCategory> listBagCategories;

    public Brand(String name, List<BagCategory> listBagCategories) {
        this.name = name;
        this.listBagCategories = listBagCategories;
    }

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BagCategory> getListBagCategories() {
        return listBagCategories;
    }

    public void setListBagCategories(List<BagCategory> listBagCategories) {
        this.listBagCategories = listBagCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return brandId == brand.brandId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", name='" + name + '\'' +
                ", listBagCategories=" + listBagCategories +
                '}';
    }
}
