package com.example.salonofcars.repositories;

import com.example.salonofcars.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    List<Brand> findByBrand(String brand);
}
