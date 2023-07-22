package com.bhxnusingh.vaccinebookingsystem.tranformer;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AppointmentRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AppointmentResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.Appointment;

import java.util.UUID;

public class AppointmentTransformer {

    public static AppointmentResponseDTO AppointmentToAppointmentResponse(Appointment appointment){
        AppointmentResponseDTO responseDTO = AppointmentResponseDTO.builder()
                .date(appointment.getAppointmentDate())
                .personName(appointment.getPerson().getName())
                .doctorName(appointment.getDoctor().getName())
                .appointmentId(UUID.randomUUID().toString())
                .build();

        return responseDTO;
    }
    public static Appointment AddAppointmentRequestToAppointment(AppointmentRequestDTO requestDTO){
        Appointment appointment = Appointment.builder()
                .appointmentDate(requestDTO.getDate())
                .appointmentId(UUID.randomUUID().toString())
                .build();

        return appointment;
    }
}
