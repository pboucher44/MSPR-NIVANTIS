package org.ss.nivantis.nivantisapirest.controller;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;


@RestController
public class HomeController {
    @Autowired
    PharmacieRepository pharmacieRepository;

    @GetMapping("/Marco")
    public String getMarco(){
        return "Polo";
    }

    @GetMapping("/Math/TauxDeRemise")
    public float getTauxDeRemise(@RequestParam("Net") float net, @RequestParam("Brut") float brut ){


        return ((1-net/brut)*100);
    }

    @GetMapping("/Math/PrixAchatNet")
    public float getPrixAchatNet(@RequestParam("Brut") float brut, @RequestParam("Taux") float taux ){
        return brut*(1-taux);
    }

    @GetMapping("/Math/PrixVentetNet")
    public float getPrixVentetNet(@RequestParam("Net") float net, @RequestParam("Coef") float coef ){
        return net*coef;
    }

    @GetMapping("/Math/CoefficientMultiplicateur")
    public float getCoefficientMultiplicateur(@RequestParam("Vente") float vente, @RequestParam("Achat") float achat ){
        return vente/achat;
    }

    @PostMapping("/Post")
    public ResponseEntity  createPharmacie(@RequestBody Pharmacie pharmacie)
    {

        pharmacieRepository.save(pharmacie);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/get/Pharmacie")
    public Collection<Pharmacie> findAllController()
    {
        return (Collection<Pharmacie>) pharmacieRepository.findAll();
    }

    @GetMapping("/get/PharmacieProche")
    public ArrayList findProche(
            @RequestParam("latitude") float latitude, @RequestParam("longitude") float longitude)
    {

        ArrayList arraylist = new ArrayList();
        arraylist.add(pharmacieRepository.findAll());
        JSONArray jsonarr_1 = new JSONArray(arraylist);
        return arraylist;
    }

    @GetMapping("/get/PharmacieId")
    public Optional<Pharmacie> findById(
            @RequestParam("Id") long id)
    {
        return pharmacieRepository.findById(id);
    }









}
