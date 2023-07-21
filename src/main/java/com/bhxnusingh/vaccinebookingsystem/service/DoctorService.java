package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddDoctorRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddDoctorResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.Doctor;
import com.bhxnusingh.vaccinebookingsystem.repository.DoctorRepository;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public AddDoctorResponseDTO add_doctor(AddDoctorRequestDTO requestDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(requestDTO.getName());
        doctor.setEmail(requestDTO.getEmail());
        doctor.setPhone(requestDTO.getPhone());
        doctor.setGender(requestDTO.getGender());
        doctor.setAge(requestDTO.getAge());

        Doctor saved_doctor = doctorRepository.save(doctor);

        return new AddDoctorResponseDTO(saved_doctor.getName(), saved_doctor.getId());
    }
}
