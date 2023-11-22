package com.example.salonofcars.services;

import com.example.salonofcars.dtos.UserDTO;
import com.example.salonofcars.models.Authentication;
import com.example.salonofcars.models.Basket;
import com.example.salonofcars.models.User;
import com.example.salonofcars.repositories.AuthenticationRepository;
import com.example.salonofcars.repositories.BasketRepository;
import com.example.salonofcars.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationRepository authenticationRepository;
    private final BasketRepository basketRepository;
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public String addUser(UserDTO userDTO) {

        if (authenticationRepository.findByLogin(userDTO.getAuthentication().getLogin()) != null)
            return "Пользователь с таким логином уже существует";

        authenticationRepository.save(userDTO.getAuthentication());
        User user = mapUserDTOToUser(userDTO);
        Basket basket = new Basket();
        basketRepository.save(basket);
        user.setBasket(basket);
        userRepository.save(user);
        return "Пользователь добавлен";
    }

    public String deleteUser(int id) {
        basketRepository.deleteById(id);
        userRepository.deleteById(id);
        return "Успешно удален";
    }

    public String updateUser(int id, UserDTO userDTO) {

        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseGet(() -> null);

        if (user == null) {
            return "Пользователя с таким id не существует";
        }

        Authentication authentication = user.getAuthentication();

        String login = userDTO.getAuthentication().getLogin();
        String password = userDTO.getAuthentication().getPassword();

        if (!authentication.getLogin().equals(login)) {
            if (authenticationRepository.findByLogin(login) != null)
                return "Пользователь с таким логином уже существует";
            authentication.setLogin(login);
        }
        if (!authentication.getPassword().equals(password))
            authentication.setPassword(password);

        authenticationRepository.save(authentication);
        user.setAuthentication(authentication);

        user.setSurname(userDTO.getSurname());
        userRepository.save(user);
        return "Пользователь обновлен";
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User mapUserDTOToUser(UserDTO userDTO) {

        User user = new User();
        user.setAuthentication(userDTO.getAuthentication());
        user.setSurname(userDTO.getSurname());
//        userRepository.save(user);

        return user;

    }

}
