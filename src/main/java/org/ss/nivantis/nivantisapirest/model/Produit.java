package org.ss.nivantis.nivantisapirest.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Produit {

    private @Id @GeneratedValue long id;
    private double prix;
    private String libelle;

    public Produit(double prix, String libelle) {
        this.prix = prix;
        this.libelle = libelle;
    }
}
