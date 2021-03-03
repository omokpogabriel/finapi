package com.example.fintectapi.services;

import com.example.fintectapi.entities.BankUser;
import com.example.fintectapi.entities.UserBiodata;
import com.example.fintectapi.repositories.BankUserRepository;
import com.example.fintectapi.repositories.UserBiodataRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserBiodataService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserBiodataRepository userBiodataRepository;

    @Autowired
    private BankUserRepository bankUserRepository;

    @Autowired
    public UserBiodataService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // get all Biodata
    public List<UserBiodata> getAllBiodata(){
        return userBiodataRepository.findAll();
    }

    //get single Biodata
    public Optional<UserBiodata> getBiodata(long id){
        return userBiodataRepository.findById(id);
    }

    //get single Biodata
    public Optional<UserBiodata> getByEmail(String email){
        return userBiodataRepository.findByEmail(email);
    }


    //update customer biodata
    public UserBiodata updateBiodata(UserBiodata userBiodata, String email) throws SQLException{
        Optional<UserBiodata> bio = userBiodataRepository.findByEmail(email);
        if(!bio.isPresent()){
            throw new SQLException("NO account with email found");
        }
        UserBiodata biodate = bio.get();

        if(userBiodata.getAddress() !=null) {
            biodate.setAddress(userBiodata.getAddress());
        }

        if(userBiodata.getDob() != null) {
            biodate.setDob(userBiodata.getDob());
        }

        if(userBiodata.getGender() != null){
            biodate.setGender(userBiodata.getGender());
        }

        if(userBiodata.getEmployer() != null){
            biodate.setEmployer(userBiodata.getEmployer());
        }

        if(userBiodata.getFirstname() != null){
            biodate.setFirstname(userBiodata.getFirstname());
        }

        if(userBiodata.getLastname() != null){
            biodate.setLastname(userBiodata.getLastname());
        }
        if(userBiodata.getMaritalStatus() != null){
            biodate.setMaritalStatus(userBiodata.getMaritalStatus());
        }

        if(userBiodata.getNationality() != null){
            biodate.setNationality(userBiodata.getNationality());
        }

        if(userBiodata.getPhone() != null){
            biodate.setPhone(userBiodata.getPhone());
        }

        if(userBiodata.getReligion() != null){
            biodate.setReligion(userBiodata.getReligion());
        }

        return userBiodataRepository.save(biodate);
    }

    //delete customer biodata
    public boolean deleteBiodata(long id){
        Optional<UserBiodata> bio = getBiodata(id);
        if(!bio.isPresent()){
            return false;
        }

        userBiodataRepository.delete(bio.get());
        return true;
    }

    public UserBiodata createBiodata(UserBiodata userBiodata) throws SQLException {
        if(userBiodataRepository.findByEmail(userBiodata.getEmail()).isPresent() ){
            throw new SQLException("Email has be registered previously");
        }
        return userBiodataRepository.save(userBiodata);
    }


}
