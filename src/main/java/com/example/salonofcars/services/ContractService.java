package com.example.salonofcars.services;

import com.example.salonofcars.dtos.ContractDTO;
import com.example.salonofcars.models.*;
import com.example.salonofcars.repositories.CarRepository;
import com.example.salonofcars.repositories.ContractRepository;
import com.example.salonofcars.repositories.SellerRepository;
import com.example.salonofcars.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public List<Contract> listContract(){
        return contractRepository.findAll();
    }
    public Contract getContractById(int id){
        Optional<Contract> optionalContract = contractRepository.findById(id);
        Contract contract = optionalContract.orElseGet(() -> null);
        return contract;
    }
    public String addContract(ContractDTO contractDTO) {
        Optional<Car> optionalCar = carRepository.findById(contractDTO.getCarId());
        Car car = optionalCar.orElseGet(() -> null);
        if (car == null) {
            return "машины с таким id не существует";
        }
        Optional<User> optionalUser = userRepository.findById(contractDTO.getUserId());
        User user = optionalUser.orElseGet(() -> null);
        if (user == null) {
            return "пользователя с таким id не существует";
        }
        Optional<Seller> optionalSeller = sellerRepository.findById(contractDTO.getSellerId());
        Seller seller = optionalSeller.orElseGet(() -> null);
        if (seller == null) {
            return "продовца с таким id не существует";
        }
        Contract contract = mapContractDTOToContract(contractDTO);
        contractRepository.save(contract);
        return "Контракт добавлен";
    }
    public String delContract(int id){
        Optional<Contract> optionalContract = contractRepository.findById(id);
        Contract contract = optionalContract.orElseGet(() -> null);
        if (contract == null) {
            return "Контракт с таким id не существует";
        }
        contractRepository.deleteById(id);
        return "Контракт удален";
    }
    public String updateContract(int id, ContractDTO contractDTO){
        Optional<Contract> optionalContract = contractRepository.findById(id);
        Contract contract = optionalContract.orElseGet(() -> null);
        if (contract == null) {
            return "Контракт с таким id не существует";
        }
        Optional<Car> optionalCar = carRepository.findById(contractDTO.getCarId());
        Car car = optionalCar.orElseGet(() -> null);
        if (car == null) {
            return "машины с таким id не существует";
        }
        Optional<User> optionalUser = userRepository.findById(contractDTO.getUserId());
        User user = optionalUser.orElseGet(() -> null);
        if (user == null) {
            return "пользователя с таким id не существует";
        }
        Optional<Seller> optionalSeller = sellerRepository.findById(contractDTO.getSellerId());
        Seller seller = optionalSeller.orElseGet(() -> null);
        if (seller == null) {
            return "продовца с таким id не существует";
        }

        contract.setSeller(sellerRepository.findById(contractDTO.getSellerId()).orElseThrow());
        contract.setUser(userRepository.findById(contractDTO.getUserId()).orElseThrow());
        contract.setCar(carRepository.findById(contractDTO.getCarId()).orElseThrow());
        contract.setTotalAmount(contractDTO.getTotalAmount());
        contract.setRegistrationDate(contractDTO.getRegistrationDate());
        contractRepository.save(contract);
        return "Контракт обновлен";
    }
    public Contract mapContractDTOToContract(ContractDTO contractDTO){
        Contract contract = new Contract();
        contract.setCar(carRepository.findById(contractDTO.getCarId()).orElseThrow());
        contract.setSeller(sellerRepository.findById(contractDTO.getSellerId()).orElseThrow());
        contract.setUser(userRepository.findById(contractDTO.getUserId()).orElseThrow());
        contract.setTotalAmount(contractDTO.getTotalAmount());
        contract.setRegistrationDate(contractDTO.getRegistrationDate());
        return contract;
    }
}
