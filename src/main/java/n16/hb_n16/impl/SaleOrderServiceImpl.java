package n16.hb_n16.impl;

import n16.hb_n16.entity.SaleOrder;
import n16.hb_n16.repository.SaleOrderRepository;
import n16.hb_n16.services.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    public SaleOrderServiceImpl(SaleOrderRepository saleOrderRepository) {
        this.saleOrderRepository = saleOrderRepository;
    }

    @Override
    public List<SaleOrder> getAllSaleOrder() {
        return saleOrderRepository.findAll();
    }

    @Override
    public List<SaleOrder> getSaleOrdersByCustomerID(int customerID) {
        return saleOrderRepository.getSaleOrdersByCustomerID(customerID);
    }

    @Override
    public SaleOrder getSaleOrderBySaleOrderID(int saleOrderID) {
        return saleOrderRepository.getSaleOrderBySaleOrderID(saleOrderID);
    }

    @Override
    public void addOrUpdateSaleOrder(SaleOrder saleOrder) {
        saleOrderRepository.save(saleOrder);
    }

    @Override
    public List<SaleOrder> getSaleOrderToday(int day, int month, int year) {
        return saleOrderRepository.getSaleOrderToday(day, month, year);
    }

    @Override
    public List<SaleOrder> getSaleOrderThisMonth(int month, int year) {
        return saleOrderRepository.getSaleOrderThisMonth(month, year);
    }

    @Override
    public List<SaleOrder> getSaleOrderThisWeek(String startOfWeek, String EndOfWeek) {
        return saleOrderRepository.getSaleOrderThisWeek(startOfWeek, EndOfWeek);
    }

    @Override
    public List<SaleOrder> getSaleOrderByStatus(short status) {
        return saleOrderRepository.getSaleOrderByStatus(status);
    }

    @Override
    public List<SaleOrder> getSaleOrderALikeByKeyWord(String keyword) {
        return saleOrderRepository.getSaleOrderALikeByKeyWord(keyword);
    }
}
