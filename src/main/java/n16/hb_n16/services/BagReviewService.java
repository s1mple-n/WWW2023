package n16.hb_n16.services;

import n16.hb_n16.entity.BagReview;

import java.util.List;

public interface BagReviewService {
    List<BagReview> getAllBagReview();
    List<BagReview> getBagReviewsByBagID(int bagID);
    BagReview getBagReviewByID(int bagReviewID);
    void addOrUpdateBagReview(BagReview bagReview);
}
