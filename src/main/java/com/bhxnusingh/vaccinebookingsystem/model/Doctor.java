package com.bhxnusingh.vaccinebookingsystem.model;

import com.bhxnusingh.vaccinebookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "doctor")
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String name;

    int age;

    @Column(unique = true)
    String email;

    String phone;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @ManyToOne
    @JoinColumn
    @Enumerated(EnumType.STRING)
    VaccinationCenter center;
}
