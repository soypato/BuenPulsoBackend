package com.pato.buenpulsobackend.repository;

import com.pato.buenpulsobackend.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {

}
