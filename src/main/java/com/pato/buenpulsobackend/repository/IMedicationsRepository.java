package com.pato.buenpulsobackend.repository;

import com.pato.buenpulsobackend.model.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicationsRepository extends JpaRepository<Medications, Long> {
}
