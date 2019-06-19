package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
