package org.ss.nivantis.nivantisapirest.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class DMO {

    private @Id @GeneratedValue Long id;
    private String nom;
    private String prenom;
    private String login;
    private String password;

    public DMO(String nom, String prenom, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }
}
