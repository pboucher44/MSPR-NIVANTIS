package org.ss.nivantis.nivantisapirest.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Produit {

    private @Id @GeneratedValue long id;
    private double prix;
    private String libelle;
    @OneToMany(targetEntity = Achat.class)
    private List<Achat> achats;

    public Produit(){

    }

    public Produit(double prix, String libelle, List<Achat> achats) {
        this.prix = prix;
        this.libelle = libelle;
        this.achats = achats;
    }
}
