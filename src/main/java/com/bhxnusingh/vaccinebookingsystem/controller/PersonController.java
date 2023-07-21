package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.AddPersonRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.AddPersonResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.GetDoseListResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.Enum.DoseName;
import com.bhxnusingh.vaccinebookingsystem.model.Dose;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")

// www.vaccinelelo.com/person/dosename
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/add")
    public ResponseEntity add_person(@RequestBody AddPersonRequestDTO requestDTO){
        try{
            AddPersonResponseDTO personResponse = personService.add_person(requestDTO);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("bookingvaccine3@gmail.com");
            message.setTo(requestDTO.getEmail());
            message.setSubject("Account Created!");
            message.setText("Hello "+requestDTO.getName()+". Welcome to My Vaccination Booking System.");
            javaMailSender.send(message);

            return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Email Already Exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/doseName")
    public ResponseEntity doseTakenAlready(@RequestParam("email") String email){
        try{
            GetDoseListResponseDTO responseDTO = personService.doseTakenAlready(email);
            return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/updateEmail")
    public String updateEmail(@RequestParam("oldEmail") String oldEmail, @RequestParam("newEmail") String newEmail){
        try{
            Person person = personService.updateEmail(oldEmail, newEmail);

            return "Updated Email "+person.getEmail();
        }catch (Exception e){
            return "Person not signed up.";
        }
    }
}
