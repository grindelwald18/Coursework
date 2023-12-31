package com.example.salonofcars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "cars")
@AllArgsConstructor
@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name = "amount")
    private float amount;

    @Column(name = "mileage")
    private float mileage;

    @ManyToOne
    @JoinColumn(name = "engine_volume_id")
    private EngineVolume engineVolume;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Basket basket;

}
