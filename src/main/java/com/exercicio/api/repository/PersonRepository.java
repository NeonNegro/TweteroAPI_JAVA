package com.exercicio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
