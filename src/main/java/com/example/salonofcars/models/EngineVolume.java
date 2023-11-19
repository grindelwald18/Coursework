package com.example.salonofcars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="engine_volumes")
@AllArgsConstructor
@RequiredArgsConstructor
public class EngineVolume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "engineVolume")
    private String engineVolume;

    @JsonIgnore
    @OneToMany(mappedBy = "engineVolume")
    private List<Car> cars;
}
