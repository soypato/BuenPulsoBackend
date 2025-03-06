package com.pato.buenpulsobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
public class Medications {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idMedications;

    private int quantityMg;

    private LocalDate diagnosisDate;

    private LocalDate endDate;

    private String medicationReason;

    private String consumptionFrequency;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user; // best practices
}
