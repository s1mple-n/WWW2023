package n16.hb_n16.services;

import n16.hb_n16.entity.SaleOrderDetail;

import java.util.List;

public interface SaleOrderDetailService {
    List<SaleOrderDetail> getAllSaleOrderDetail();
    List<SaleOrderDetail> getAllSaleOrderDetailsBySaleOrderID(int saleOrderID);
    List<SaleOrderDetail> getSaleOrderDetailsByBagID(int bagID);
    SaleOrderDetail getSaleOrderDetailBySaleOrderIdAndBagId(int saleOrderID, int bagID);
    void addOrUpdateSaleOrderDetail(SaleOrderDetail saleOrderDetail);
}
