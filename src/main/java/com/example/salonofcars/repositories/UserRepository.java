package com.example.salonofcars.repositories;

import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByAuthentication(Authentication authentication);
}
