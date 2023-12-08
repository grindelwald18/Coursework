package com.example.salonofcars.services;

import com.example.salonofcars.dtos.BasketDTO;
import com.example.salonofcars.models.Basket;
import com.example.salonofcars.models.Car;
import com.example.salonofcars.repositories.BasketRepository;
import com.example.salonofcars.repositories.BrandRepository;
import com.example.salonofcars.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final CarRepository carRepository;

    public List<Basket> listBasket(){
        return basketRepository.findAll();
    }
    public Basket getBasketById(int id){
        return basketRepository.findById(id).orElseThrow();
    }

    public String addBasket(Basket basket){
        basketRepository.save(basket);
        return "Корзина добавленна";
    }
    public String deleteBasket(int id){
        basketRepository.deleteById(id);
        return "Корзина удалена";
    }
    public String updateBasket(int id, Basket updateBasket){
        updateBasket.setId(id);
        basketRepository.save(updateBasket);
        return "корзина обновлена";
    }
    public String addCar(BasketDTO basketDTO) {
        int basketId = basketDTO.getBasketId();
        int carId = basketDTO.getCarId();
        Basket basket = basketRepository.findById(basketId).orElseThrow();
        Car car = carRepository.findById(carId).orElseThrow();
        basket.addCar(car);
        basketRepository.save(basket);
        return "Машина добавленна в корзину";
    }

}
