package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddPersonRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddPersonResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.exception.PersonNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/add")
    public ResponseEntity add_person(@RequestBody AddPersonRequestDTO requestDTO){
        try{
            AddPersonResponseDTO personResponse = personService.add_person(requestDTO);

            // sending mail
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("bookingvaccine3@gmail.com");
            message.setTo(requestDTO.getEmail());
            message.setSubject("Account Created!");
            message.setText("Hello "+requestDTO.getName()+". Welcome to My Vaccination Booking System.");
            javaMailSender.send(message);
            // done sending

            return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Email Already Exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateEmail")
    public String updateEmail(@RequestParam("oldEmail") String oldEmail, @RequestParam("newEmail") String newEmail){
        try{
            Person person = personService.updateEmail(oldEmail, newEmail);
            return "Updated Email "+person.getEmail()+" for "+person.getName();
        }catch (PersonNotFoundException personNotFoundException){
            return "User Not Found";
        }
    }
}
