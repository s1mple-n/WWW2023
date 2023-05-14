package n16.hb_n16.controller;

import n16.hb_n16.entity.CartDetail;
import n16.hb_n16.entity.CartHeader;
import n16.hb_n16.entity.User;
import n16.hb_n16.services.CartDetailService;
import n16.hb_n16.services.CartHeaderService;
import n16.hb_n16.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController {
    private UserService userService;
    private CartHeaderService cartHeaderService;
    private CartDetailService cartDetailService;

    public CartController(UserService userService, CartHeaderService cartHeaderService, CartDetailService cartDetailService) {
        this.userService = userService;
        this.cartHeaderService = cartHeaderService;
        this.cartDetailService = cartDetailService;
    }

    @GetMapping("/all")
    public String showCartPage(Model model) {
        UserSession.getLoggedUserInfo(userService, model);
        User user = UserSession.getCurrentUser(userService);
        CartHeader cartHeader = cartHeaderService.getCartHeaderByID(user.getCustomerId());
        List<CartDetail> cartDetailList = cartDetailService.getCartDetailByCartHeaderID(cartHeader.getCustomerId());
        model.addAttribute("cartDetailNum", cartDetailList.size());
        model.addAttribute("cartDetailList", cartDetailList);
        model.addAttribute("pageTitle", "Giỏ hàng của bạn");
        return "view_customer/cart";
    }

    @GetMapping("/clear")
    public String clearCart() {
        User currentUser = UserSession.getCurrentUser(userService);
        CartHeader cartHeader = cartHeaderService.getCartHeaderByID(currentUser.getCustomerId());
        cartDetailService.deleteCartDetailByCartHeaderId(cartHeader.getCustomerId());
        cartHeader.setTotalPrice(new BigDecimal(0));
        cartHeader.setTotalQuantity(0);
        cartHeaderService.addOrUpdateCartHeader(cartHeader);

        return "redirect:/cart/all";
    }
}
