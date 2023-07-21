package com.bhxnusingh.vaccinebookingsystem.model;

import com.bhxnusingh.vaccinebookingsystem.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "vaccinationCenter")
@Builder
public class VaccinationCenter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String centerName;

    @Enumerated(EnumType.STRING)
    CenterType centerType;

    @OneToMany
    List<Doctor> doctorList = new ArrayList<>();
}
