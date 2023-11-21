package com.example.salonofcars.controllers;

import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @GetMapping
    public List<Authentication> getAllAuth(@RequestParam(name = "login", required = false) String login){
        if (login != null) {
            Authentication authentication = authenticationService.getAuthenticationByLogin(login);
            return (authentication == null) ? null : List.of(authentication);
        }
        return authenticationService.listAuthentication();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addAuth(@RequestBody Authentication authentication){
        authenticationService.addAuthentication(authentication);
        return ResponseEntity.ok("Успешно добалено");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delAuth(@PathVariable Integer id){
        authenticationService.deleteAuthentication(id);
        return ResponseEntity.ok("Успешно удалено");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuth(@PathVariable Integer id, @RequestBody Authentication authentication){
        authenticationService.updateAuthentication(id, authentication);
        return ResponseEntity.ok("Данные обновлены");
    }
    @GetMapping("/{id}")
    public Authentication getAuth(@PathVariable Integer id){
        return authenticationService.getAuthenticationById(id);
    }
}
