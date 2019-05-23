package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

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

    @RequestMapping("/Insert/Pharmacie")
    public void createPharmacie(@RequestParam("Adresse") String adresse,
                                @RequestParam("Numero") int numero,
                                @RequestParam("CodePostal") int cp,
                                @RequestParam("Latitude") double latitude,
                                @RequestParam("Longitude") double longitude){
        pharmacieRepository.save(new Pharmacie(adresse, numero, cp, latitude, longitude));
    }
}
