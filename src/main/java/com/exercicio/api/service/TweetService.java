package com.exercicio.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

        Person person = personService.getPersonByUsername(dto.username());

        repository.save(new Tweet(dto, person.getAvatar()));
    }

    public List<Tweet> findAll(){
        return repository.findAll(orderDescById());
    }

    public List<Tweet> findAllPaginated(int page, int size){
        if(page < 1 )
            page = 1;

        Pageable pageable = PageRequest.of((page-1), size, Sort.Direction.DESC, "id");
        return  repository.findAll(pageable).getContent();
    }

    public List<Tweet> findByUsername(String username){
        return repository.findAllByUsername(username, orderDescById());
    }

    private Sort orderDescById(){
        return Sort.by(Sort.Direction.DESC, "id");
    }
    

    // métodos: find, findById, save, update etc.., no qual estes chamariam o repository. 
}
