package com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CertificateResponseDTO {

    String certificateNo;

    String confirmationMessage;

    String personEmail;
}
