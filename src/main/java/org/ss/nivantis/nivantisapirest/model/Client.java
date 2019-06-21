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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }
}
