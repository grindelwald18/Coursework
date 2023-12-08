package com.example.salonofcars.dtos;

import com.example.salonofcars.models.Car;
import com.example.salonofcars.models.Seller;
import com.example.salonofcars.models.User;
import lombok.Data;

import java.util.Date;
import java.sql.Time;

@Data
public class ContractDTO {
    private int id;
    private int carId;
    private int userId;
    private int sellerId;
    private float totalAmount;
    private Date registrationDate;
}