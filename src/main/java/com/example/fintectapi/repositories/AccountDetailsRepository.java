package com.example.fintectapi.repositories;

import com.example.fintectapi.entities.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

}
