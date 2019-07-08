package org.ss.nivantis.nivantisapirest.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Pharmacie {

    private @Id @GeneratedValue Long id;
    private String  adresse;
    private String numero;
    private String codePostal;
    private String latitude;
    private String longitude;
    private String libelle;
    @OneToMany(targetEntity = Achat.class)
    private List<Achat> achats;

    public Pharmacie(){

    }

    public Pharmacie(String adresse, String numero, String codePostal, String latitude, String longitude, String libelle, List<Achat> achats) {
        this.adresse = adresse;
        this.numero = numero;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.achats = achats;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
