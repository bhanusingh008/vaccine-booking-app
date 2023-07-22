package com.bhxnusingh.vaccinebookingsystem.model;

import com.bhxnusingh.vaccinebookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "person")
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String name;

    int age;

    @Column(unique = true, nullable = false)
    String email;

    String phone;

    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean doseOneTaken;

    boolean doseTwoTaken;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Appointment> appointmentList = new ArrayList<>();

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    List<Dose> dosesTaken = new ArrayList<>();

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    Certificate certificate;
}
