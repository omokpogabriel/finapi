package com.example.fintectapi.services;

import com.example.fintectapi.entities.NextOfKinDetails;
import com.example.fintectapi.entities.UserBiodata;
import com.example.fintectapi.repositories.NextOfKinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class NextOfKinService {

    private NextOfKinRepository nextOfKinRepository;

    private UserBiodataService userBiodataService;

    @Autowired
    public NextOfKinService(NextOfKinRepository nextOfKinRepository, UserBiodataService userBiodataService) {
        this.nextOfKinRepository = nextOfKinRepository;
        this.userBiodataService = userBiodataService;
    }

    // find one next of kin
    public NextOfKinDetails getNextOfKin( Long id){
        Optional<NextOfKinDetails> nextofkin = nextOfKinRepository.findById(id);
        if(!nextofkin.isPresent()){
            throw new EntityNotFoundException("kin not found");
        }
        return nextofkin.get();
    }

    // find all next of kin
    public List<NextOfKinDetails> getAllNextOfKin(){
        return nextOfKinRepository.findAll();
    }

    // create new next of kin
    public NextOfKinDetails createNextOfKin(NextOfKinDetails nextOfKinDetails, String AccountEmail){
        Optional<UserBiodata> biodata = userBiodataService.getByEmail(AccountEmail);
        if(!biodata.isPresent()){
            throw new EntityNotFoundException("email not found");
        }
        nextOfKinDetails.setUser_bio_nok(biodata.get());
        return nextOfKinRepository.save(nextOfKinDetails);
    }

    // update next of kin
    public NextOfKinDetails updateNextOfKin(NextOfKinDetails nextOfKinDetails, Long id){
        Optional<NextOfKinDetails> nextOfKIn = nextOfKinRepository.findById(id);
        if(!nextOfKIn.isPresent()){
            throw new DataRetrievalFailureException("user not found not found");
        }
        NextOfKinDetails nof = nextOfKIn.get();
        nof= nextOfKinDetails;
        nextOfKinRepository.save(nof);
        return nof;

    }

    //delete nextofkin
    public boolean removeNextOfKin(Long id){
        Optional<NextOfKinDetails> nextOfKIn = nextOfKinRepository.findById(id);
        if(!nextOfKIn.isPresent()){
            throw new DataRetrievalFailureException("user not found not found");
        }

        nextOfKinRepository.deleteById(id);
        return true;
    }
}
