package com.example.salonofcars.services;

import com.example.salonofcars.models.Brand;
import com.example.salonofcars.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }
    public Brand addBrand(Brand brand){
        brandRepository.save(brand);
        return brand;
    }
    public void deleteBrand(int id) {
        brandRepository.deleteById(id);
    }
    public void updateBrand(int id, Brand updateBrand) {
        updateBrand.setId(id);
        brandRepository.save(updateBrand);
    }
}
