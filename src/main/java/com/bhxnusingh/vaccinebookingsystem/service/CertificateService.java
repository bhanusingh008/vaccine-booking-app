package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.CertificateResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.exception.PersonNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Certificate;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.repository.CertificateRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import com.bhxnusingh.vaccinebookingsystem.tranformer.CertificateTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CertificateService {
    @Autowired
    CertificateRepository certificateRepository;
    @Autowired
    PersonRepository personRepository;
    public CertificateResponseDTO create_certificate(String email) {
        Optional<Person> optionalPerson = personRepository.findByEmail(email);

        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Person not found.");
        }

        if(!optionalPerson.get().isDoseTwoTaken()){
            throw new RuntimeException("Dose Two Not Taken");
        }

        Certificate certificate = CertificateTransformer.certificateResponseDTOtoCertificate(email);

        certificate.setPerson(optionalPerson.get());

        Certificate saved_certificate = certificateRepository.save(certificate);

        return CertificateTransformer.certificateToCertificateResponseDTO(saved_certificate);
    }
}
