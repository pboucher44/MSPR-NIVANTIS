package org.ss.nivantis.nivantisapirest.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Question {

    private @Id
    @GeneratedValue
    long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idDmo")
    private DMO idDmo;
    private String jsonQuestion;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idResponse")
    private Response idResponses;


    public Question() {
    }

    public Question(DMO idDmo,String jsonQuestion,Response idResponses){
        this.idDmo = idDmo;
        this.jsonQuestion = jsonQuestion;
        this.idResponses = idResponses;

    }
}