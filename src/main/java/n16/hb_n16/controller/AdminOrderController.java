package n16.hb_n16.controller;

import n16.hb_n16.entity.SaleOrder;
import n16.hb_n16.entity.SaleOrderDetail;
import n16.hb_n16.entity.User;
import n16.hb_n16.services.SaleOrderDetailService;
import n16.hb_n16.services.SaleOrderService;
import n16.hb_n16.services.UserService;
import n16.hb_n16.ultility.MyUltility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    private void addOrderStatus(Model model){
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
        addOrderStatus(model);
        return "/view_admin/orders_manager";
    }
    @GetMapping("/processingOrders")
    public String showProcessingSaleOrders(Model model){
        UserSession.getLoggedUserInfo(userService,model);
        short status = 1;
        List<SaleOrder> saleOrderList = saleOrderService.getSaleOrderByStatus(status);
        System.out.println(saleOrderList);
        model.addAttribute("orderList",saleOrderList);
        model.addAttribute("orderViewOptionTitle", "Đơn hàng mới" + " (" + saleOrderList.size() + ")");
        model.addAttribute("pageTitle", "Đơn hàng đang xử lí");
        addOrderStatus(model);

        return "/view_admin/orders_manager";
    }
    @GetMapping("/shippingOrders")
    public String showShippingOrdersPage(Model model){
        UserSession.getLoggedUserInfo(userService, model);

        short status = 2;
        List<SaleOrder> saleOrderList = saleOrderService.getSaleOrderByStatus(status);
        model.addAttribute("orderList", saleOrderList);

        model.addAttribute("orderViewOptionTitle", "Đơn hàng đang giao" + " (" + saleOrderList.size() + ")");
        model.addAttribute("pageTitle", "Đơn hàng đang vận chuyển");
        addOrderStatus(model);

        return "/view_admin/orders_manager";
    }
    @GetMapping("/shippedOrders")
    public String showShippedOrdersPage(Model model){
        UserSession.getLoggedUserInfo(userService, model);

        short status = 4;
        List<SaleOrder> saleOrderList = saleOrderService.getSaleOrderByStatus(status);
        model.addAttribute("orderList", saleOrderList);


        model.addAttribute("orderViewOptionTitle", "Đơn hàng đã giao" + " (" + saleOrderList.size() + ")");
        model.addAttribute("pageTitle", "Đơn hàng đã giao xong");
        addOrderStatus(model);

        return "/view_admin/orders_manager";
    }
    @GetMapping("/cancelledOrders")
    public String showCancelledOrdersPage(Model model){
        UserSession.getLoggedUserInfo(userService, model);

        short status = 3;
        List<SaleOrder> saleOrderList = saleOrderService.getSaleOrderByStatus(status);
        model.addAttribute("orderList", saleOrderList);

        model.addAttribute("orderViewOptionTitle", "Đơn hàng đã huỷ" + " (" + saleOrderList.size() + ")");
        model.addAttribute("pageTitle", "Đơn hàng đã hủy");
        addOrderStatus(model);

        return "/view_admin/orders_manager";
    }
    @GetMapping("/cancelOrders/{saleOrderId}")
    public String cancelOrders(Model model, @PathVariable("saleOrderId") int saleOrderId){
        UserSession.getLoggedUserInfo(userService, model);

        SaleOrder saleOrder = saleOrderService.getSaleOrderBySaleOrderID(saleOrderId);
        short cancel = 3;
        saleOrder.setStatus(cancel);
        saleOrderService.addOrUpdateSaleOrder(saleOrder);

        List<SaleOrder> saleOrderList = saleOrderService.getAllSaleOrder();
        model.addAttribute("orderList", saleOrderList);

        model.addAttribute("pageTitle", "Quản lý đơn hàng");
        addOrderStatus(model);

        return "redirect:/admin/all";
    }
    @GetMapping("/confirmShippedOrders/{saleOrderId}")
    public String confirmShippedOrders(Model model, @PathVariable("saleOrderId") int saleOrderId){
        UserSession.getLoggedUserInfo(userService, model);

        SaleOrder saleOrder = saleOrderService.getSaleOrderBySaleOrderID(saleOrderId);
        saleOrder.setStatus((short) 4);
        saleOrderService.addOrUpdateSaleOrder(saleOrder);

        List<SaleOrder> saleOrderList = saleOrderService.getAllSaleOrder();
        model.addAttribute("orderList", saleOrderList);

        model.addAttribute("pageTitle", "Quản lý đơn hàng");
        addOrderStatus(model);

        return "redirect:/admin/all";
    }
    @GetMapping("/orders/order/{orderId}")
    public String showFullInfoOfOrder(Model model, @PathVariable(name = "orderId", required = false) int saleOrderId){
        SaleOrder saleOrder = saleOrderService.getSaleOrderBySaleOrderID(saleOrderId);
        model.addAttribute("order", saleOrder);

        UserSession.getLoggedUserInfo(userService, model);
        User currentUser = UserSession.getCurrentUser(userService);
        model.addAttribute("user", currentUser);
        List<SaleOrderDetail> listOrderDetails = saleOrderDetailService.getAllSaleOrderDetailsBySaleOrderID(saleOrderId);
        model.addAttribute("listOrderDetails", listOrderDetails);
        return "/view_admin/sale-order-view";
    }
}
