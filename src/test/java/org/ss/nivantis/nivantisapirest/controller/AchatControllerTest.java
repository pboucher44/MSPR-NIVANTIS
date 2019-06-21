package org.ss.nivantis.nivantisapirest.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.ss.nivantis.nivantisapirest.model.*;

public class AchatControllerTest {

    AchatController achatController = new AchatController();

    @Test
    public void testFindById() {
        DMO monDmo = new DMO("BOUCHER","Pierre","pboucher","pboucher",new ArrayList<Achat>());
        Pharmacie maPharmacie = new Pharmacie("adresse",87,44444,2.5f,6.1f,new ArrayList<Achat>());
        Client monClient = new Client("BOUCHER","Pierre","mail@mail.fr","0654478956",new ArrayList<Achat>());
        Produit monProduit = new Produit(5,"libelle",new ArrayList<Achat>());
        Achat monAchatASave = new Achat(monDmo,maPharmacie,monClient,monProduit);
        achatController.createAchat(monAchatASave);
        Optional<Achat> monAchat = achatController.findById(1L);
        assertNotNull(monAchat);
    }

}
