package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.ClientRepository;
import org.ss.nivantis.nivantisapirest.model.Client;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/get/ClientById")
    public Optional<Client> findById(@RequestParam("Id") Long id) {
        return clientRepository.findById(id);
    }


    @GetMapping("/get/AllClients")
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @PostMapping("/NewClient")
    public ResponseEntity createClient(@RequestBody Client client) {
        clientRepository.save(client);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
