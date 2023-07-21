package com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddAppointmentResponseDTO {
    String appointmentId;

    Date date;

    String personName;

    String doctorName;
}
