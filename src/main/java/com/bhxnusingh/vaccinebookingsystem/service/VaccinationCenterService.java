package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddCenterRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddVaccinationCenterResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.VaccinationCenter;
import com.bhxnusingh.vaccinebookingsystem.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public AddVaccinationCenterResponseDTO addCenter(AddCenterRequestDTO requestDTO) {

        VaccinationCenter center = VaccinationCenter.builder()
                .centerName(requestDTO.getCenterName())
                .centerType(requestDTO.getCenterType())
                .build();

        VaccinationCenter savedCenter =  vaccinationCenterRepository.save(center);

        AddVaccinationCenterResponseDTO responseDTO = AddVaccinationCenterResponseDTO.builder()
                .centerName(savedCenter.getCenterName())
                .centerType(savedCenter.getCenterType())
                .build();

        return responseDTO;
    }
}
