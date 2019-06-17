package org.ss.nivantis.nivantisapirest.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Pharmacie {

    private @Id @GeneratedValue Long id;
    private String  adresse;
    private int numero;
    private int codePostal;
    private float latitude;
    private float longitude;

    public Pharmacie() {
    }

    public Pharmacie(String adresse, int numero, int codePostal, float latitude, float longitude) {
        this.adresse = adresse;
        this.numero = numero;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
