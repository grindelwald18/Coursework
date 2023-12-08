package com.example.salonofcars.dtos;

import com.example.salonofcars.models.Authentication;
import lombok.Data;

@Data
public class SellerDTO {
    private int id;
    private Authentication authentication;
    private String surname;
    private int experience;
    private int categoriId;
}
