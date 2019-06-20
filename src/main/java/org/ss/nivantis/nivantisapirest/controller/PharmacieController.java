package org.ss.nivantis.nivantisapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/get/Pharmacie")
    public Collection<Pharmacie> findAllController()
    {
        return (Collection<Pharmacie>) pharmacieRepository.findAll();
    }

    @GetMapping("/get/PharmacieProche")
    public String findProche(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude)
    {


        SortedMap<Double,Long> sm =
                new TreeMap<Double,Long>();

        for(int i=0;i<pharmacieRepository.findAll().size(); i++) {
            Pharmacie pharmacie = pharmacieRepository.findAll().get(i);
            sm.put(Pharmacie.distance(Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(pharmacie.getLatitude()),
                    Double.parseDouble(pharmacie.getLongitude())),pharmacie.getId());
        }
        Set s = sm.entrySet();
        Iterator i = s.iterator();
        while (i.hasNext())
        {
            Map.Entry m = (Map.Entry)i.next();

            double key = (double)m.getKey();
            long value = (long)m.getValue();
        }
        Object[] test = sm.keySet().toArray();

        Object keyfinal  = sm.keySet().toArray()[0];
        Pharmacie proche = pharmacieRepository.findPharmacieById(sm.get(keyfinal));
        String sortie = "?pos="+proche.getLongitude()+","+proche.getLatitude()+"?distance="+test[0].toString();
        return sortie;
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
