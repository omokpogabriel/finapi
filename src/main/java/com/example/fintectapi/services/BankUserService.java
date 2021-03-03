package com.example.fintectapi.services;

import com.example.fintectapi.entities.BankUser;
import com.example.fintectapi.entities.UserBiodata;
import com.example.fintectapi.repositories.BankUserRepository;
import com.example.fintectapi.repositories.UserBiodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankUserService {

   private PasswordEncoder passwordEncoder;

   @Autowired
   private BankUserRepository bankUserRepository;

   @Autowired
   private UserBiodataRepository userBiodataRepository;

   @Autowired
    public BankUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public BankUserService() {
    }

    private boolean checkUser(long id){
        return bankUserRepository.existsById(id);
    }

    public BankUser createUser(BankUser bankUser){
         bankUser.setPassword(passwordEncoder.encode(bankUser.getPassword()));
         return  bankUserRepository.save(bankUser);
    }

    public List<BankUser> allCustomers(){
         return bankUserRepository.findAll();
    }


    public Optional<BankUser> getCustomer(long id){
         return bankUserRepository.findById(id);
    }

    // update customer
    public boolean updateUser(BankUser bankUser, long id){
         if(!checkUser(id)){
             return false;
         }

         BankUser user = bankUserRepository.findById(id).get();
         user.setPassword(passwordEncoder.encode(bankUser.getPassword()));
         bankUserRepository.save(user);
         return true;
    }

    // delete customer
    public ResponseEntity<String> deleteCustomer(long id){
        if (!checkUser(id)){
            return ResponseEntity.badRequest().body("User does not exist");
        }
        bankUserRepository.deleteById(id);
        return ResponseEntity.ok().body("User was deleted successfully");
    }


}
