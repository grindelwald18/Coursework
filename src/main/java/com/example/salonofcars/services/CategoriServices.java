package com.example.salonofcars.services;

import com.example.salonofcars.dtos.AdminDTO;
import com.example.salonofcars.models.Admin;
import com.example.salonofcars.models.Categori;
import com.example.salonofcars.repositories.CategoriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriServices {
    private final CategoriRepository categoriRepository;

    public List<Categori> listCategori(){
        return categoriRepository.findAll();
    }
    public String addCategori(Categori categori) {
        categoriRepository.save(categori);
        return "Категория добавлен";
    }
    public String delCategori(int id){
        categoriRepository.deleteById(id);
        return "Категория удалена";
    }
    public String updateCategori (int id, Categori newCategori){
        newCategori.setId(id);
        categoriRepository.save(newCategori);
        return "Категория обновленна";
    }
}
