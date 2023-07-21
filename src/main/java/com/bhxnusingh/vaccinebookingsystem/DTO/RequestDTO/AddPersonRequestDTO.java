package com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO;

import com.bhxnusingh.vaccinebookingsystem.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonRequestDTO {
    String name;

    int age;

    @Column(nullable = false , unique = true)
    String email;

    String phone;

    @Enumerated(EnumType.STRING)
    Gender gender;

}
