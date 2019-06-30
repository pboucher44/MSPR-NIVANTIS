package org.ss.nivantis.nivantisapirest.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Achat {

    private @Id @GeneratedValue long id;
    @ManyToOne @JoinColumn(name="idDmo")
    private DMO idDmo;
    @ManyToOne @JoinColumn(name="idPharmacie")
    private Pharmacie idPharmacie;
    @ManyToOne @JoinColumn(name="idClient")
    private Client idClient;
    @ManyToOne @JoinColumn(name="idProduit")
    private Produit produit;

    public Achat(){

    }

    public Achat(DMO idDmo, Pharmacie idPharmacie, Client idClient, Produit produit) {
        this.idDmo = idDmo;
        this.idPharmacie = idPharmacie;
        this.idClient = idClient;
        this.produit = produit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DMO getIdDmo() {
        return idDmo;
    }

    public void setIdDmo(DMO idDmo) {
        this.idDmo = idDmo;
    }

    public Pharmacie getIdPharmacie() {
        return idPharmacie;
    }

    public void setIdPharmacie(Pharmacie idPharmacie) {
        this.idPharmacie = idPharmacie;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
