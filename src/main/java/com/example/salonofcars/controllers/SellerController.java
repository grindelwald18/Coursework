package com.example.salonofcars.controllers;

import com.example.salonofcars.dtos.SellerDTO;
import com.example.salonofcars.models.Seller;
import com.example.salonofcars.repositories.SellerRepository;
import com.example.salonofcars.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private  final SellerService sellerService;
    @GetMapping
    public List<Seller> getAllSeller(){
        return sellerService.listSeller();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addSeller(@RequestBody SellerDTO sellerDTO){
        String str = sellerService.addSeller(sellerDTO);
        return ResponseEntity.ok(str);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delSeller(@PathVariable Integer id){
        String str = sellerService.delSeller(id);
        return ResponseEntity.ok(str);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSeller(@PathVariable Integer id, @RequestBody SellerDTO sellerDTO){
        String str = sellerService.updateSeller(id, sellerDTO);
        return ResponseEntity.ok(str);
    }
}
