package n16.hb_n16.repository;

import n16.hb_n16.entity.BagImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BagImageRepository extends JpaRepository<BagImage,Integer> {
    @Query(value = "from BagImage where bag_id = :bagID")
    List<BagImage> getBagImagesByBagId(@Param("bagID") int bagID);
}
