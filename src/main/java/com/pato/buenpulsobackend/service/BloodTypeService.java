package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.BloodType;
import com.pato.buenpulsobackend.repository.IBloodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodTypeService implements IBloodTypeService {

    @Autowired
    private IBloodTypeRepository bloodTypeRepository;

    @Override
    public BloodType getBloodType(Long id) {
        return bloodTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<BloodType> getAllBloodTypes() {
        return bloodTypeRepository.findAll();
    }

    @Override
    public void postBloodType(BloodType bloodType) {
        bloodTypeRepository.save(bloodType);
    }

    @Override
    public void putBloodType(BloodType bloodType) {
        if (getBloodType(bloodType.getBloodTypeId()) != null) {
            bloodTypeRepository.save(bloodType);
        }
    }

    @Override
    public void deleteBloodType(Long id) {
        bloodTypeRepository.deleteById(id);
    }
}
