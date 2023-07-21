package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.BookDoseResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.Enum.DoseName;
import com.bhxnusingh.vaccinebookingsystem.exception.DoseAlreadyTaken;
import com.bhxnusingh.vaccinebookingsystem.exception.PersonNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Dose;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    PersonRepository personRepository;

    public BookDoseResponseDTO getDose1(String email, DoseName doseName){
        Optional<Person> optionalPerson = Optional.ofNullable(personRepository.findByEmail(email));

        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Invalid Email.");
        }

        Person person = optionalPerson.get();

        if(person.isDoseOneTaken()){
            throw new DoseAlreadyTaken("Dose 1 Already Taken");
        }

        // create a doss.
        Dose dose = new Dose();
        dose.setDoseName(doseName);
        dose.setDoseId(UUID.randomUUID().toString());
        dose.setPerson(person);

        // make the person dose1taken = true..
        person.setDoseOneTaken(true);
        person.getDosesTaken().add(dose);

        Person savedPerson = personRepository.save(person);

        BookDoseResponseDTO responseDTO = new BookDoseResponseDTO();

        responseDTO.setEmail(savedPerson.getEmail());

        return responseDTO;
    }

    public BookDoseResponseDTO getDose2(Long personId, DoseName doseName){
        Optional<Person> optionalPerson = personRepository.findById(personId);

        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Invalid PersonId");
        }

        Person person = optionalPerson.get();

        if(person.isDoseTwoTaken()){
            throw new DoseAlreadyTaken("Dose 2 Already Taken");
        }

        // create a doss.
        Dose dose = new Dose();
        dose.setDoseName(doseName);
        dose.setDoseId(UUID.randomUUID().toString());
        dose.setPerson(person);

        // make the person dose1taken = true..
        person.setDoseTwoTaken(true);
        person.getDosesTaken().add(dose);

        Person savedPerson = personRepository.save(person);

        BookDoseResponseDTO responseDTO = new BookDoseResponseDTO();

        responseDTO.setEmail(savedPerson.getEmail());
        responseDTO.setMessage("Dose two taken");

        return responseDTO;
    }
}
