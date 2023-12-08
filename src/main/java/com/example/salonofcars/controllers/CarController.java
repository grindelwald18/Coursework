package com.example.salonofcars.controllers;

import com.example.salonofcars.JsonInfo;
import com.example.salonofcars.dtos.CarDTO;
import com.example.salonofcars.models.Car;
import com.example.salonofcars.services.CarService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @GetMapping
    public List<Car> getAllCar(){
        return carService.listCars();
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addCar(@RequestBody CarDTO carDTO){
        carService.addCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id){
        carService.deleteCar(id);
        return ResponseEntity.ok("Машина удалена");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCar(@PathVariable Integer id,@RequestBody CarDTO carDTO){
        carService.updateCar(id, carDTO);
        return ResponseEntity.ok("Данные обновлены");
    }
    @GetMapping("/{id}")
    public Car getCar(@PathVariable Integer id){
        return carService.getCar(id);
    }
    @PostMapping("/filtr")
    public List<Car> getFiltrCar(@RequestBody JsonInfo jsonInfo){
        return carService.filtrOfCar(jsonInfo);
    }
}
