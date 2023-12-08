package com.example.salonofcars.services;

import com.example.salonofcars.dtos.AdminDTO;
import com.example.salonofcars.dtos.SellerDTO;
import com.example.salonofcars.models.Admin;
import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.models.Seller;
import com.example.salonofcars.repositories.AuthenticationRepository;
import com.example.salonofcars.repositories.CategoriRepository;
import com.example.salonofcars.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;
    private final AuthenticationRepository authenticationRepository;
    private final CategoriRepository categoriRepository;

    public List<Seller> listSeller(){
        return sellerRepository.findAll();
    }
    public String addSeller(SellerDTO sellerDTO) {
    if (authenticationRepository.findByLogin(sellerDTO.getAuthentication().getLogin()) != null)
            return "Продовец с таким логином уже существует";

        authenticationRepository.save(sellerDTO.getAuthentication());
        Seller seller = mapSellerDTOToSeller(sellerDTO);
        sellerRepository.save(seller);
        return "Продавец добавлен";
    }
    public String delSeller(int id){
        sellerRepository.deleteById(id);
        return "Продавец удален";
    }
    public String updateSeller(int id, SellerDTO sellerDTO){
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        Seller seller = optionalSeller.orElseGet(() -> null);

        if (seller == null) {
            return "Продавец с таким id не существует";
        }

        Authentication authentication = seller.getAuthentication();

        String login = sellerDTO.getAuthentication().getLogin();
        String password = sellerDTO.getAuthentication().getPassword();

        if (!authentication.getLogin().equals(login)) {
            if (authenticationRepository.findByLogin(login) != null)
                return "Продавец с таким логином уже существует";
            authentication.setLogin(login);
        }
        if (!authentication.getPassword().equals(password))
            authentication.setPassword(password);

        authenticationRepository.save(authentication);
        seller.setAuthentication(authentication);
        seller.setSurname(sellerDTO.getSurname());
        seller.setExperience(sellerDTO.getExperience());
        seller.setCategori(categoriRepository.findById(sellerDTO.getCategoriId()).orElseThrow());
        sellerRepository.save(seller);
        return "Продавец обновлен";
    }
    public Seller mapSellerDTOToSeller(SellerDTO sellerDTO){
        Seller seller = new Seller();
        seller.setAuthentication(sellerDTO.getAuthentication());
        seller.setSurname(sellerDTO.getSurname());
        seller.setExperience(sellerDTO.getExperience());
        seller.setCategori(categoriRepository.findById(sellerDTO.getCategoriId()).orElseThrow());
        return seller;
    }
}
