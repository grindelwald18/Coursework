package com.example.salonofcars.services;

import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.repositories.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private AuthenticationRepository authenticationRepository;

    public List<Authentication> listAuthentication(){
        return authenticationRepository.findAll();
    }
    public void addAuthentication(Authentication authentication){
        authentication.setLogin(authentication.getLogin());
        authentication.setPassword(authentication.getPassword());
        authenticationRepository.save(authentication);
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
