package com.bhxnusingh.vaccinebookingsystem.repository;

import com.bhxnusingh.vaccinebookingsystem.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
