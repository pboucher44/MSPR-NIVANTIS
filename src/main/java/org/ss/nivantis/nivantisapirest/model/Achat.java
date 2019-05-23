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

    public Achat(DMO idDmo, Pharmacie idPharmacie, Client idClient, Produit produit) {
        this.idDmo = idDmo;
        this.idPharmacie = idPharmacie;
        this.idClient = idClient;
        this.produit = produit;
    }
}
