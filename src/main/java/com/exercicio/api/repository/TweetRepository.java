package com.exercicio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    
}
