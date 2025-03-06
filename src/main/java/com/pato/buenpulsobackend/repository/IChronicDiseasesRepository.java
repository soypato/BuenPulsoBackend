package com.pato.buenpulsobackend.repository;

import com.pato.buenpulsobackend.model.ChronicDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChronicDiseasesRepository extends JpaRepository<ChronicDiseases, Long> {
}
