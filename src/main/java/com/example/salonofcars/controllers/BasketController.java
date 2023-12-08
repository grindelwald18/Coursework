package com.example.salonofcars.controllers;

import com.example.salonofcars.dtos.BasketDTO;
import com.example.salonofcars.models.Basket;
import com.example.salonofcars.services.BasketService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    @GetMapping
    public List<Basket> getAllBasket(){
        return basketService.listBasket();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addBasket(@RequestBody BasketDTO basketDTO){
        String str = basketService.addCar(basketDTO);
        return ResponseEntity.ok(str);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBasket(@PathVariable Integer id){
        String str = basketService.deleteBasket(id);
        return ResponseEntity.ok(str);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Basket basket){
        String str = basketService.updateBasket(id, basket);
        return ResponseEntity.ok(str);
    }
    @GetMapping("/{id}")
    public Basket getBasketById(@PathVariable Integer id){
        return basketService.getBasketById(id);
    }
}
