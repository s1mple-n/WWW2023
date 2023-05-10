package n16.hb_n16.impl;

import n16.hb_n16.entity.BagReview;
import n16.hb_n16.repository.BagReviewRepository;
import n16.hb_n16.services.BagReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BagReviewServiceImpl implements BagReviewService {
    @Autowired
    private BagReviewRepository bagReviewRepository;
    @Override
    public List<BagReview> getAllBagReview() {
        return bagReviewRepository.findAll();
    }

    @Override
    public List<BagReview> getBagReviewsByBagID(int bagID) {
        return bagReviewRepository.getBagReviewsByBagID(bagID);
    }

    @Override
    public BagReview getBagReviewByID(int bagReviewID) {
        Optional<BagReview> rs = bagReviewRepository.findById(bagReviewID);
        BagReview bagReview = null;
        if (rs.isPresent()){
            bagReview = rs.get();
        } else throw new RuntimeException("Did not find bag review id - " + bagReviewID);
        return bagReview;
    }

    @Override
    public void addOrUpdateBagReview(BagReview bagReview) {
        bagReviewRepository.save(bagReview);
    }
}
