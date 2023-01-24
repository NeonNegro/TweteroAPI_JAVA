package com.exercicio.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.api.dto.PersonDTO;
import com.exercicio.api.exception.PersonAlreadyExistsException;
import com.exercicio.api.exception.PersonNotFoundException;
import com.exercicio.api.model.Person;
import com.exercicio.api.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository repository;

    public void save(PersonDTO dto){

        if(repository.existsByUsername(dto.username()))
            throw new PersonAlreadyExistsException();

        repository.save(new Person(dto));
    }

    public Person getPersonByUsername(String username) {

        Optional<Person> person = repository.findByUsername(username);

        if(!person.isPresent())
            throw new PersonNotFoundException();
        
        return person.get();
    }
    
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
