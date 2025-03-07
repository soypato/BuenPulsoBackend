package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.KnownAllergies;
import com.pato.buenpulsobackend.repository.IKnownAllergiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnownAllergiesService implements IKnownAllergiesService {

    @Autowired
    private IKnownAllergiesRepository knownAllergiesRepository;

    @Override
    public KnownAllergies getKnownAllergies(Long id) {
        return knownAllergiesRepository.findById(id).orElse(null);
    }

    @Override
    public List<KnownAllergies> getAllKnownAllergies() {
        return knownAllergiesRepository.findAll();
    }

    @Override
    public void postKnownAllergies(KnownAllergies knownAllergies) {
        knownAllergiesRepository.save(knownAllergies);
    }

    @Override
    public void putKnownAllergies(KnownAllergies knownAllergies) {
        if (getKnownAllergies(knownAllergies.getIdKnownAllergies()) != null) {
            knownAllergiesRepository.save(knownAllergies);
        }
    }

    @Override
    public void deleteKnownAllergies(Long id) {
        knownAllergiesRepository.deleteById(id);
    }
}
