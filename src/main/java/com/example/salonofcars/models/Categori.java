package com.example.salonofcars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
@AllArgsConstructor
@RequiredArgsConstructor
public class Categori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name = "category")
    private int category;

    @Column(name = "percent")
    private float percent;

    @JsonIgnore
    @OneToMany(mappedBy = "categori", cascade = CascadeType.ALL)
    private List<Seller> sellers;
}
