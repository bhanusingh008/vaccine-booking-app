package com.bhxnusingh.vaccinebookingsystem.repository;

import com.bhxnusingh.vaccinebookingsystem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String oldEmail);
}
