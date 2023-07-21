package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddCenterRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddVaccinationCenterResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.VaccinationCenter;
import com.bhxnusingh.vaccinebookingsystem.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v-center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addCenter(AddCenterRequestDTO requestDTO){

        AddVaccinationCenterResponseDTO responseDTO = vaccinationCenterService.addCenter(requestDTO);

        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
}
