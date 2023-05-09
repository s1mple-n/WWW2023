package n16.hb_n16.impl;

import n16.hb_n16.entity.BagCategory;
import n16.hb_n16.services.BagCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class BagCategoryServiceImpl implements BagCategoryService {


    @Override
    public List<BagCategory> getAllBagCategories() {
        return null;
    }

    @Override
    public BagCategory getBagCategoryByID(int bagCategory) {
        return null;
    }

    @Override
    public void addUpdateBagCategory(BagCategory bagCategory) {

    }

    @Override
    public List<BagCategory> getBagCategoriesByName(String name) {
        return null;
    }

    @Override
    public List<BagCategory> getBagCategoriesLikeName(String name) {
        return null;
    }

    @Override
    public List<BagCategory> getBagCategoriesByImportDate(LocalDate importDate) {
        return null;
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByNameFromA2Z() {
        return null;
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByNameFromZ2A() {
        return null;
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByPriceAsc() {
        return null;
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByPriceDesc() {
        return null;
    }

    @Override
    public List<BagCategory> getBagCategoriesByNewestDate() {
        return null;
    }

    @Override
    public List<BagCategory> searchBagCategoryALikeByKeyword(String keyword) {
        return null;
    }
}
