package com.bhxnusingh.vaccinebookingsystem.tranformer;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddAppointmentRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddAppointmentResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.Appointment;
import com.bhxnusingh.vaccinebookingsystem.model.Doctor;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.repository.DoctorRepository;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class AppointmentTransformer {

    public static AddAppointmentResponseDTO AppointmentToAppointmentResponse(Appointment appointment){
        AddAppointmentResponseDTO responseDTO = AddAppointmentResponseDTO.builder()
                .date(appointment.getAppointmentDate())
                .personName(appointment.getPerson().getName())
                .doctorName(appointment.getDoctor().getName())
                .appointmentId(UUID.randomUUID().toString())
                .build();

        return responseDTO;
    }
    public static Appointment AddAppointmentRequestToAppointment(AddAppointmentRequestDTO requestDTO){
        Appointment appointment = Appointment.builder()
                .appointmentDate(requestDTO.getDate())
                .appointmentId(UUID.randomUUID().toString())
                .build();

        return appointment;
    }
}
