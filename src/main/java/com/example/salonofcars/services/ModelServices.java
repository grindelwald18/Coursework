package com.example.salonofcars.services;

import com.example.salonofcars.dtos.ModelDTO;
import com.example.salonofcars.models.Model;
import com.example.salonofcars.repositories.BrandRepository;
import com.example.salonofcars.repositories.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelServices {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;


    public List<Model> listModels(String modelName) {
        if (modelName != null) {
            return modelRepository.findByModel(modelName);
        }
        return modelRepository.findAll();
    }

    public void saveModel(ModelDTO modelDTO) {
        brandRepository.findById(modelDTO.getBrandId());
        Model model = mapModelDTOToModel(modelDTO);
        modelRepository.save(model);
    }

    public void deleteModel(int id) {
        modelRepository.deleteById(id);
    }

    public Model updateModel(int id, ModelDTO modelDTO) {
        brandRepository.findById(modelDTO.getBrandId());
        Model model = mapModelDTOToModel(modelDTO);
        model.setId(modelDTO.getId());
        modelRepository.save(model);
        return model;
    }

    public Model getModelById(int id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        return optionalModel.orElse(null);
    }

    public Model mapModelDTOToModel(ModelDTO modelDTO) {
        Model model = new Model();
        model.setModel(modelDTO.getModel());
        model.setBrand(brandRepository.findById(modelDTO.getBrandId()).orElseThrow());
        return model;
    }
}
