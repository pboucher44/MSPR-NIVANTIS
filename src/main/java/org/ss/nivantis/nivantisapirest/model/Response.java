package org.ss.nivantis.nivantisapirest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Response {

    private @Id @GeneratedValue long id;
    @ManyToOne
    @JoinColumn(name="idDmo")
    private DMO idDmo;
    private String jsonReponse;
    @OneToMany(targetEntity = Question.class)
    private List<Question> questions;

}
