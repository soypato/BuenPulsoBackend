package com.pato.buenpulsobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idReport;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    private int systolicPressure;
    private int diastolicPressure;
    private int beatsPerMinute;
    private int glucose;
    private int bloodOxygen;
    private int bodyTemperature;
    private String mood;
    private LocalDate registrationDate;
}
