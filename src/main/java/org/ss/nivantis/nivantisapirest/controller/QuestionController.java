package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.QuestionRepository;
import org.ss.nivantis.nivantisapirest.model.Question;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("/NewQuestion")
    public ResponseEntity createQuestion(@RequestBody Question question) {
        questionRepository.save(question);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/GetQuestionFromUserId")
    public List<Question> getQuestion(@RequestParam("Id") long Id)
    {
        return questionRepository.findAllByIdDmo(Id);
    }

    @GetMapping("/GetQuestion")
    public Iterable<Question> getQuestion()
    {
        return questionRepository.findAll();
    }

}

