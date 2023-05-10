package n16.hb_n16.repository;

import n16.hb_n16.entity.SaleOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleOrderDetailRepository extends JpaRepository<SaleOrderDetail, Integer> {
    @Query(value = "from SaleOrderDetail where sale_order_id = :saleOrderID", nativeQuery = true)
    List<SaleOrderDetail> getSaleOrderDetailsBySaleOrderID(@Param("saleOrderID") int saleOrderID);

    @Query(value = "from SaleOrderDetail where bag_id = :bagID", nativeQuery = true)
    List<SaleOrderDetail> getSaleOrderDetailsByBagID(@Param("bagID") int bagID);

    @Query(value = "from SaleOrderDetail where sale_order_id = :saleOrderID AND bag_id = :bagID", nativeQuery = true)
    SaleOrderDetail getSaleOrderDetailBySaleOrderIdAndBagId(@Param("saleOrderID") int saleOrderID, @Param("bagID") int bagID);
}
