package com.example.salonofcars.dtos;

import com.example.salonofcars.models.Authentication;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String surname;
    private Authentication authentication;
}