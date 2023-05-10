package n16.hb_n16.impl;

import n16.hb_n16.entity.Brand;
import n16.hb_n16.repository.BrandRepository;
import n16.hb_n16.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandByBrandId(int brandID) {
        Optional<Brand> result = brandRepository.findById(brandID);
        Brand brand = null;
        if (result.isPresent()) {
            brand = result.get();
        } else {
            throw new RuntimeException("Can not find brand id - " + brandID);
        }
        return brand;
    }

    @Override
    public void addOrUpdateBrand(Brand brand) {
        brandRepository.save(brand);
    }
}
