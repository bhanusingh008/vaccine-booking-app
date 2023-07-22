package com.bhxnusingh.vaccinebookingsystem.controller;


import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.CertificateResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    // creates certificate only if both the doses are taken.
    @PostMapping("/create")
    public ResponseEntity create_certificate(@RequestParam("email") String email){
        try{
           CertificateResponseDTO responseDTO = certificateService.create_certificate(email);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Dose Two Not taken.", HttpStatus.BAD_REQUEST);
        }
    }
}
