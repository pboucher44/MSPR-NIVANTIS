package org.ss.nivantis.nivantisapirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.ss.nivantis.nivantisapirest.model.DMO;

public interface DMORepository extends CrudRepository<DMO, Long>{

    @Override
    <S extends DMO> S save(S s);

}
