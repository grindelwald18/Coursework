package com.example.salonofcars.repositories;

import com.example.salonofcars.models.Admin;
import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByAuthentication(Authentication authentication);
}