package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.Collection;

@RestController
public class HomeController {
    @Autowired
    PharmacieRepository pharmacieRepository;

    @RequestMapping("/Marco")
    public String getMarco(){
        return "Polo";
    }

    @RequestMapping("/Math/TauxDeRemise")
    public float getTauxDeRemise(@RequestParam("Net") float net, @RequestParam("Brut") float brut ){
        return ((1-net/brut)*100);
    }

    @RequestMapping("/Math/PrixAchatNet")
    public float getPrixAchatNet(@RequestParam("Brut") float brut, @RequestParam("Taux") float taux ){
        return brut*(1-taux);
    }

    @RequestMapping("/Math/PrixVentetNet")
    public float getPrixVentetNet(@RequestParam("Net") float net, @RequestParam("Coef") float coef ){
        return net*coef;
    }

    @RequestMapping("/Math/CoefficientMultiplicateur")
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









}
