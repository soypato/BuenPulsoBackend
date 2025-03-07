package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.Medications;
import java.util.List;

public interface IMedicationsService {
    Medications getMedications(Long id);
    List<Medications> getAllMedications();
    void postMedications(Medications medications);
    void putMedications(Medications medications);
    void deleteMedications(Long id);
}
