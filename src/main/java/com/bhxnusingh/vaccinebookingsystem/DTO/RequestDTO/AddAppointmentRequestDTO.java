package com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddAppointmentRequestDTO {
    long personId;

    long doctorId;

    Date date;
}
