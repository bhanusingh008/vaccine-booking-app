package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AppointmentRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AppointmentResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.exception.DoctorNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.exception.PersonNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Appointment;
import com.bhxnusingh.vaccinebookingsystem.model.Doctor;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.model.VaccinationCenter;
import com.bhxnusingh.vaccinebookingsystem.repository.AppointmentRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.DoctorRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.VaccinationCenterRepository;
import com.bhxnusingh.vaccinebookingsystem.tranformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository centerRepository;

    public AppointmentResponseDTO create_appointment(AppointmentRequestDTO requestDTO) {
        Optional<Person> optionalPerson = personRepository.findByEmail(requestDTO.getPersonEmail());
        Optional<Doctor> optionalDoctor = doctorRepository.findByEmail(requestDTO.getDoctorEmail());

        if(optionalPerson.isEmpty()){
            throw  new PersonNotFoundException("Person not registered.");
        }

        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Doctor not registered.");
        }

        Appointment appointment = AppointmentTransformer.AddAppointmentRequestToAppointment(requestDTO);

        appointment.setDoctor(optionalDoctor.get());
        appointment.setPerson(optionalPerson.get());

        Optional<VaccinationCenter> optionalVaccinationCenter = centerRepository.findById(requestDTO.getCenterId());

        if(optionalVaccinationCenter.isEmpty()){
            throw new RuntimeException("Center Not Available");
        }
        appointment.setCenter(optionalVaccinationCenter.get());

        optionalDoctor.get().getAppointmentList().add(appointment);
        optionalPerson.get().getAppointmentList().add(appointment);

        appointment.setAppointmentId(UUID.randomUUID().toString());

        Appointment saved_appointment =  appointmentRepository.save(appointment);

        return AppointmentTransformer.AppointmentToAppointmentResponse(saved_appointment);
    }

    public List<AppointmentResponseDTO> getAppointmentsOfDoctor(String email) {

        Optional<Doctor> optionalDoctor = doctorRepository.findByEmail(email);

        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Doctor not registered.");
        }

        List<Appointment> appointmentList = optionalDoctor.get().getAppointmentList();

        List<AppointmentResponseDTO> responseDTOList = new ArrayList<>();

        for(Appointment app : appointmentList){
            responseDTOList.add(AppointmentTransformer.AppointmentToAppointmentResponse(app));
        }

        return responseDTOList;
    }

    public List<AppointmentResponseDTO> getAppointmentsOfPerson(String email) {
        Optional<Person> optionalPerson = personRepository.findByEmail(email);

        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Person not registered.");
        }

        List<Appointment> appointmentList = optionalPerson.get().getAppointmentList();

        List<AppointmentResponseDTO> responseDTOList = new ArrayList<>();

        for(Appointment app : appointmentList){
            responseDTOList.add(AppointmentTransformer.AppointmentToAppointmentResponse(app));
        }
        return responseDTOList;
    }
}
