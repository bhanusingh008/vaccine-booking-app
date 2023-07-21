package com.bhxnusingh.vaccinebookingsystem.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "certificate")
public class Certificate {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String certificateNo;

    String confirmationMessage;

    int doseTaken;

    @OneToOne
    @JoinColumn
    Person person;
}
