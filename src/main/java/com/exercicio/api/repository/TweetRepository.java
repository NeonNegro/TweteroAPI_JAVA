package com.exercicio.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.api.model.Tweet;


public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Page<Tweet> findAll(Pageable page);
    List<Tweet> findAllByUsername(String username, Sort sort);
}
