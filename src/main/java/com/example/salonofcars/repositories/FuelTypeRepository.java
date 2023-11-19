package com.example.salonofcars.repositories;

import com.example.salonofcars.models.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelTypeRepository extends JpaRepository<FuelType,Integer> {
    List<FuelType> findByFuelType(String fuelType);
}
