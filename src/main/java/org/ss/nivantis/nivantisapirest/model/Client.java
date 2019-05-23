package org.ss.nivantis.nivantisapirest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Client {

    private @Id @GeneratedValue Long id;
    private String nom;
    private String prenom;
    private String mail;
    private String numeroTelephone;

    public Client(String nom, String prenom, String mail, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numeroTelephone = numeroTelephone;
    }
}
