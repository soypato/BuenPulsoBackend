package com.pato.buenpulsobackend.repository;

import com.pato.buenpulsobackend.model.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBloodTypeRepository extends JpaRepository<BloodType, Long> {
}
