package com.pato.buenpulsobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class ChronicDiseases {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idChronicDiseases;
    private String disease;

    private LocalDate diagnosticDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;
}

