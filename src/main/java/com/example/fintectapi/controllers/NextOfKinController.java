package com.example.fintectapi.controllers;

import com.example.fintectapi.entities.NextOfKinDetails;
import com.example.fintectapi.services.NextOfKinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/nextofkin")
public class NextOfKinController {

    @Autowired
    private NextOfKinService nextOfKinService;

    @GetMapping
    public ResponseEntity<NextOfKinDetails> getAllNextOfKin(){
        List<NextOfKinDetails> nextOfKinDetails = nextOfKinService.getAllNextOfKin();
        return new ResponseEntity(nextOfKinDetails, HttpStatus.OK );
    }

    @GetMapping("/{kin_id}")
    public ResponseEntity<NextOfKinDetails> getNextofKin(@PathVariable("kin_id") Long id){
        NextOfKinDetails nextOfKinDetails = nextOfKinService.getNextOfKin(id);
        return new ResponseEntity(nextOfKinDetails, HttpStatus.OK );
    }

    @PostMapping("/create")
    public ResponseEntity<NextOfKinDetails> create(@RequestBody NextOfKinDetails nextOfKinDetails){
            NextOfKinDetails nextOfKin = nextOfKinService.createNextOfKin(nextOfKinDetails, nextOfKinDetails.getUser_bio_nok().getEmail());
            return new ResponseEntity(nextOfKin, HttpStatus.OK );
    }

    @PatchMapping("/update/{kin_id}")
    public ResponseEntity<NextOfKinDetails> update(@RequestBody NextOfKinDetails nextOfKinDetails, @PathVariable("kin_id") Long id){
        NextOfKinDetails nextOfKin = nextOfKinService.updateNextOfKin(nextOfKinDetails, id);
        return new ResponseEntity(nextOfKin, HttpStatus.OK );
    }

    @DeleteMapping("/delete/{kin_id}")
    public ResponseEntity<NextOfKinDetails> remove(@PathVariable("kin_id") Long id){
        boolean result = nextOfKinService.removeNextOfKin(id);
        return new ResponseEntity(result, HttpStatus.OK );
    }

}
