package com.example.fintectapi.repositories;

import com.example.fintectapi.entities.NextOfKinDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NextOfKinRepository extends JpaRepository<NextOfKinDetails, Long> {
}
