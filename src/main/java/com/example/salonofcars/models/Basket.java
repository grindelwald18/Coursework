package com.example.salonofcars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "baskets")
@AllArgsConstructor
@RequiredArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<Car> cars;
}
