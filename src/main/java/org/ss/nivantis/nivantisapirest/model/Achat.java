package org.ss.nivantis.nivantisapirest.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Achat {

    private @Id @GeneratedValue long id;
    @ManyToOne @JoinColumn(name="idDMO")
    private DMO idDMO;
    @ManyToOne @JoinColumn(name="idPharmacie")
    private Pharmacie idPharmacie;
    @ManyToOne @JoinColumn(name="idClient")
    private Client idClient;

    public Achat(DMO idDMO, Pharmacie idPharmacie, Client idClient) {
        this.idDMO = idDMO;
        this.idPharmacie = idPharmacie;
        this.idClient = idClient;
    }
}
