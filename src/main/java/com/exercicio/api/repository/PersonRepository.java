package com.exercicio.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
    Optional<Person> findByUsername(String username);
    boolean existsByUsername(String username);
}
