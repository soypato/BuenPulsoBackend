package com.pato.buenpulsobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class BloodType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long bloodTypeId;
    private String type; // "A+", "O-", etc.

    // bloodType is a attribute in User => one BloodType have many users
    @OneToMany(mappedBy = "bloodType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<User> users;
}
