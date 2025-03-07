package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.Report;
import java.util.List;

public interface IReportService {
    Report getReport(Long id);
    List<Report> getAllReports();
    void postReport(Report report);
    void putReport(Report report);
    void deleteReport(Long id);
}
