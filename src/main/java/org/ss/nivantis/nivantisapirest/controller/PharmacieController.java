package org.ss.nivantis.nivantisapirest.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.dao.ProduitRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
public class PharmacieController {
    @Autowired
    PharmacieRepository pharmacieRepository;
    @Autowired
    AchatRepository achatRepository;
    @Autowired
    ProduitRepository produitRepository;

    @GetMapping("/get/Pharmacie")
    public Collection<Pharmacie> findAllController()
    {
        return (Collection<Pharmacie>) pharmacieRepository.findAll();
    }

    @GetMapping("/get/PharmacieProche")
    public ArrayList findProche(@RequestParam("latitude") float latitude, @RequestParam("longitude") float longitude) {
        ArrayList arraylist = new ArrayList();
        arraylist.add(pharmacieRepository.findAll());
        JSONArray jsonarr_1 = new JSONArray(arraylist);
        return arraylist;
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
