package com.example.salonofcars.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "basket_id")
//    private int basketId;

    @Column(name = "surname")
    private String surname;

    @OneToOne
    @JoinColumn(name = "authentication")
    private Authentication authentication;

    @OneToOne
    @JoinColumn(name = "basket")
    private Basket basket;
}
