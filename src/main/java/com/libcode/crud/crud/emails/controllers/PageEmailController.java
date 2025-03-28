package com.libcode.crud.crud.emails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.libcode.crud.crud.emails.entities.Email;
import com.libcode.crud.crud.emails.repository.EmailRepository;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class PageEmailController {

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping("/test/{email}")
public ResponseEntity<Email> comprobarEmail(@PathVariable String email) {
    Random random = new Random();
    Email emailToSave = new Email(email, random.nextBoolean());

    // Guardar el objeto en la base de datos
    Email savedEmail = this.emailRepository.save(emailToSave);

    // Mensaje de depuración en la consola
    System.out.println("Email guardado: " + savedEmail);

    // Retornar el objeto guardado con un código HTTP 200 (OK)
    return ResponseEntity.ok(savedEmail);
}
    
}
