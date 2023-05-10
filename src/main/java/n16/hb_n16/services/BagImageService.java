package n16.hb_n16.services;

import n16.hb_n16.entity.BagImage;

import java.util.List;

public interface BagImageService {
    List<BagImage> getAllBagImages();
    List<BagImage> getBagImagesByBagID(int bagID);
    BagImage getBagImageByID(int bagImageID);
    void addOrUpdateBagImage(BagImage bagImage);
}
