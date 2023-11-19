package com.example.salonofcars.controllers;

import com.example.salonofcars.models.Brand;
import com.example.salonofcars.repositories.BrandRepository;
import com.example.salonofcars.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;
    @GetMapping
    public ResponseEntity<List<Brand>> getBrands(){
        return ResponseEntity.ok().body(brandService.getAllBrands());
    }
    @PostMapping("/add")
    public ResponseEntity<Brand> addBrand(@RequestBody Brand brand){
        brandService.addBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delBrand(@PathVariable Integer id){
        brandService.deleteBrand(id);
        return ResponseEntity.ok("Данные удалены");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBrand(@PathVariable Integer id, @RequestBody Brand updateBrand) {
        brandService.updateBrand(id, updateBrand);
        return ResponseEntity.ok("Данные обновлены");
    }

}
