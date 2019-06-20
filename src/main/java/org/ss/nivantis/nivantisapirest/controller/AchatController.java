package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;

import java.util.Optional;

@RestController
public class AchatController {
    @Autowired
    AchatRepository achatRepository;

    @GetMapping("/get/AchatById")
    public Optional<Achat> findById(@RequestParam("Id") Long id) {
        return achatRepository.findById(id);
    }

    @PostMapping("/NewAchat")
    public ResponseEntity createAchat(@RequestBody Achat achat) {
        achatRepository.save(achat);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}

