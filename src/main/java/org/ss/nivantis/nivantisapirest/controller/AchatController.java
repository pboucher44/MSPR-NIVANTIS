package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.List;
import java.util.Optional;

@RestController
public class AchatController {
    @Autowired
    AchatRepository achatRepository;
    @Autowired
    PharmacieRepository pharmacieRepository;

    @GetMapping("/get/AchatById")
    public Optional<Achat> findById(@RequestParam("Id") Long id) {
        return achatRepository.findById(id);
    }

    @GetMapping("get/AllAchats")
    public Iterable<Achat> findAll()
    {
        return achatRepository.findAll();
    }

    @GetMapping("get/AllAchatsbyPharmacie")
    public List<Achat> findAllByPharma(@RequestParam("Pharmacie")long pharmacie)
    {
        pharmacieRepository.findPharmacieById(pharmacie);
        return achatRepository.findAllByIdPharmacie(pharmacieRepository.findPharmacieById(pharmacie));
    }

    @PostMapping("/NewAchat")
    public ResponseEntity createAchat(@RequestBody Achat achat) {
        achatRepository.save(achat);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}

