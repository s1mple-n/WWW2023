package n16.hb_n16.impl;

import n16.hb_n16.entity.SaleOrderDetail;
import n16.hb_n16.repository.SaleOrderDetailRepository;
import n16.hb_n16.services.SaleOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderDetailServiceImpl implements SaleOrderDetailService {

    @Autowired
    private SaleOrderDetailRepository saleOrderDetailRepository;

    public SaleOrderDetailServiceImpl(SaleOrderDetailRepository saleOrderDetailRepository) {
        this.saleOrderDetailRepository = saleOrderDetailRepository;
    }

    @Override
    public List<SaleOrderDetail> getAllSaleOrderDetail() {
        return saleOrderDetailRepository.findAll();
    }

    @Override
    public List<SaleOrderDetail> getSaleOrderDetailsBySaleOrderID(int saleOrderID) {
        return saleOrderDetailRepository.getSaleOrderDetailsBySaleOrderID(saleOrderID);
    }

    @Override
    public List<SaleOrderDetail> getSaleOrderDetailsByBagID(int bagID) {
        return saleOrderDetailRepository.getSaleOrderDetailsByBagID(bagID);
    }

    @Override
    public SaleOrderDetail getSaleOrderDetailBySaleOrderIdAndBagId(int saleOrderID, int bagID) {
        return saleOrderDetailRepository.getSaleOrderDetailBySaleOrderIdAndBagId(saleOrderID, bagID);
    }

    @Override
    public void addOrUpdateSaleOrderDetail(SaleOrderDetail saleOrderDetail) {
        saleOrderDetailRepository.save(saleOrderDetail);
    }
}
