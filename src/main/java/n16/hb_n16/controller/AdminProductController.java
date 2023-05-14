package n16.hb_n16.controller;

import n16.hb_n16.entity.Bag;
import n16.hb_n16.entity.BagCategory;
import n16.hb_n16.entity.BagImage;
import n16.hb_n16.entity.Brand;
import n16.hb_n16.impl.BagCategoryServiceImpl;
import n16.hb_n16.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {
    @Autowired
    private UserService userService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private BagCategoryService bagCategoryService;
    @Autowired
    private BagService bagService;
    @Autowired
    private BagImageService bagImageService;
    @Autowired
    private BagCategoryServiceImpl bagCategoryServiceImpl;

    private void addBagCateAmount(Model model, List<BagCategory> bagCategories) {

        List<Integer> bagCateAmount = new ArrayList<>();

        bagCateAmount.add(bagCategories.size());
        bagCateAmount.add(bagService.sumQuantity());
        bagCateAmount.add(bagService.countBag());
        bagCateAmount.add(bagService.countBagNotInStock());

        model.addAttribute("bagCateTotalCate", bagCateAmount.get(0));
        model.addAttribute("bagCateTotal", bagCateAmount.get(1));
        model.addAttribute("bagCateInStock", bagCateAmount.get(2));
        model.addAttribute("bagCateOutOfStock", bagCateAmount.get(3));
    }

    @GetMapping("/all")
    public String showProductsManagersPage(Model model){

        UserSession.getLoggedUserInfo(userService, model);
        List<BagCategory> bagCategorieList = bagCategoryService.getAllBagCategories();
        model.addAttribute("listProducts", bagCategorieList);
        model.addAttribute("pageTitle", "G16 - Quản lí sản phẩm");
        addBagCateAmount(model, bagCategoryServiceImpl.getAllBagCategories());
        return "/view_admin/products_manager";
    }
    @PostMapping("/save")
    public String addProduct(Model model,
                             @RequestParam("categoryName") String categoryName,
                             @RequestParam("brandName") String brandName,
                             @RequestParam("size") String size,
                             @RequestParam("weight") String weight,
                             @RequestParam("coverPhoto") MultipartFile coverPhoto,
                             @RequestParam("shortDescription") String shortDescription,
                             @RequestParam("longDescription") String longDescription,
                             @RequestParam(required = false, name = "color") String color,
                             @RequestParam(required = false, name = "quantity") String quantity,
                             @RequestParam(required = false, name = "price") String price,
                             @RequestParam(required = false, name = "listImage") ArrayList<MultipartFile> listImage
    ) throws IOException{
        Brand brand = new Brand(brandName);
        brandService.addOrUpdateBrand(brand);
        String imageDataString = Base64.getEncoder().encodeToString(coverPhoto.getBytes());
        BagCategory bagCategory = new BagCategory(brand, categoryName, size, Double.parseDouble(weight),
                imageDataString, shortDescription, longDescription, LocalDate.now());
        bagCategoryService.addOrUpdateBagCategory(bagCategory);
        Bag bag = new Bag(bagCategory, color, new BigDecimal(Double.parseDouble(price)), Integer.parseInt(quantity));
        bagService.addOrUpdateBag(bag);
        for (MultipartFile m : listImage) {
            String imageString = Base64.getEncoder().encodeToString(m.getBytes());
            BagImage bagImage = new BagImage(bag, imageString);
            bagImageService.addOrUpdateBagImage(bagImage);
        }

        UserSession.getLoggedUserInfo(userService, model);
        model.addAttribute("pageTitle", "G16 - Quản lí sản phẩm");
        List<BagCategory> bagCategorieList = bagCategoryService.getAllBagCategories();
        model.addAttribute("listProducts", bagCategorieList);

        List<BagCategory> bagCategories = bagCategoryServiceImpl.getAllBagCategories();

        model.addAttribute("bagCates", bagCategories);

        return "/view_admin/products_manager";
    }

}
