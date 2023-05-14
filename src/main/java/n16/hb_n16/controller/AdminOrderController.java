package n16.hb_n16.controller;

import n16.hb_n16.entity.SaleOrder;
import n16.hb_n16.services.SaleOrderDetailService;
import n16.hb_n16.services.SaleOrderService;
import n16.hb_n16.services.UserService;
import n16.hb_n16.ultility.MyUltility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;
    @Autowired
    private SaleOrderService saleOrderService;

    private void addOderStatus(Model model){
        List<SaleOrder> saleOrders = saleOrderService.getAllSaleOrder();
        List<Integer> orderStatus = MyUltility.getOrderStatus(saleOrders);

        model.addAttribute("orderStatusTotal",saleOrders.size());
        model.addAttribute("orderStatusProcess",orderStatus.get(0));
        model.addAttribute("orderStatusDelivery",orderStatus.get(1));
        model.addAttribute("orderStatusCancel",orderStatus.get(2));
        model.addAttribute("orderStatusShipped",orderStatus.get(3));
    }
    @GetMapping("/all")
    public String showAllSaleOrders(Model model){
        UserSession.getLoggedUserInfo(userService,model);
        List<SaleOrder> saleOrders = saleOrderService.getAllSaleOrder();
        model.addAttribute("orderList",saleOrders);
        model.addAttribute("orderViewOptionTitle","Tất cả đơn hàng"+" ("+saleOrders.size()+")");
        model.addAttribute("pageTitle","Tất cả đơn hàng");
        addOderStatus(model);
        return "/view_admin/orders_manager";
    }
}
