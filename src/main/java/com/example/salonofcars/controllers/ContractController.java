package com.example.salonofcars.controllers;

import com.example.salonofcars.dtos.ContractDTO;
import com.example.salonofcars.models.Contract;
import com.example.salonofcars.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SplittableRandom;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;
    @GetMapping
    public List<Contract> getAllContract(){
        return contractService.listContract();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addContract(@RequestBody ContractDTO contractDTO){
        String str = contractService.addContract(contractDTO);
        return ResponseEntity.ok(str);
    }
    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Integer id){
        return contractService.getContractById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delContract(@PathVariable Integer id){
        String str = contractService.delContract(id);
        return ResponseEntity.ok(str);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateContract(@PathVariable Integer id, @RequestBody ContractDTO contractDTO){
        String str = contractService.updateContract(id, contractDTO);
        return ResponseEntity.ok(str);
    }
}
