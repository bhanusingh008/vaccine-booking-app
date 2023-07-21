package com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonResponseDTO {
    long id;

    String name;

    String email;

    String phone;

    String message = "From the DTO";
}
