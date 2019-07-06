package org.ss.nivantis.nivantisapirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.List;

@Repository
public interface AchatRepository extends CrudRepository<Achat, Long>{

    List<Achat> findAllByIdPharmacie(Pharmacie pharmacie);
}
