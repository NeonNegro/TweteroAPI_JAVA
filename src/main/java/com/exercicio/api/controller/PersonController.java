package com.exercicio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.api.dto.PersonDTO;
import com.exercicio.api.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public String ola(){
        return "olá!";
    }
    @PostMapping
    public void create(@RequestBody PersonDTO req){
        service.save(req);
    }
    
}
