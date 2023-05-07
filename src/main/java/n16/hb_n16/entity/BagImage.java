package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bag_images")
public class BagImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bag_image_id")
    private int bagImageId;
    @ManyToOne
    @JoinColumn(name = "bag_id", nullable = false)
    private Bag bag;
    @Column(name = "image", columnDefinition = "text", nullable = false)
    private String image;

    public BagImage(Bag bag, String image) {
        this.bag = bag;
        this.image = image;
    }

    public BagImage() {
    }

    public int getBagImageId() {
        return bagImageId;
    }

    public void setBagImageId(int bagImageId) {
        this.bagImageId = bagImageId;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagImage bagImage = (BagImage) o;
        return bagImageId == bagImage.bagImageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagImageId);
    }

    @Override
    public String toString() {
        return "BagImage{" +
                "bagImageId=" + bagImageId +
                ", bag=" + bag +
                ", image='" + image + '\'' +
                '}';
    }
}
