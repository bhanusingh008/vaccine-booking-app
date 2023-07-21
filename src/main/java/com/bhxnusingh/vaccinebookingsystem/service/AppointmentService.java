package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddAppointmentRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddAppointmentResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddPersonResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.Appointment;
import com.bhxnusingh.vaccinebookingsystem.model.Doctor;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.repository.AppointmentRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.DoctorRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import com.bhxnusingh.vaccinebookingsystem.tranformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public AddAppointmentResponseDTO create_appointment(AddAppointmentRequestDTO requestDTO) {
        Person person = personRepository.getReferenceById(requestDTO.getPersonId());
        Doctor doctor = doctorRepository.getReferenceById(requestDTO.getDoctorId());

        Appointment appointment = AppointmentTransformer.AddAppointmentRequestToAppointment(requestDTO);

        appointment.setDoctor(doctor);
        appointment.setPerson(person);

        Appointment saved_appointment =  appointmentRepository.save(appointment);

        AddAppointmentResponseDTO responseDTO = AppointmentTransformer.AppointmentToAppointmentResponse(saved_appointment);

        return responseDTO;
    }
}
