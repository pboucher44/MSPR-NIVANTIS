package org.ss.nivantis.nivantisapirest.dao;


import org.springframework.data.repository.CrudRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;


import java.util.List;

public interface PharmacieRepository extends CrudRepository<Pharmacie, Long> {

    List<Pharmacie> findAll();
    Pharmacie findPharmacieById(Long id);
    Pharmacie findPharmacieByLibelle(String libelle);




}
