package com.bhxnusingh.vaccinebookingsystem.model;

import com.bhxnusingh.vaccinebookingsystem.Enum.DoseName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "dose")
public class Dose {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String doseId;

    @Enumerated(EnumType.STRING)
    DoseName doseName;

    @CreationTimestamp
    Date vaccinationDate;

    @ManyToOne
    @JoinColumn
    Person person;
}
