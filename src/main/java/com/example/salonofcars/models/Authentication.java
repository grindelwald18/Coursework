package com.example.salonofcars.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "authentications")
@AllArgsConstructor
@RequiredArgsConstructor
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

//    @JsonIgnore
//    @OneToOne(mappedBy = "authentication", cascade = CascadeType.ALL)
//    private User user;

//    public Authentication(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
}
