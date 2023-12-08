package com.example.salonofcars.controllers;

import com.example.salonofcars.dtos.ModelDTO;
import com.example.salonofcars.models.Model;
import com.example.salonofcars.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelServices;

    @GetMapping
    public List<Model> getModels(@RequestParam (name="brand-id",required = false) Integer brandId){
        return modelServices.listModels(brandId);
    }
    @PostMapping("/add")
    public ResponseEntity<ModelDTO> addModel(@RequestBody ModelDTO modelDTO){
        modelServices.saveModel(modelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delModel(@PathVariable Integer id){
        modelServices.deleteModel(id);
        return ResponseEntity.ok("Данные удалены");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable Integer id, @RequestBody ModelDTO modelDTO){
        Model model = modelServices.updateModel(id, modelDTO);
        return ResponseEntity.ok().body(model);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Model> getModel(@PathVariable Integer id){
        Model model = modelServices.getModelById(id);
        return ResponseEntity.ok().body(model);
    }

}
