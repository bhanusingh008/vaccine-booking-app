package com.bhxnusingh.vaccinebookingsystem.repository;

import com.bhxnusingh.vaccinebookingsystem.model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Long> {
}
