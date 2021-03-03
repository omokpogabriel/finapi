package com.example.fintectapi.controllers;

import com.example.fintectapi.entities.BankUser;
import com.example.fintectapi.entities.UserBiodata;
import com.example.fintectapi.services.BankUserService;
import com.example.fintectapi.services.UserBiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private BankUserService bankUserService;



    @GetMapping
    public ResponseEntity<BankUser> getAllCustomers(){
         List<BankUser> customers = bankUserService.allCustomers();
        return new ResponseEntity(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BankUser> createUser(@RequestBody BankUser bankUser){
        BankUser newUser = bankUserService.createUser(bankUser);

        URI location = UriComponentsBuilder.newInstance()
                .build().toUri();
            return ResponseEntity.created(location).body(newUser);
    }

    @DeleteMapping("{userid}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("userid") Long id){
        return bankUserService.deleteCustomer(id);
    }

    @PatchMapping("{userid}")
    public ResponseEntity<String> updateCustomer(@RequestBody BankUser bankUser,
                                               @PathVariable("userid") long id){
        boolean result = bankUserService.updateUser(bankUser, id);
        if(!result){
            return new ResponseEntity("User does not exist "+ bankUser,HttpStatus.BAD_REQUEST );
        }
        BankUser user = bankUserService.getCustomer(id).get();
        return new ResponseEntity(user,HttpStatus.OK);
    }
}
