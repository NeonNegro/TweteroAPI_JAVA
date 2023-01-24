package com.exercicio.api.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.api.dto.TweetDTO;
import com.exercicio.api.model.Person;
import com.exercicio.api.model.Tweet;
import com.exercicio.api.repository.TweetRepository;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;

    @Autowired
    private PersonService personService;

    public void save(TweetDTO dto){
        
        Person person = personService.getPersonByAvatar(dto.username());

        HashMap<String, String> tweet = new HashMap<>();

        tweet.put("text", dto.text());
        tweet.put("username", dto.username());
        tweet.put("avatar", person.getAvatar());

        repository.save(new Tweet(tweet));
    }

    public List<Tweet> findAll(){
        return repository.findAll();
    }
    

    // métodos: find, findById, save, update etc.., no qual estes chamariam o repository. 
}
