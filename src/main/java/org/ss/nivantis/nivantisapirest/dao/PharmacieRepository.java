package org.ss.nivantis.nivantisapirest.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import javax.transaction.Transactional;
import java.util.List;

public interface PharmacieRepository extends CrudRepository<Pharmacie, Long> {

    List<Pharmacie> findAll();





}
