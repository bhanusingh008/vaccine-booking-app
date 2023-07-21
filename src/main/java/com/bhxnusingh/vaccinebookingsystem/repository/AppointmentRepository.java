package com.bhxnusingh.vaccinebookingsystem.repository;

import com.bhxnusingh.vaccinebookingsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
