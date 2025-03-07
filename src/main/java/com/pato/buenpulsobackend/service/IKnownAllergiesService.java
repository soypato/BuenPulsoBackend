package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.KnownAllergies;
import java.util.List;

public interface IKnownAllergiesService {
    KnownAllergies getKnownAllergies(Long id);
    List<KnownAllergies> getAllKnownAllergies();
    void postKnownAllergies(KnownAllergies knownAllergies);
    void putKnownAllergies(KnownAllergies knownAllergies);
    void deleteKnownAllergies(Long id);
}
