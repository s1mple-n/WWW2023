package n16.hb_n16.services;

import n16.hb_n16.entity.BagCategory;

import java.time.LocalDate;
import java.util.List;

public interface BagCategoryService {
    List<BagCategory>getAllBagCategories();
    BagCategory getBagCategoryByID(int bagCategory);
    void addUpdateBagCategory(BagCategory bagCategory);
    void addOrUpdateBagCategory(BagCategory bagCategory);
    List<BagCategory> getBagCategoriesByName(String name);
    List<BagCategory> getBagCategoriesLikeName(String name);
    List<BagCategory> getBagCategoriesByImportDate(LocalDate importDate);
    List<BagCategory> getBagCategoriesOrderByNameFromA2Z();
    List<BagCategory> getBagCategoriesOrderByNameFromZ2A();
    List<BagCategory> getBagCategoriesOrderByPriceAsc();
    List<BagCategory> getBagCategoriesOrderByPriceDesc();
    List<BagCategory> getBagCategoriesByNewestDate();
    List<BagCategory> searchBagCategoryALikeByKeyword(String keyword);
}
