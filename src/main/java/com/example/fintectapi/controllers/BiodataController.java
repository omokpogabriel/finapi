package com.example.fintectapi.controllers;

import com.example.fintectapi.entities.BankUser;
import com.example.fintectapi.entities.UserBiodata;
import com.example.fintectapi.services.BankUserService;
import com.example.fintectapi.services.UserBiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/api/v1/biodata")
public class BiodataController {

    @Autowired
    private UserBiodataService userBiodataService;

    @GetMapping
    public ResponseEntity<UserBiodata> getAllBiodata(){
        List<UserBiodata> userBiodata = userBiodataService.getAllBiodata();

        return new ResponseEntity(userBiodata, HttpStatus.OK);
    }

    @GetMapping("{bio_id}")
    public ResponseEntity<Optional<UserBiodata>> getBiodata(@PathVariable("bio_id") long id){
        Optional<UserBiodata> userBiodata = userBiodataService.getBiodata(id);
        if(!userBiodata.isPresent()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(userBiodata, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserBiodata> createBiodata(@RequestBody UserBiodata userBiodata){
        try{
            UserBiodata biodata = userBiodataService.createBiodata(userBiodata);
            return new ResponseEntity(biodata, HttpStatus.OK);
        }catch( SQLException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<UserBiodata> updateBiodata(@RequestBody UserBiodata userBiodata){
        try{
            UserBiodata biodata = userBiodataService.updateBiodata(userBiodata,
                    userBiodata.getEmail());
            return new ResponseEntity(biodata, HttpStatus.OK);
        }catch( SQLException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }catch( Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
