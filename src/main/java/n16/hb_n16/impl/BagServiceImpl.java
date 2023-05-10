package n16.hb_n16.impl;

import n16.hb_n16.entity.Bag;
import n16.hb_n16.entity.BagCategory;
import n16.hb_n16.repository.BagRepository;
import n16.hb_n16.services.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class BagServiceImpl implements BagService {


    @Autowired
    private BagRepository bagRepo;

    @Override
    public List<Bag> getAllBags() {
        return bagRepo.findAll();
    }

    @Override
    public Bag getBagByID(int bagID) {
        return bagRepo.findById(bagID).get();
    }

    @Override
    public void addOrUpdateBag(Bag bag) {
        bagRepo.save(bag);
    }

    @Override
    public List<Bag> getBagListOfBagCategory(int bagCategoryId) {
        return bagRepo.findBagsListByBagCategoryId(bagCategoryId);
    }

    @Override
    public BigDecimal getBagPriceByCateID(int cateID) {
        return bagRepo.getBagPriceByCateID(cateID);
    }

    @Override
    public List<String> listPrice(List<BagCategory> listBagCategory) {
        List<String> listPrice = new ArrayList<>();

        listBagCategory.forEach(bagCate -> {
            listPrice.add(new DecimalFormat("#,###")
                    .format(getBagPriceByCateID(bagCate.getBagCategoryId())));
        });

        return listPrice;
    }

    @Override
    public LinkedHashSet<Integer> getBagCategoryIdOrderByPriceAsc() {
        return bagRepo.getBagCategoryIdOrderByPriceAsc();
    }

    @Override
    public LinkedHashSet<Integer> getBagCategoryIdOrderByPriceDesc() {
        return bagRepo.getBagCategoryIdOrderByPriceDesc();
    }

    @Override
    public int countBag() {
        return bagRepo.countBag();
    }

    @Override
    public int countBagNotInStock() {
        return bagRepo.sumQuantity();
    }

    @Override
    public int sumQuantity() {
        return bagRepo.countBagNotInStock();
    }
}
