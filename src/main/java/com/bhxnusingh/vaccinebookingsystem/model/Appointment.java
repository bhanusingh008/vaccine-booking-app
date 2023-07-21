package com.bhxnusingh.vaccinebookingsystem.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.print.Doc;
import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "appointment")
public class Appointment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String appointmentId;

    Date appointmentDate;

    @ManyToOne
    @JoinColumn
    Person person;

    @ManyToOne
    @JoinColumn()
    Doctor doctor;
}
