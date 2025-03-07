package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.Report;
import com.pato.buenpulsobackend.repository.IReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {

    @Autowired
    private IReportRepository reportRepository;

    @Override
    public Report getReport(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public void postReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void putReport(Report report) {
        if (getReport(report.getIdReport()) != null) {
            reportRepository.save(report);
        }
    }

    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
