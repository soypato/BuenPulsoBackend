package com.pato.buenpulsobackend.controller;

import com.pato.buenpulsobackend.model.BloodType;
import com.pato.buenpulsobackend.service.BloodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodTypes")
public class BloodTypeController {

    @Autowired
    private BloodTypeService bloodTypeService;

    @GetMapping("/get")
    public ResponseEntity<List<BloodType>> getAllBloodTypes() {
        return new ResponseEntity<>(bloodTypeService.getAllBloodTypes(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BloodType> getBloodType(@PathVariable Long id) {
        BloodType bloodType = bloodTypeService.getBloodType(id);
        return bloodType != null ? new ResponseEntity<>(bloodType, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postBloodType(@RequestBody BloodType bloodType) {
        bloodTypeService.postBloodType(bloodType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<BloodType> putBloodType(@PathVariable Long id, @RequestBody BloodType bloodType) {
        bloodTypeService.putBloodType(bloodType);
        return new ResponseEntity<>(bloodTypeService.getBloodType(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBloodType(@PathVariable Long id) {
        bloodTypeService.deleteBloodType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
