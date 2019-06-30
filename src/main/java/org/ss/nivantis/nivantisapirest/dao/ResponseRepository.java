package org.ss.nivantis.nivantisapirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.ss.nivantis.nivantisapirest.model.Response;

import java.util.List;

public interface ResponseRepository extends CrudRepository<Response, Long>{

     List<Response> findAllByIdDmo(Long Id);

}
