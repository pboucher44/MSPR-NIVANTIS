package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.Service.PharmacieService;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.dao.ProduitRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.*;

@RestController
public class PharmacieController {
    @Autowired
    PharmacieRepository pharmacieRepository;
    @Autowired
    AchatRepository achatRepository;
    @Autowired
    ProduitRepository produitRepository;
    PharmacieService pharmacieService;

    @GetMapping("/get/Pharmacie")
    public Collection<Pharmacie> findAllController()
    {
        return (Collection<Pharmacie>) pharmacieRepository.findAll();
    }

    @GetMapping("/get/PharmacieProche")
    public String findProche(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude)
    {

        return pharmacieService.GetProche(latitude,longitude);
    }

    @GetMapping("/get/PharmacieId")
    public Optional<Pharmacie> findById(@RequestParam("Id") Long id) {
        return pharmacieRepository.findById(id);
    }

    @GetMapping("/get/PharmaciePosition")
    public Optional<Pharmacie> findPositionOfPhamarcie(@RequestParam("id") Long id){
        return pharmacieRepository.findById(id);
    }

    @PostMapping("/Post")
    public ResponseEntity  createPharmacie(@RequestBody Pharmacie pharmacie) {
        pharmacieRepository.save(pharmacie);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
