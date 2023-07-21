package com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO;

import com.bhxnusingh.vaccinebookingsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddDoctorRequestDTO {

    String name;
    int age;
    String email;
    String phone;
    Gender gender;
}
