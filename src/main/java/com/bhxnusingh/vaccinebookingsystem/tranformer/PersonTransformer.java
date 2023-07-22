package com.bhxnusingh.vaccinebookingsystem.tranformer;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddPersonRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddPersonResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.model.Person;

public class PersonTransformer {

    public static Person personFromAddPersonRequestDTO(AddPersonRequestDTO requestDTO){

        Person person = new Person();
        person.setName(requestDTO.getName());
        person.setAge(requestDTO.getAge());
        person.setEmail(requestDTO.getEmail());
        person.setPhone(requestDTO.getPhone());
        person.setGender(requestDTO.getGender());

        return person;
    }

    public static AddPersonResponseDTO AddPersonResponseDTOFromPerson(Person person){
        AddPersonResponseDTO responseDTO = new AddPersonResponseDTO();
        responseDTO.setId(person.getId());
        responseDTO.setName(person.getName());
        responseDTO.setEmail(person.getEmail());
        responseDTO.setPhone(person.getPhone());

        return responseDTO;
    }
}
