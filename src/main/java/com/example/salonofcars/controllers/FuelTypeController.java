package com.example.salonofcars.controllers;

import com.example.salonofcars.models.Brand;
import com.example.salonofcars.models.FuelType;
import com.example.salonofcars.services.BrandService;
import com.example.salonofcars.services.FuelTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuel")
@RequiredArgsConstructor
public class FuelTypeController {
    private final FuelTypeService fuelTypeService;

    @GetMapping
    public ResponseEntity<List<FuelType>> getFuelType() {
        return ResponseEntity.ok().body(fuelTypeService.getAllFuel());
    }

    @PostMapping("/add")
    public ResponseEntity<FuelType> addFuelType(@RequestBody FuelType fuelType) {
        fuelTypeService.addFuel(fuelType);
        return ResponseEntity.status(HttpStatus.CREATED).body(fuelType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delFuel(@PathVariable Integer id) {
        fuelTypeService.deleteFuel(id);
        return ResponseEntity.ok("Данные удалены");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFuel(@PathVariable Integer id, @RequestBody FuelType updateFuel) {
        fuelTypeService.updateFuel(id, updateFuel);
        return ResponseEntity.ok("Данные обновлены");
    }

}
