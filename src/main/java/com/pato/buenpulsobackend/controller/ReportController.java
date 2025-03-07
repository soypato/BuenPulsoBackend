package com.pato.buenpulsobackend.controller;

import com.pato.buenpulsobackend.model.Report;
import com.pato.buenpulsobackend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/get")
    public ResponseEntity<List<Report>> getAllReports() {
        return new ResponseEntity<>(reportService.getAllReports(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Report> getReport(@PathVariable Long id) {
        Report report = reportService.getReport(id);
        return report != null ? new ResponseEntity<>(report, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postReport(@RequestBody Report report) {
        reportService.postReport(report);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Report> putReport(@PathVariable Long id, @RequestBody Report report) {
        reportService.putReport(report);
        return new ResponseEntity<>(reportService.getReport(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
