package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddDoctorRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.DoctorResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.exception.DoctorNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Doctor;
import com.bhxnusingh.vaccinebookingsystem.repository.DoctorRepository;
import com.bhxnusingh.vaccinebookingsystem.tranformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public DoctorResponseDTO add_doctor(AddDoctorRequestDTO requestDTO) {

        Doctor doctor = DoctorTransformer.DoctorRequestDTOtoDoctor(requestDTO);

        Doctor saved_doctor = doctorRepository.save(doctor);

        return new DoctorResponseDTO(saved_doctor.getName(), saved_doctor.getEmail());
    }

    public Doctor updateEmail(String oldEmail, String newEmail) {

        Optional<Doctor> optionalDoctor = doctorRepository.findByEmail(oldEmail);

        if(optionalDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Email does not exist.");
        }

        optionalDoctor.get().setEmail(newEmail);

        return doctorRepository.save(optionalDoctor.get());
    }

    public List<String> getAgeMoreThan(int age) {

        List<Doctor> doctorList = doctorRepository.getAgeMoreThan(age);

        List<String> list = new ArrayList<>();

        for(Doctor doctor: doctorList){
            list.add(doctor.getName());
        }

        return list;
    }


    public List<DoctorResponseDTO> getAllDoctors() {
        List<Doctor> list = doctorRepository.findAll();

        List<DoctorResponseDTO> responseDTOList = new ArrayList<>();

        for(Doctor doc : list){
            responseDTOList.add(DoctorTransformer.DoctorResponseDTOFromDoctor(doc));
        }

        return responseDTOList;
    }
}
