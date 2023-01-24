package com.exercicio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.api.dto.TweetDTO;
import com.exercicio.api.exception.PersonNotFoundException;
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

        List<Tweet> response = service.findAllPaginated(page, size);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweet>> listByUsername(@PathVariable String username) {

        List<Tweet> response = service.findByUsername(username);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TweetDTO req){
        service.save(req);
        return ResponseEntity.ok("OK");
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException ex) {
        return  new ResponseEntity<>("username does not exists",HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
}
