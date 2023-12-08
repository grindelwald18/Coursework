package com.example.salonofcars.repositories;

import com.example.salonofcars.models.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
    Authentication findByLogin(String login);
    Authentication findByPassword(String password);
}
