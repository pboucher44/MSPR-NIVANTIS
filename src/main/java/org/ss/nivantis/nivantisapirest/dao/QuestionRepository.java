package org.ss.nivantis.nivantisapirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.ss.nivantis.nivantisapirest.model.Question;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long>{

    List<Question> findAllByIdDmo(Long Id);

}
