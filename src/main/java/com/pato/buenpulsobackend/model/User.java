package com.pato.buenpulsobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idUser;
    private String name;
    private String surname;
    private String nationality;

    private LocalDate birthdate;

    private String gender;

    private String phone;
    private String email;

    private String role; // "admin" - "user"

    private double heightCm; // decimal
    private double weightKg; // decimal

    @ManyToOne
    @JoinColumn(name="blood_type_id", nullable = false)
    @JsonBackReference
    private BloodType bloodType;

    @Column(nullable = false)
    private String password; // 🔒

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Medications> medicationsList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChronicDiseases> chronicDiseasesList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<KnownAllergies> knownAllergiesList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Report> reportsList;
}
