package com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddDoctorResponseDTO {
    String name;
    long id;
}
