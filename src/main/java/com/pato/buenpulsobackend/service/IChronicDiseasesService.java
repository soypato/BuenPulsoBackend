package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.ChronicDiseases;
import java.util.List;

public interface IChronicDiseasesService {
    ChronicDiseases getChronicDisease(Long id);
    List<ChronicDiseases> getAllChronicDiseases();
    void postChronicDisease(ChronicDiseases chronicDisease);
    void putChronicDisease(ChronicDiseases chronicDisease);
    void deleteChronicDisease(Long id);
}
