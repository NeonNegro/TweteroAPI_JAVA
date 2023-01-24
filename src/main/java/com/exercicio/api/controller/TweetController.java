package com.exercicio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.api.dto.TweetDTO;
import com.exercicio.api.model.Tweet;
import com.exercicio.api.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @GetMapping
    public List<Tweet> listAll(){
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody TweetDTO req){
        service.save(req);
    }
    
}
