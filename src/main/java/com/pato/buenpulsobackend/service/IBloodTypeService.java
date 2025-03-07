package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.BloodType;
import java.util.List;

public interface IBloodTypeService {
    BloodType getBloodType(Long id);
    List<BloodType> getAllBloodTypes();
    void postBloodType(BloodType bloodType);
    void putBloodType(BloodType bloodType);
    void deleteBloodType(Long id);
}
