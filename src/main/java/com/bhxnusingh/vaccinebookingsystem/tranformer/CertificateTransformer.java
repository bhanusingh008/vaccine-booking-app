package com.bhxnusingh.vaccinebookingsystem.tranformer;

import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.CertificateResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.Certificate;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CertificateTransformer {

    @Autowired
    PersonRepository personRepository;

    public static Certificate certificateResponseDTOtoCertificate(String email){

        Certificate certificate = new Certificate();
        certificate.setCertificateNo(UUID.randomUUID().toString());
        certificate.setConfirmationMessage("Certification of Dose 1 Completion");
        certificate.setDoseTaken(1);

        return certificate;
    }

    public static CertificateResponseDTO certificateToCertificateResponseDTO(Certificate certificate){
        CertificateResponseDTO responseDTO = CertificateResponseDTO.builder()
                .certificateNo(certificate.getCertificateNo())
                .confirmationMessage(certificate.getConfirmationMessage())
                .personEmail(certificate.getPerson().getEmail())
                .build();

        return responseDTO;
    }
}
