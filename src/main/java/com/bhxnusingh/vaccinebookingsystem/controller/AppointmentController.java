package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddAppointmentRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddAppointmentResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity create_appointment(@RequestBody AddAppointmentRequestDTO requestDTO){
        try{
            AddAppointmentResponseDTO responseDTO = appointmentService.create_appointment(requestDTO);

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
