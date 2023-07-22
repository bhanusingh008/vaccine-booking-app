package com.bhxnusingh.vaccinebookingsystem.service;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddPersonRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddPersonResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.GetDoseListResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.Enum.DoseName;
import com.bhxnusingh.vaccinebookingsystem.exception.NoDoseTaken;
import com.bhxnusingh.vaccinebookingsystem.exception.PersonNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Dose;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.repository.PersonRepository;
import com.bhxnusingh.vaccinebookingsystem.tranformer.PersonTransformer;
import nonapi.io.github.classgraph.utils.VersionFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person get_person(String email){
        Optional<Person> optionalPerson =personRepository.findByEmail(email);

        if(optionalPerson.isEmpty()) throw new PersonNotFoundException("Email not registered.");

        return optionalPerson.get();
    }

    public AddPersonResponseDTO add_person(AddPersonRequestDTO requestDTO) {
        // create the person.

        Person person = PersonTransformer.personFromAddPersonRequestDTO(requestDTO);

        Person added_person = personRepository.save(person);

        return PersonTransformer.AddPersonResponseDTOFromPerson(added_person);
    }


    public Person updateEmail(String oldEmail, String newEmail) {

        Optional<Person> optionalPerson = personRepository.findByEmail(oldEmail);

        if(optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Email does not exist.");
        }

        optionalPerson.get().setEmail(newEmail);

        return personRepository.save(optionalPerson.get());
    }
}
