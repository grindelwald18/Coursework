package com.example.salonofcars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "experience")
    private int experience;

    @OneToOne
    @JoinColumn(name = "authentication")
    private Authentication authentication;

    @ManyToOne
    @JoinColumn(name = "categori_id")
    private Categori categori;

    @JsonIgnore
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
