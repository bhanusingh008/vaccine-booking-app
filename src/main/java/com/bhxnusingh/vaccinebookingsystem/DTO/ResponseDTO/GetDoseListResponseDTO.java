package com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO;

import com.bhxnusingh.vaccinebookingsystem.Enum.DoseName;
import com.bhxnusingh.vaccinebookingsystem.model.Dose;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetDoseListResponseDTO {

    String email;

    List<DoseName> doses;
}
