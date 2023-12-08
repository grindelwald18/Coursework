package com.example.salonofcars.dtos;

import com.example.salonofcars.models.Authentication;
import lombok.Data;

@Data
public class AdminDTO {
    private int id;
    private Authentication authentication;
    private String surname;
}
