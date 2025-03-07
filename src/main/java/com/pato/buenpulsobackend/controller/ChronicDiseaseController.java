package com.pato.buenpulsobackend.controller;

import com.pato.buenpulsobackend.model.ChronicDiseases;
import com.pato.buenpulsobackend.model.ChronicDiseases;
import com.pato.buenpulsobackend.service.ChronicDiseasesService;
import com.pato.buenpulsobackend.service.ChronicDiseasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chronicDiseases")
public class ChronicDiseaseController {

    @Autowired
    private ChronicDiseasesService chronicDiseaseService;

    @GetMapping("/get")
    public ResponseEntity<List<ChronicDiseases>> getAllChronicDiseases() {
        return new ResponseEntity<>(chronicDiseaseService.getAllChronicDiseases(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ChronicDiseases> getChronicDisease(@PathVariable Long id) {
        ChronicDiseases chronicDisease = chronicDiseaseService.getChronicDisease(id);
        return chronicDisease != null ? new ResponseEntity<>(chronicDisease, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postChronicDisease(@RequestBody ChronicDiseases chronicDisease) {
        chronicDiseaseService.postChronicDisease(chronicDisease);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ChronicDiseases> putChronicDisease(@PathVariable Long id, @RequestBody ChronicDiseases chronicDisease) {
        chronicDiseaseService.putChronicDisease(chronicDisease);
        return new ResponseEntity<>(chronicDiseaseService.getChronicDisease(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChronicDisease(@PathVariable Long id) {
        chronicDiseaseService.deleteChronicDisease(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
