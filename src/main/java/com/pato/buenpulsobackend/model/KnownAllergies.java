package com.pato.buenpulsobackend.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@Entity
public class KnownAllergies {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idKnownAllergies;
    private String allergy;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
