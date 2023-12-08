package com.example.salonofcars.controllers;

import com.example.salonofcars.models.Categori;
import com.example.salonofcars.services.CategoriServices;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categori")
@RequiredArgsConstructor
public class CategoriController {
    private final CategoriServices categoriServices;
    @GetMapping
    public List<Categori> getAllCategori(){
        return categoriServices.listCategori();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addCategori(@RequestBody Categori categori){
        String str = categoriServices.addCategori(categori);
        return ResponseEntity.ok(str);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delCategori(@PathVariable Integer id){
        String str = categoriServices.delCategori(id);
        return ResponseEntity.ok(str);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategori(@PathVariable Integer id, @RequestBody Categori newCategori){
        String str = categoriServices.updateCategori(id, newCategori);
        return ResponseEntity.ok(str);
    }
}
