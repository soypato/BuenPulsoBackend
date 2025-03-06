package com.pato.buenpulsobackend.repository;

import com.pato.buenpulsobackend.model.KnownAllergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKnownAllergiesRepository extends JpaRepository<KnownAllergies, Long> {
}
