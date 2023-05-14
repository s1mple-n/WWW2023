package n16.hb_n16.rest;


import n16.hb_n16.entity.SaleOrder;
import n16.hb_n16.services.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleOrderRestController {

	@Autowired
	private SaleOrderService saleOrderService;

	@GetMapping("/saleOrders/search")
	public List<String> getSaleOrdersToday(@RequestParam String keyword) {
		List<SaleOrder> saleOrders = saleOrderService.getSaleOrderALikeByKeyWord(keyword);
		List<String> res  = new ArrayList<>();
		
		saleOrders.forEach(saleOrder -> {
			res.add(String.format("{\"orderID\":%d, \"phone\":\"%s\", \"orderDate\":\"%s\",\"status\": \"%s\" }",
					saleOrder.getSaleOrderId(), 
					saleOrder.getPhone(), 
					saleOrder.getOrderDate().toString(),
					convertOrderStatus(saleOrder.getStatus())));
		});
	    
		return res;  
	}
	
	private String convertOrderStatus(int status) {
		if(status == 1)
			return "Đang chuản bị";
		
		if(status == 2)
			return "Đang giao";
		
		if(status == 1)
			return "Đã huỷ";
		
		return "Đã giao";
	}
}
