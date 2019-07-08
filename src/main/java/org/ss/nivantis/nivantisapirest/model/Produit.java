package org.ss.nivantis.nivantisapirest.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Produit {

    private @Id @GeneratedValue long id;
    private String prix;
    private String libelle;
    @OneToMany(targetEntity = Achat.class)
    private List<Achat> achats;

    public Produit(){

    }


    public Produit(String prix, String libelle, List<Achat> achats) {
        this.prix = prix;
        this.libelle = libelle;
        this.achats = achats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }
}
