package com.exercicio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.api.dto.PersonDTO;
import com.exercicio.api.model.Person;
import com.exercicio.api.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository repository;

    public void save(PersonDTO dto){
        repository.save(new Person(dto));
    }
    

    // métodos: find, findById, save, update etc.., no qual estes chamariam o repository. 
}
