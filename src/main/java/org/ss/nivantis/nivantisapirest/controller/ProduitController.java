package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ss.nivantis.nivantisapirest.dao.ProduitRepository;
import org.ss.nivantis.nivantisapirest.model.Produit;

import java.util.Optional;

@RestController
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;

    @GetMapping("/get/ProduitById")
    public Optional<Produit> findById(@RequestParam("Id") Long id) {
        return produitRepository.findById(id);
    }
}
