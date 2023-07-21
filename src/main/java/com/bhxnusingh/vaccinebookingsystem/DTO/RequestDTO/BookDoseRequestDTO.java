package com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO;

import com.bhxnusingh.vaccinebookingsystem.Enum.DoseName;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDoseRequestDTO {
    String email;
    DoseName doseName;
}
