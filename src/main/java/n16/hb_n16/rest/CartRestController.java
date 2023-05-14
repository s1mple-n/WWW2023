package n16.hb_n16.rest;


import n16.hb_n16.entity.Bag;
import n16.hb_n16.entity.CartDetail;
import n16.hb_n16.impl.BagServiceImpl;
import n16.hb_n16.impl.CartDetailServiceImpl;
import n16.hb_n16.impl.CartHeaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_cart")
public class CartRestController {

	@Autowired
	private CartDetailServiceImpl cartDetailServiceImpl;

	@Autowired
	private CartHeaderServiceImpl cartHeaderServiceImpl;

	@Autowired
	private BagServiceImpl bagServiceImpl;

	@PutMapping("/update")
	public String changeCartOrderQuantity(
			@RequestParam int bagID, @RequestParam int userID, @RequestParam int quantity
	) {

		Bag bag = bagServiceImpl.getBagByID(bagID);
		int quantityInStock = bag.getQuantity() - quantity;
//		Order quantity cant greater than quantity in stock
		if (quantityInStock < 0) return "failed";

		CartDetail cartDetail = cartDetailServiceImpl.getCartDetailByCartHeaderIdAndBagId(userID, bagID);
		cartDetail.setBagQty(quantity);

		cartDetailServiceImpl.addOrUpdateCartDetail(cartDetail);

		cartHeaderServiceImpl.updateCartTotalPriceAndQuantity(userID,
				cartDetailServiceImpl.getCartDetailByCartHeaderID(userID));


		return "success";
	}

	@DeleteMapping("/delete")
	public String deleteCartOrderItem(@RequestParam int bagID, @RequestParam int userID) {
		
		cartDetailServiceImpl.deleteCartDetailByCartHeaderIdAndBagId(userID, bagID);
		
		cartHeaderServiceImpl.updateCartTotalPriceAndQuantity(userID,
				cartDetailServiceImpl.getCartDetailByCartHeaderID(userID));
		
		return "success";
	}
}