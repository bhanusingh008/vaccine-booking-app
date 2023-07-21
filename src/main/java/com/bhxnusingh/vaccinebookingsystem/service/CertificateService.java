package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.model.Certificate;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.repository.CertificateRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CertificateService {
    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    PersonRepository personRepository;
    public Certificate create_certificate(String email) {
        Certificate certificate = new Certificate();
        certificate.setCertificateNo(UUID.randomUUID().toString());
        certificate.setPerson(personRepository.findByEmail(email));
        certificate.setConfirmationMessage("Certification of Dose 1 Completion");
        certificate.setDoseTaken(1);

        return certificateRepository.save(certificate);
    }

    public Certificate secondDoseTaken(long personId) {
        Person curr_person = personRepository.getReferenceById(personId);
        Certificate certificate = curr_person.getCertificate();
        certificate.setDoseTaken(2);
        certificate.setConfirmationMessage("Certification of Dose 2 Completion");

        return certificateRepository.save(certificate);
    }
}
