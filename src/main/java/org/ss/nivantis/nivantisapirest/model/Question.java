package org.ss.nivantis.nivantisapirest.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Question {

    private @Id @GeneratedValue long id;
    @ManyToOne @JoinColumn(name="idDmo")
    private DMO idDmo;
    private String jsonQuestion;
    @ManyToOne
    @JoinColumn(name="idResponse")
    private Response idResponses;

}
