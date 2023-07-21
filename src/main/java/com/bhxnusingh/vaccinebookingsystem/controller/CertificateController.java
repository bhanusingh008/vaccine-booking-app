package com.bhxnusingh.vaccinebookingsystem.controller;


import com.bhxnusingh.vaccinebookingsystem.model.Certificate;
import com.bhxnusingh.vaccinebookingsystem.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    // created at the time of 1st dose.
    public Certificate create_certificate(String email){
        try{
            Certificate certificate = certificateService.create_certificate(email);
            return certificate;
        }catch (Exception e){
            throw new RuntimeException("Something Went Wrong");
        }
    }

    public void secondDoseTaken(long personId){
        try{
            Certificate certificate = certificateService.secondDoseTaken(personId);
        }catch (Exception e){
            throw new RuntimeException("Something Went Wrong");
        }
    }
}
