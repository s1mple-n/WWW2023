package n16.hb_n16.impl;

import n16.hb_n16.entity.BagImage;
import n16.hb_n16.repository.BagImageRepository;
import n16.hb_n16.services.BagImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BagImageServiceImpl implements BagImageService {
    @Autowired
    private BagImageRepository bagImageRepository;
    @Override
    public List<BagImage> getAllBagImages() {
        return bagImageRepository.findAll();
    }

    @Override
    public List<BagImage> getBagImagesByBagID(int bagID) {
        return bagImageRepository.getBagImagesByBagId(bagID);
    }

    @Override
    public BagImage getBagImageByID(int bagImageID) {
        Optional<BagImage> rs = bagImageRepository.findById(bagImageID);
        BagImage bagImage = null;
        if(rs.isPresent()){
            bagImage=rs.get();
        } else {
            throw new RuntimeException("Did not find bag image id -" + bagImageID);
        }
        return bagImage;
    }

    @Override
    public void addOrUpdateBagImage(BagImage bagImage) {
        bagImageRepository.save(bagImage);
    }
}
