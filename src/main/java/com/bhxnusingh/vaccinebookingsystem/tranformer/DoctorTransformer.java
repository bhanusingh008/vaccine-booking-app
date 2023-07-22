package com.bhxnusingh.vaccinebookingsystem.tranformer;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddDoctorRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.DoctorResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.Doctor;

public class DoctorTransformer {

    public static Doctor DoctorRequestDTOtoDoctor(AddDoctorRequestDTO requestDTO){

        Doctor doctor = new Doctor();
        doctor.setName(requestDTO.getName());
        doctor.setEmail(requestDTO.getEmail());
        doctor.setPhone(requestDTO.getPhone());
        doctor.setGender(requestDTO.getGender());
        doctor.setAge(requestDTO.getAge());

        return doctor;
    }

    public static DoctorResponseDTO DoctorResponseDTOFromDoctor(Doctor doctor){

        DoctorResponseDTO doctorResponseDTO = DoctorResponseDTO.builder()
                .name(doctor.getName())
                .email(doctor.getEmail())
                .build();

        return doctorResponseDTO;
    }
}
