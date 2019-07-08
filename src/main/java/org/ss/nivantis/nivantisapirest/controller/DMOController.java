package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.DMORepository;
import org.ss.nivantis.nivantisapirest.model.DMO;

import java.util.Optional;

@RestController
public class DMOController {
    @Autowired
    DMORepository dmoRepository;

    @GetMapping("/get/DMOById")
    public Optional<DMO> findById(@RequestParam("Id") Long id) {
        return dmoRepository.findById(id);
    }

    @PostMapping("/NewDMO")
    public ResponseEntity createDMO(@RequestBody DMO dmo) {
        dmoRepository.save(dmo);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
