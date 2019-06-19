package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ss.nivantis.nivantisapirest.model.Client;
import org.ss.nivantis.nivantisapirest.model.Produit;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    ClientController clientRepository;

    @GetMapping("/get/ClientById")
    public Optional<Client> findById(@RequestParam("Id") Long id) {
        return clientRepository.findById(id);
    }
}
