package com.example.salonofcars.services;

import com.example.salonofcars.dtos.AdminDTO;
import com.example.salonofcars.dtos.UserDTO;
import com.example.salonofcars.models.Admin;
import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.models.Basket;
import com.example.salonofcars.models.User;
import com.example.salonofcars.repositories.AdminRepository;
import com.example.salonofcars.repositories.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final AuthenticationRepository authenticationRepository;
    public List<Admin> listAdmin() {
        return adminRepository.findAll();
    }

    public String addAdmin(AdminDTO adminDTO) {

        if (authenticationRepository.findByLogin(adminDTO.getAuthentication().getLogin()) != null)
            return "Админ с таким логином уже существует";

        authenticationRepository.save(adminDTO.getAuthentication());
        Admin admin= mapAdminDTOToAdmin(adminDTO);
        adminRepository.save(admin);
        return "Админ добавлен";
    }

    public String deleteAdmin(int id) {
        adminRepository.deleteById(id);
        return "Успешно удален";
    }

    public String updateAdmin(int id, AdminDTO adminDTO) {

        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        Admin admin = optionalAdmin.orElseGet(() -> null);

        if (admin == null) {
            return "Админа с таким id не существует";
        }

        Authentication authentication = admin.getAuthentication();

        String login = adminDTO.getAuthentication().getLogin();
        String password = adminDTO.getAuthentication().getPassword();

        if (!authentication.getLogin().equals(login)) {
            if (authenticationRepository.findByLogin(login) != null)
                return "Админ с таким логином уже существует";
            authentication.setLogin(login);
        }
        if (!authentication.getPassword().equals(password))
            authentication.setPassword(password);

        authenticationRepository.save(authentication);
        admin.setAuthentication(authentication);

        admin.setSurname(adminDTO.getSurname());
        adminRepository.save(admin);
        return "Админ обновлен";
    }

    public Admin getAdminById(int id) {
        return adminRepository.findById(id).orElseThrow();
    }

    public Admin mapAdminDTOToAdmin(AdminDTO adminDTO) {

        Admin admin = new Admin();
        admin.setAuthentication(adminDTO.getAuthentication());
        admin.setSurname(adminDTO.getSurname());
        return admin;

    }
}
