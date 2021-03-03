package com.example.fintectapi.repositories;

import com.example.fintectapi.entities.AccountDetails;
import com.example.fintectapi.entities.UserBiodata;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Qualifier("userBio")
@Repository
public interface UserBiodataRepository extends JpaRepository<UserBiodata, Long> {

     Optional<UserBiodata> findByEmail(String email);

}
