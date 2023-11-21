package com.example.salonofcars.controllers;

import com.example.salonofcars.dtos.UserDTO;
import com.example.salonofcars.models.User;
import com.example.salonofcars.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<User> getAllUser(){
        return userService.listUsers();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
        String str = userService.addUser(userDTO);
        return ResponseEntity.ok(str);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delUser(@PathVariable Integer id){
        String str = userService.deleteUser(id);
        return ResponseEntity.ok(str);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        String str = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(str);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

}
