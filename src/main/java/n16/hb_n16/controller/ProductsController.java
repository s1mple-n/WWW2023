package n16.hb_n16.controller;

import n16.hb_n16.entity.Bag;
import n16.hb_n16.entity.BagCategory;
import n16.hb_n16.entity.CartDetail;
import n16.hb_n16.entity.CartHeader;
import n16.hb_n16.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private UserService userService;
    private BagService bagService;
    private BagCategoryService bagCategoryService;
    private CartHeaderService cartHeaderService;
    private CartDetailService cartDetailService;

    public ProductsController(UserService userService, BagService bagService, BagCategoryService bagCategoryService, CartHeaderService cartHeaderService, CartDetailService cartDetailService) {
        this.userService = userService;
        this.bagService = bagService;
        this.bagCategoryService = bagCategoryService;
        this.cartHeaderService = cartHeaderService;
        this.cartDetailService = cartDetailService;
    }

    @GetMapping("/all")
    public String showAllProducts(Model model) {
        UserSession.getLoggedUserInfo(userService, model);
        List<BagCategory> bagCategoryList= bagCategoryService.getAllBagCategories();

        List<String> bagCategoryPriceList = bagService.listPrice(bagCategoryList);

        model.addAttribute("resultSize", bagCategoryList.size());
        model.addAttribute("pageTitle", "Tất cả sản phẩm");
        model.addAttribute("listProducts", bagCategoryList);
        model.addAttribute("listProductsPrice", bagCategoryPriceList);

        return "view_customer/all_products";
    }

    @GetMapping("/all/filter")
    public String showAllProducts(Model model, @RequestParam String sort) {
        UserSession.getLoggedUserInfo(userService, model);
        List<BagCategory> bagCategoryList = new ArrayList<>();
        if (sort.equals("1")) {
            bagCategoryList = bagCategoryService.getBagCategoriesOrderByNameFromA2Z();
        } else if (sort.equals("2")) {
            bagCategoryList = bagCategoryService.getBagCategoriesOrderByNameFromZ2A();
        } else if (sort.equals("3")) {
            bagCategoryList = bagCategoryService.getBagCategoriesOrderByPriceAsc();
        } else if (sort.equals("4")) {
            bagCategoryList = bagCategoryService.getBagCategoriesOrderByPriceDesc();
        }

        List<String>  bagCategoryPriceList = bagService.listPrice(bagCategoryList);

        model.addAttribute("resultSize", bagCategoryList.size());
        model.addAttribute("pageTitle", "Tất cả sản phẩm");
        model.addAttribute("listProducts", bagCategoryList);
        model.addAttribute("listProductsPrice", bagCategoryPriceList);

        return "view_customer/all_products";
    }

    @GetMapping("/newest")
    public String showNewestProducts(Model model) {
        UserSession.getLoggedUserInfo(userService, model);

        List<BagCategory> listBagCategory = bagCategoryService.getBagCategoriesByNewestDate();

        List<String> bagCategoryListPrice = bagService.listPrice(listBagCategory);

        model.addAttribute("resultSize", listBagCategory.size());
        model.addAttribute("pageTitle", "Tất cả sản phẩm");
        model.addAttribute("listProducts", listBagCategory);
        model.addAttribute("listProductsPrice", bagCategoryListPrice);
        return "view_customer/all_products";
    }

    @GetMapping("/product/{categoryId}")
    public String showProductDetail(@PathVariable("categoryId") int categoryId, Model model) {
        UserSession.getLoggedUserInfo(userService, model);

        BagCategory bagCategory = bagCategoryService.getBagCategoryByID(categoryId);

        model.addAttribute("bagCategory", bagCategory);
        model.addAttribute("pageTitle", bagCategory.getName());

        return "view_customer/product_detail";
    }

    @PostMapping("/product/add_to_cart")
    public String addToCart(@RequestParam int cusID, @RequestParam int orderQuantity, @RequestParam int bagID, @RequestParam int bagCateID) {
        CartHeader cartHeader = cartHeaderService.getCartHeaderByID(cusID);
        Bag bag = bagService.getBagByID(cusID);

        if (cartHeader != null) {
            CartDetail cartDetail = cartDetailService.getCartDetailByCartHeaderIdAndBagId(cusID, bagID);

            if (cartDetail != null) {
                cartDetail.setBagQty(cartDetail.getBagQty() + orderQuantity);
            } else {
                cartDetail = new CartDetail(cartHeader, bag, orderQuantity);
            }

            cartDetailService.addOrUpdateCartDetail(cartDetail);

            cartHeader.setTotalPrice(cartHeader.getTotalPrice().add(bag.getPrice().multiply(new BigDecimal(orderQuantity))));

            cartHeader.setTotalQuantity(cartHeader.getTotalQuantity() + orderQuantity);

            cartHeaderService.addOrUpdateCartHeader(cartHeader);
        }
        return "redirect:/products/product/" + bagCateID + "?added";
    }
}
