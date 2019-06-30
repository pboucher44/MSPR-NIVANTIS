package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.ResponseRepository;
import org.ss.nivantis.nivantisapirest.model.Response;

import java.util.List;


@RestController
public class ResponseController {
    @Autowired
    ResponseRepository responseRepository;

    @PostMapping("/NewResponse")
    public ResponseEntity createResponse(@RequestBody Response response) {
        responseRepository.save(response);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/GetResponseFromUserId")
    public List<Response> getResponse(@RequestParam("Id") long Id)
    {
        return responseRepository.findAllByIdDmo(Id);
    }

    @GetMapping("/GetResponse")
    public Iterable<Response> getResponse()
    {
        return responseRepository.findAll();
    }
}
