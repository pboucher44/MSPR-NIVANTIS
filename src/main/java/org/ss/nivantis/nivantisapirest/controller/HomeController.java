package org.ss.nivantis.nivantisapirest.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.dao.ProduitRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.*;


@RestController
public class HomeController {
    @Autowired
    PharmacieRepository pharmacieRepository;
    @Autowired
    AchatRepository achatRepository;
    @Autowired
    ProduitRepository produitRepository;


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

}
