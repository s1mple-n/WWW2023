package n16.hb_n16.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bag_reviews")
public class BagReview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bag_review_id")
    private int bagReviewId;
    @ManyToOne
    @JoinColumn(name = "bag_id", nullable = false)
    private Bag bag;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;
    @Column(name = "comment", columnDefinition = "nvarchar(500)", nullable = false)
    private String comment;
    @Column(name = "star", columnDefinition = "int", nullable = false)
    private int star;
    @Column(name = "review_date", columnDefinition = "datetime", nullable = false)
    private LocalDateTime reviewDate;

    public BagReview(Bag bag, User customer, String comment, int star, LocalDateTime reviewDate) {
        this.bag = bag;
        this.customer = customer;
        this.comment = comment;
        this.star = star;
        this.reviewDate = reviewDate;
    }

    public BagReview() {
    }

    public int getBagReviewId() {
        return bagReviewId;
    }

    public void setBagReviewId(int bagReviewId) {
        this.bagReviewId = bagReviewId;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagReview bagReview = (BagReview) o;
        return bagReviewId == bagReview.bagReviewId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagReviewId);
    }

    @Override
    public String toString() {
        return "BagReview{" +
                "bagReviewId=" + bagReviewId +
                ", bag=" + bag +
                ", customer=" + customer +
                ", comment='" + comment + '\'' +
                ", star=" + star +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
