package com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO;

import com.bhxnusingh.vaccinebookingsystem.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCenterRequestDTO {

    String centerName;

    CenterType centerType;

}
