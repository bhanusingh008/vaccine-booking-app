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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public AddPersonResponseDTO add_person(AddPersonRequestDTO requestDTO) {
        // create the person.

        Person person = new Person();
        person.setName(requestDTO.getName());
        person.setAge(requestDTO.getAge());
        person.setEmail(requestDTO.getEmail());
        person.setPhone(requestDTO.getPhone());
        person.setGender(requestDTO.getGender());

        Person added_person = personRepository.save(person);

        AddPersonResponseDTO responseDTO = new AddPersonResponseDTO();
        responseDTO.setId(added_person.getId());
        responseDTO.setName(added_person.getName());
        responseDTO.setEmail(added_person.getEmail());
        responseDTO.setPhone(added_person.getPhone());

        return responseDTO;
    }

    public GetDoseListResponseDTO doseTakenAlready(String email) {
        Person person = personRepository.findByEmail(email);

        if(person==null){
            throw new PersonNotFoundException("Email does not exist.");
        }

        GetDoseListResponseDTO responseDTO = new GetDoseListResponseDTO();
        responseDTO.setEmail(email);
        List<Dose> list = person.getDosesTaken();

        List<DoseName> newList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            newList.add(list.get(i).getDoseName());
        }

        responseDTO.setDoses(newList);

        return responseDTO;
    }

    public Person get_person(String email){
        return personRepository.findByEmail(email);
    }


    public Person updateEmail(String oldEmail, String newEmail) {
        Person person = personRepository.findByEmail(oldEmail);

        if(person==null){
            throw new PersonNotFoundException("Email does not exist.");
        }

        person.setEmail(newEmail);

        return personRepository.save(person);
    }
}
