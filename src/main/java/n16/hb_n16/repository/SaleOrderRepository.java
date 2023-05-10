package n16.hb_n16.repository;

import n16.hb_n16.entity.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
    @Query(value = "from SaleOrder where customer_id = :customerID", nativeQuery = true)
    List<SaleOrder> getSaleOrdersByCustomerID(@Param("customerID") int customerID);

    @Query(value = "from SaleOrder where sale_order_id = :saleOrderID", nativeQuery = true)
    SaleOrder getSaleOrderBySaleOrderID(@Param("saleOrderID") int saleOrderID);

    @Query(value = "from SaleOrder where status = :status_value", nativeQuery = true)
    List<SaleOrder> getSaleOrderByStatus(@Param("status_value") short status);

    @Query(value = "from SaleOrder where DAY(order_date) = :day AND MONTH(order_date) = :month AND YEAR(order_date) = :year", nativeQuery = true)
    List<SaleOrder> getSaleOrderToday(@Param("day") int day, @Param("month") int month, @Param("year") int year);

    @Query(value = "from SaleOrder where MONTH(order_date) = :month AND YEAR(order_date) = :year", nativeQuery = true)
    List<SaleOrder> getSaleOrderThisMonth(@Param("month") int month, @Param("year") int year);

    @Query(value = "select * from sale_orders where order_date >= CONVERT(DATETIME, :startOfWeek) and order_date <= CONVERT(DATETIME, :EndOfWeek)", nativeQuery = true)
    List<SaleOrder> getSaleOrderThisWeek(@Param("startOfWeek") String startOfWeek, @Param("EndOfWeek") String EndOfWeek);

    @Query(value = "select top 5 * from sale_orders where "
            + "phone like :keyword or sale_order_id like :keyword or "
            + "customer_id like :keyword", nativeQuery = true)
    List<SaleOrder> getSaleOrderALikeByKeyWord(@Param("keyword") String keyword);
}
