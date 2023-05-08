package n16.hb_n16.services;

import n16.hb_n16.entity.Bag;
import n16.hb_n16.entity.BagCategory;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;

public interface BagService {
    List<Bag> getAllBags();
    Bag getBagByID(int bagID);
    void addOrUpdateBag(Bag bag);
    List<Bag> getBagListOfBagCategory(int bagCategoryId);
    BigDecimal getBagPriceByCateID(int cateID);
    List<String> listPrice(List<BagCategory> listBagCategory);
    LinkedHashSet<Integer> getBagCategoryIdOrderByPriceAsc();
    LinkedHashSet<Integer> getBagCategoryIdOrderByPriceDesc();
    int countBag();
    int countBagNotInStock();
    int sumQuantity();
}

