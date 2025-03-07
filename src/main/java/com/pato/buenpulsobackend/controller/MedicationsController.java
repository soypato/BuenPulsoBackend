package com.pato.buenpulsobackend.controller;

import com.pato.buenpulsobackend.model.Medications;
import com.pato.buenpulsobackend.service.MedicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationsController {

    @Autowired
    private MedicationsService medicationsService;

    @GetMapping("/get")
    public ResponseEntity<List<Medications>> getAllMedications() {
        return new ResponseEntity<>(medicationsService.getAllMedications(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Medications> getMedications(@PathVariable Long id) {
        Medications medications = medicationsService.getMedications(id);
        return medications != null ? new ResponseEntity<>(medications, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postMedications(@RequestBody Medications medications) {
        medicationsService.postMedications(medications);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Medications> putMedications(@PathVariable Long id, @RequestBody Medications medications) {
        medicationsService.putMedications(medications);
        return new ResponseEntity<>(medicationsService.getMedications(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedications(@PathVariable Long id) {
        medicationsService.deleteMedications(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
