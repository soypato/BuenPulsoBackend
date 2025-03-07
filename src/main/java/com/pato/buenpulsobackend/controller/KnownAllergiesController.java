package com.pato.buenpulsobackend.controller;

import com.pato.buenpulsobackend.model.KnownAllergies;
import com.pato.buenpulsobackend.service.KnownAllergiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knownAllergies")
public class KnownAllergiesController {

    @Autowired
    private KnownAllergiesService knownAllergiesService;

    @GetMapping("/get")
    public ResponseEntity<List<KnownAllergies>> getAllKnownAllergies() {
        return new ResponseEntity<>(knownAllergiesService.getAllKnownAllergies(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<KnownAllergies> getKnownAllergy(@PathVariable Long id) {
        KnownAllergies knownAllergy = knownAllergiesService.getKnownAllergies(id);
        return knownAllergy != null ? new ResponseEntity<>(knownAllergy, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postKnownAllergy(@RequestBody KnownAllergies knownAllergies) {
        knownAllergiesService.postKnownAllergies(knownAllergies);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<KnownAllergies> putKnownAllergy(@PathVariable Long id, @RequestBody KnownAllergies knownAllergies) {
        knownAllergiesService.putKnownAllergies(knownAllergies);
        return new ResponseEntity<>(knownAllergiesService.getKnownAllergies(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKnownAllergy(@PathVariable Long id) {
        knownAllergiesService.deleteKnownAllergies(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
