package n16.hb_n16.rest;


import n16.hb_n16.entity.Bag;
import n16.hb_n16.entity.BagCategory;
import n16.hb_n16.services.BagCategoryService;
import n16.hb_n16.services.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BagRestController {
	@Autowired
	private BagService bagService;

	@Autowired
	private BagCategoryService bagCategoryService;

	@GetMapping("/bags")
	public List<Bag> getBags() {
		return bagService.getAllBags();
	}

	@GetMapping("/bags/{cate_name}")
	public List<BagCategory> getBagsByCateName(@PathVariable String cate_name) {
		return bagCategoryService.getBagCategoriesByName(cate_name);
	}

	@GetMapping("/bags/search/{name}")
	public List<BagCategory> getBagsLikeCateName(@PathVariable String name) {
		return bagCategoryService.getBagCategoriesLikeName(name);
	}

	@GetMapping("/bags/bagCategory={bagCategoryId}")
	public List<Bag> findBagsListByBagCategoryId(@PathVariable int bagCategoryId) {
		return bagService.getBagListOfBagCategory(bagCategoryId);
	}

	@GetMapping("/bags/search/keyword")
	public List<String> search(@RequestParam String keyword) {
		
		List<BagCategory>  bagCategories = bagCategoryService.searchBagCategoryALikeByKeyword(keyword);
		List<String> res  = new ArrayList<>();
	
		bagCategories.forEach(bagCate -> {
			res.add(String.format("{\"bagCateID\":%d, \"name\":\"%s\", \"brand\":\"%s\"}",
					bagCate.getBagCategoryId(), bagCate.getName(), bagCate.getBrand().getName()));
		});
	    
		return res; 
	}
}