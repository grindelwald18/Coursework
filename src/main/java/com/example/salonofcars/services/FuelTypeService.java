package com.example.salonofcars.services;

import com.example.salonofcars.models.Brand;
import com.example.salonofcars.models.FuelType;
import com.example.salonofcars.repositories.FuelTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelTypeService {
    private final FuelTypeRepository fuelTypeRepository;
    public List<FuelType> getAllFuel(){
        return fuelTypeRepository.findAll();
    }
    public FuelType addFuel(FuelType fuelType){
        fuelTypeRepository.save(fuelType);
        return fuelType;
    }
    public void deleteFuel(int id) {
        fuelTypeRepository.deleteById(id);
    }
    public void updateFuel(int id, FuelType updateFuel) {
        updateFuel.setId(id);
        fuelTypeRepository.save(updateFuel);
    }
}
