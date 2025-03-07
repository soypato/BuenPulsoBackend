package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.ChronicDiseases;
import com.pato.buenpulsobackend.repository.IChronicDiseasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChronicDiseasesService implements IChronicDiseasesService {

    @Autowired
    private IChronicDiseasesRepository chronicDiseaseRepository;

    @Override
    public ChronicDiseases getChronicDisease(Long id) {
        return chronicDiseaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChronicDiseases> getAllChronicDiseases() {
        return chronicDiseaseRepository.findAll();
    }

    @Override
    public void postChronicDisease(ChronicDiseases chronicDisease) {
        chronicDiseaseRepository.save(chronicDisease);
    }

    @Override
    public void putChronicDisease(ChronicDiseases chronicDisease) {
        if (getChronicDisease(chronicDisease.getIdChronicDiseases()) != null) {
            chronicDiseaseRepository.save(chronicDisease);
        }
    }

    @Override
    public void deleteChronicDisease(Long id) {
        chronicDiseaseRepository.deleteById(id);
    }
}
