package com.exercicio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.api.dto.PersonDTO;
import com.exercicio.api.service.PersonService;

@RestController
@RequestMapping("/sign-up")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public void create(@RequestBody PersonDTO req){
        service.save(req);
    }
    
}
