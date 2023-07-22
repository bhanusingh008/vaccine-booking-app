package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AppointmentRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AppointmentResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.exception.DoctorNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.exception.PersonNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity create_appointment(@RequestBody AppointmentRequestDTO requestDTO){
        try{
            AppointmentResponseDTO responseDTO = appointmentService.create_appointment(requestDTO);

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/doctor/{email}")
    public ResponseEntity getAppointmentsOfDoctor(@PathVariable("email") String email){

        try{
            List<AppointmentResponseDTO> responseDTOList = appointmentService.getAppointmentsOfDoctor(email);

            return new ResponseEntity<>(responseDTOList, HttpStatus.FOUND);
        }catch (DoctorNotFoundException e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/person/{email}")
    public ResponseEntity getAppointmentsOfPerson(@PathVariable("email") String email){
        try{
            List<AppointmentResponseDTO> responseDTOList = appointmentService.getAppointmentsOfPerson(email);

            return new ResponseEntity<>(responseDTOList, HttpStatus.FOUND);
        }catch (PersonNotFoundException e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
