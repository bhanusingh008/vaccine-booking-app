package com.bhxnusingh.vaccinebookingsystem.repository;

import com.bhxnusingh.vaccinebookingsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
