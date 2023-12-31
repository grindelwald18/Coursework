package com.example.salonofcars.services;

import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.repositories.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationRepository authenticationRepository;

    public List<Authentication> listAuthentication(){
        return authenticationRepository.findAll();
    }
    public void addAuthentication(Authentication authentication){
        authentication.setPassword(authentication.getPassword());
        authenticationRepository.save(authentication);
    }
    public String loginAuthentication(Authentication authentication){
        if(authentication.getLogin() == null || authenticationRepository.findByLogin(authentication.getLogin()) == null){
            return "Неверный логин";
        }
        if(authentication.getPassword() == null || authenticationRepository.findByPassword(authentication.getPassword()) == null){
            return "Неверный логин";
        }

        return "Вход";
    }
    public void deleteAuthentication(Integer id){
        authenticationRepository.deleteById(id);
    }
    public void updateAuthentication(Integer id, Authentication upAuth){
        upAuth.setId(id);
        authenticationRepository.save(upAuth);
    }
    public Authentication getAuthenticationById(Integer id){
        return authenticationRepository.findById(id).orElseThrow();
    }
    public Authentication getAuthenticationByLogin(String login){
        return authenticationRepository.findByLogin(login);
    }

}
