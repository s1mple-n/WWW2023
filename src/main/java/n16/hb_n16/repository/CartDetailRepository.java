package n16.hb_n16.repository;

import jakarta.transaction.Transactional;
import n16.hb_n16.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
    @Query(value = "from CartDetail where cart_header_id = :cartID",nativeQuery = true)
    List<CartDetail> getCartDetailsByCartHeaderID(@Param("cartID") int cartID);

    @Query(value = "from CartDetail where bag_id = :bagID",nativeQuery = true)
    List<CartDetail> getCartDetailsByBagID(@Param("bagID") int bagID);

    @Query(value ="from CartDetail where cart_header_id = :cartID AND bag_id = :bagID",nativeQuery = true)
    CartDetail getCartDetailByCartHeaderIdAndBagId(@Param("cartID") int cartID, @Param("bagID") int bagID);

    @Modifying
    @Transactional
    @Query(value ="delete from CartDetail where cart_header_id = :cartID",nativeQuery = true)
    void deleteCartDetailByCartHeaderId(@Param("cartID") int cartID);

    @Modifying
    @Transactional
    @Query(value ="delete from CartDetail where cart_header_id = :cartID AND bag_id = :bagID",nativeQuery = true)
    void deleteCartDetailByCartHeaderIdAndBagId(@Param("cartID") int cartID, @Param("bagID") int bagID);
}
