package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddDoctorRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddDoctorResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity add_doctor(@RequestBody AddDoctorRequestDTO requestDTO){
        try{
            AddDoctorResponseDTO responseDTO = doctorService.add_doctor(requestDTO);

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Something Went Wrong", HttpStatus.BAD_REQUEST);
        }
    }
}
