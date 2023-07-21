package com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDoseResponseDTO {
    String email;
    String message;
}
