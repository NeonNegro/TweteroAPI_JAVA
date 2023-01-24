package com.exercicio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.api.dto.PersonDTO;
import com.exercicio.api.exception.PersonAlreadyExistsException;
import com.exercicio.api.service.PersonService;

@RestController
@RequestMapping("/sign-up")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PersonDTO req){
        service.save(req);
        return ResponseEntity.ok("OK");
    }

    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<String> handlePersonAlreadyExistsException(PersonAlreadyExistsException ex) {
        return  new ResponseEntity<>("username already used", HttpStatus.CONFLICT);
    }
    
}
