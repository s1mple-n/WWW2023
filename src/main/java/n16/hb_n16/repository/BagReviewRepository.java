package n16.hb_n16.repository;

import n16.hb_n16.entity.BagReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BagReviewRepository extends JpaRepository<BagReview,Integer> {
    @Query(value = "from BagReview where bag_id = :bagID",nativeQuery = true)
    List<BagReview> getBagReviewsByBagID(@Param("bagID") int bagID);
}
