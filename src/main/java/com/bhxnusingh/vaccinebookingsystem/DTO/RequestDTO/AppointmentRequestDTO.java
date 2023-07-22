package com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDTO {
    String personEmail;

    String doctorEmail;

    long centerId;

    @CreationTimestamp
    Date date;
}
