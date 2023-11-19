package com.example.salonofcars.services;

import com.example.salonofcars.dtos.CarDTO;
import com.example.salonofcars.models.Car;
import com.example.salonofcars.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ModelRepository modelRepository;
    private final EngineVolumeRepository engineVolumeRepository;
    private final FuelTypeRepository fuelTypeRepository;

    public List<Car> listCars(){
        return carRepository.findAll();
    }
    public void addCar(CarDTO carDTO){
        modelRepository.findById(carDTO.getModelId()).orElseThrow(() -> new NoSuchElementException("Model not found"));
        engineVolumeRepository.findById(carDTO.getEngineVolumeId()).orElseThrow(() -> new NoSuchElementException("Engine volume not found"));
        fuelTypeRepository.findById(carDTO.getFuelTypeId()).orElseThrow(() -> new NoSuchElementException("Fuel type not found"));
        Car car = mapCarDTOToCar(carDTO);
        carRepository.save(car);
    }
    public void deleteCar(int id){
        carRepository.deleteById(id);
    }
    public void updateCar(int id, CarDTO carDTO){
        modelRepository.findById(carDTO.getModelId()).orElseThrow(() -> new NoSuchElementException("Model not found"));
        engineVolumeRepository.findById(carDTO.getEngineVolumeId()).orElseThrow(() -> new NoSuchElementException("Engine volume not found"));
        fuelTypeRepository.findById(carDTO.getFuelTypeId()).orElseThrow(() -> new NoSuchElementException("Fuel type not found"));
        Car car = mapCarDTOToCar(carDTO);
        car.setId(id);
        carRepository.save(car);
    }
    public Car getCar(int id){
        return carRepository.findById(id).orElseThrow();
    }

    public Car mapCarDTOToCar(CarDTO carDTO) {
        Car car = new Car();
        car.setModel(modelRepository.findById(carDTO.getModelId()).orElseThrow());
        car.setEngineVolume(engineVolumeRepository.findById(carDTO.getEngineVolumeId()).orElseThrow());
        car.setFuelType(fuelTypeRepository.findById(carDTO.getFuelTypeId()).orElseThrow());
        car.setProductionYear(carDTO.getProductionYear());
        car.setMileage(carDTO.getMileage());
        car.setAmount(carDTO.getAmount());
        return car;
    }

}