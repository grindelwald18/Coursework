package com.example.salonofcars.services;

import com.example.salonofcars.models.Basket;
import com.example.salonofcars.repositories.BasketRepository;
import com.example.salonofcars.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;

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

}
