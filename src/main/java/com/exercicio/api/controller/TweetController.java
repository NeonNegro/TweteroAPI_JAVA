package com.exercicio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Tweet>> listAllPaginated(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size
    ) {

        List<Tweet> response = service.findAllPaginated(PageRequest.of((page-1), size, Sort.Direction.DESC, "id"));

        return ResponseEntity.ok(response);
    }



    @PostMapping
    public void create(@RequestBody TweetDTO req){
        service.save(req);
    }
    
}
