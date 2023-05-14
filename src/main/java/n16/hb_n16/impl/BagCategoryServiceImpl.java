package n16.hb_n16.impl;

import n16.hb_n16.entity.BagCategory;
import n16.hb_n16.repository.BagCategoryRepository;
import n16.hb_n16.services.BagCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
@Service
public class BagCategoryServiceImpl implements BagCategoryService {
    @Autowired
    private BagServiceImpl bagServiceImpl;
    @Autowired
    private BagCategoryRepository bagCategoryRepository;


    @Override
    public List<BagCategory> getAllBagCategories() {
        return bagCategoryRepository.findAll();
    }

    @Override
    public BagCategory getBagCategoryByID(int bagCategoryID) {
        return bagCategoryRepository.findById(bagCategoryID).get();
    }

    @Override
    public void addUpdateBagCategory(BagCategory bagCategory) {
        bagCategoryRepository.save(bagCategory);
    }

    @Override
    public void addOrUpdateBagCategory(BagCategory bagCategory) {
        bagCategoryRepository.save(bagCategory);
    }

    @Override
    public List<BagCategory> getBagCategoriesByName(String name) {
        return bagCategoryRepository.getBagCategoriesByName(name);
    }

    @Override
    public List<BagCategory> getBagCategoriesLikeName(String name) {
        return bagCategoryRepository.getBagCategoriesLikeName("%" +name + "%" );
    }

    @Override
    public List<BagCategory> getBagCategoriesByImportDate(LocalDate importDate) {
        return bagCategoryRepository.getBagCategoriesByImportDate(importDate);
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByNameFromA2Z() {
        return bagCategoryRepository.getBagCategoriesOrderByNameFromA2Z();
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByNameFromZ2A() {
        return bagCategoryRepository.getBagCategoriesOrderByNameFromZ2A();
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByPriceAsc() {
        List<BagCategory> bagCategories = new ArrayList<>();
        LinkedHashSet<Integer> cateIdList = bagServiceImpl.getBagCategoryIdOrderByPriceAsc();
        cateIdList.forEach(cateId ->{
            bagCategories.add(getBagCategoryByID(cateId));
        });
        return bagCategories;
    }

    @Override
    public List<BagCategory> getBagCategoriesOrderByPriceDesc() {
        List<BagCategory> bagCategories = new ArrayList<>();
        LinkedHashSet<Integer> cateIdlist = bagServiceImpl.getBagCategoryIdOrderByPriceDesc();
        cateIdlist.forEach(cateId->{
            bagCategories.add(getBagCategoryByID(cateId));
        });
        return bagCategories;
    }

    @Override
    public List<BagCategory> getBagCategoriesByNewestDate() {
        return bagCategoryRepository.getBagCategoriesByNewestDate();
    }

    @Override
    public List<BagCategory> searchBagCategoryALikeByKeyword(String keyword) {
        return bagCategoryRepository.searchBagCategoryALikeByKeyword("%"+keyword+"%");
    }
}
