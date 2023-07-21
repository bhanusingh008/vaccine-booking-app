package com.bhxnusingh.vaccinebookingsystem.controller;

import com.bhxnusingh.vaccinebookingsystem.DTO.RequestDTO.BookDoseRequestDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.BookDoseResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.DTO.ResponseDTO.GetDoseListResponseDTO;
import com.bhxnusingh.vaccinebookingsystem.Enum.DoseName;
import com.bhxnusingh.vaccinebookingsystem.exception.DoseAlreadyTaken;
import com.bhxnusingh.vaccinebookingsystem.exception.PersonNotFoundException;
import com.bhxnusingh.vaccinebookingsystem.model.Certificate;
import com.bhxnusingh.vaccinebookingsystem.model.Dose;
import com.bhxnusingh.vaccinebookingsystem.model.Person;
import com.bhxnusingh.vaccinebookingsystem.service.DoseService;
import com.bhxnusingh.vaccinebookingsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;
    @Autowired
    CertificateController certificateController;
    @Autowired
    PersonService personService;
    @Autowired
    JavaMailSender javaMailSender;


    @PostMapping("/get_dose1")
    public ResponseEntity getDose1(@RequestBody BookDoseRequestDTO bookDose1){
        String email = bookDose1.getEmail();
        DoseName doseName = bookDose1.getDoseName();

        try{
            BookDoseResponseDTO responseDTO = doseService.getDose1(email, doseName);
            // create a certificate
            Certificate certificate = certificateController.create_certificate(email);

            Person person = personService.get_person(email);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("bookingvaccine3@gmail.com");
            message.setTo(person.getEmail());
            message.setSubject("Dose 1 Taken!");
            message.setText("Hello "+person.getName()+". You have taken the Dose 1, And your certificate is generated " +
                    "with id "+certificate.getCertificateNo());
            javaMailSender.send(message);

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }catch (PersonNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (DoseAlreadyTaken e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>("Server Error.", HttpStatus.BAD_REQUEST);
        }
    }

    // lets not ask for different dose but same dose will be give.
    @PostMapping("/get_dose2")
    public ResponseEntity getDose2(@RequestParam("email") String email){
        try{
           GetDoseListResponseDTO responseDTO1 = personService.doseTakenAlready(email);

           List<DoseName> doses = responseDTO1.getDoses();

           if(doses.size()==2){
               return new ResponseEntity("Dose 2 already Taken", HttpStatus.BAD_REQUEST);
           }

           Person person = personService.get_person(email);

           long personId = person.getId();
           DoseName doseName = doses.get(0);

           BookDoseResponseDTO responseDTO = doseService.getDose2(personId, doseName);

           certificateController.secondDoseTaken(personId);

           return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }catch (PersonNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (DoseAlreadyTaken e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>("Server Error.", HttpStatus.BAD_REQUEST);
        }
    }
}
