package com.example.fintectapi.controllers;

import com.example.fintectapi.entities.AccountDetails;
import com.example.fintectapi.services.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountDetailsService accountDetailsService;

    @PostMapping("/create")
    public ResponseEntity<AccountDetails> createAccount(@RequestBody AccountDetails accountDetails){
        accountDetailsService.createAccount(accountDetails, accountDetails.user_biodate.getEmail());
        return new ResponseEntity("created successf ully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AccountDetails> getAll(){
        return new ResponseEntity(accountDetailsService.getAll(), HttpStatus.CREATED);
    }
}
