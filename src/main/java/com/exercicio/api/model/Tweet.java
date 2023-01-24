package com.exercicio.api.model;

import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(Map<String, String> data){
        this.username = data.get("username");
        this.avatar = data.get("avatar");
        this.text = data.get("text");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String text;
    @Column(length = 200, nullable = false)
    private String avatar;
}
