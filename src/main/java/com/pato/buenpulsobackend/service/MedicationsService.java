package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.Medications;
import com.pato.buenpulsobackend.repository.IMedicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationsService implements IMedicationsService{
    @Autowired
    private IMedicationsRepository medicationsRepository;

    @Override
    public Medications getMedications(Long id) {
        return medicationsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medications> getAllMedications() {
        return medicationsRepository.findAll();
    }

    @Override
    public void postMedications(Medications medications) {
        medicationsRepository.save(medications);
    }

    @Override
    public void putMedications(Medications medications) {
        if (getMedications(medications.getIdMedications()) != null) {
            medicationsRepository.save(medications);
        }
    }

    @Override
    public void deleteMedications(Long id) {
        medicationsRepository.deleteById(id);
    }
}
