package com.example.fintectapi.services;

import com.example.fintectapi.entities.AccountDetails;
import com.example.fintectapi.entities.UserBiodata;
import com.example.fintectapi.repositories.AccountDetailsRepository;
import com.example.fintectapi.repositories.UserBiodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailsService {

    private AccountDetailsRepository accountDetailsRepository;

    @Autowired
    private UserBiodataRepository userBiodataRepository;

    @Autowired
    public AccountDetailsService(AccountDetailsRepository accountDetailsRepository){
        this.accountDetailsRepository = accountDetailsRepository;
    }

    // create account
    public AccountDetails createAccount(AccountDetails accountDetails, String email){
            UserBiodata biodata = userBiodataRepository.findByEmail(email).get();
            accountDetails.setAccountName(biodata.getFirstname() + " " + biodata.getLastname());
            accountDetails.setUser_biodate(biodata);
        return accountDetailsRepository.save(accountDetails);
    }

    public List<AccountDetails> getAll(){
        return accountDetailsRepository.findAll();
    }
}
