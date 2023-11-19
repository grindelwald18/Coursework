package com.example.salonofcars.dtos;

import lombok.Data;

@Data
public class CarDTO {
    private int id;
    private int productionYear;
    private float amount;
    private float mileage;
    private int engineVolumeId;
    private int modelId;
    private int fuelTypeId;
}
