package org.ss.nivantis.nivantisapirest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Client {

    private @Id @GeneratedValue Long id;
    private String nom;
    private String prenom;
    private String mail;
    private String numeroTelephone;
    @OneToMany(targetEntity = Achat.class)
    private List<Achat> achats;

    public Client(){

    }

    public Client(String nom, String prenom, String mail, String numeroTelephone, List<Achat> achats) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numeroTelephone = numeroTelephone;
        this.achats = achats;
    }
}
