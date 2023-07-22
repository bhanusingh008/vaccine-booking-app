package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddDoctorRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.DoctorResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.exception.DoctorNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Doctor;
import com.bhxnusingh.vaccinebookingsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity add_doctor(@RequestBody AddDoctorRequestDTO requestDTO){
        try{
            DoctorResponseDTO responseDTO = doctorService.add_doctor(requestDTO);

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Something Went Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateEmail")
    public ResponseEntity updateEmail(@RequestParam("oldEmail") String oldEmail, @RequestParam("newEmail") String newEmail){
        try{
            Doctor doctor = doctorService.updateEmail(oldEmail, newEmail);
            return new ResponseEntity<>("Updated Email "+doctor.getEmail()+" for Dr."+doctor.getName(), HttpStatus.ACCEPTED);
        }catch (DoctorNotFoundException DoctorNotFoundException){
            return new ResponseEntity<>(DoctorNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/age-more-than")
    public List<String> getAgeMoreThan(@RequestParam("age") int age){

        return doctorService.getAgeMoreThan(age);
    }

    @GetMapping("/getAll")
    public List<DoctorResponseDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
}
