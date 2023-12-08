package com.example.salonofcars.controllers;

import com.example.salonofcars.dtos.AdminDTO;
import com.example.salonofcars.models.Admin;
import com.example.salonofcars.services.AdminService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping
    public List<Admin> getAllAdmin(){
        return adminService.listAdmin();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestBody AdminDTO adminDTO){
        String str = adminService.addAdmin(adminDTO);
        return ResponseEntity.ok(str);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delAdmin(@PathVariable Integer id){
        String str = adminService.deleteAdmin(id);
        return ResponseEntity.ok(str);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable Integer id, @RequestBody AdminDTO upAdminDTO){
        String str = adminService.updateAdmin(id, upAdminDTO);
        return ResponseEntity.ok(str);
    }
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Integer id){
        return  adminService.getAdminById(id);
    }
}