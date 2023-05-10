package n16.hb_n16.services;

import n16.hb_n16.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrand();
    Brand getBrandByBrandId(int brandID);
    void addOrUpdateBrand(Brand brand);
}
