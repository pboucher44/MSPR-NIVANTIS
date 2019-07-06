package org.ss.nivantis.nivantisapirest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Response {

    private @Id @GeneratedValue long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idDmo")
    private DMO idDmo;
    private String jsonResponse;
    @OneToMany(targetEntity = Question.class)
    private List<Question> questions;

public Response(){}

    public Response(DMO idDmo,String jsonResponse,List<Question> questions){
        this.idDmo = idDmo;
        this.jsonResponse = jsonResponse;
        this.questions = questions;

    }
}
