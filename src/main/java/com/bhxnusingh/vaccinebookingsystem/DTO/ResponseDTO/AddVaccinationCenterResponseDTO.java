package com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO;


import com.bhxnusingh.vaccinebookingsystem.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddVaccinationCenterResponseDTO {

    String centerName;

    CenterType centerType;

}
