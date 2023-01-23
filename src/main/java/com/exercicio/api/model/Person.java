package com.exercicio.api.model;

import com.exercicio.api.dto.PersonDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {

    public Person(PersonDTO data){
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String avatar;
}
