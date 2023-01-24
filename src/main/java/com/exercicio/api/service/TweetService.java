package com.exercicio.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exercicio.api.dto.TweetDTO;
import com.exercicio.api.model.Tweet;
import com.exercicio.api.repository.TweetRepository;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;

    @Autowired
    private PersonService personService;

    public void save(TweetDTO dto){
        
        String avatar = personService.getPersonAvatar(dto.username());

        repository.save(new Tweet(dto, avatar));
    }

    public List<Tweet> findAll(){
        return repository.findAll();
    }

    public List<Tweet> findAllPaginated(Pageable pageable) {
        return  repository.findAll(pageable).getContent();
    }
    

    // métodos: find, findById, save, update etc.., no qual estes chamariam o repository. 
}
