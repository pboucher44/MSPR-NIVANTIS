package org.ss.nivantis.nivantisapirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.ss.nivantis.nivantisapirest.model.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AchatController.class)
public class AchatControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AchatController service;

    @Test
    public void testCreateAchat() throws Exception {
        DMO monDmo = new DMO("BOUCHER","Pierre","pboucher","pboucher",new ArrayList<Achat>());
        Pharmacie maPharmacie = new Pharmacie("adresse",87,44444,"2.5","6.1","maPharmacie",new ArrayList<Achat>());
        maPharmacie.setId(0L);
        Client monClient = new Client("BOUCHER","Pierre","mail@mail.fr","0654478956",new ArrayList<Achat>());
        monClient.setId(0L);
        Produit monProduit = new Produit(5,"libelle",new ArrayList<Achat>());
        monProduit.setId(0L);
        Achat monAchatASave = new Achat(monDmo,maPharmacie,monClient,monProduit);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(monAchatASave);

        given(service.createAchat(monAchatASave)).willReturn(ResponseEntity.ok(HttpStatus.OK));

        ResponseEntity maReponse = service.createAchat(monAchatASave);
        Assert.assertEquals(maReponse,ResponseEntity.ok(HttpStatus.OK));

    }

    @Test
    public void testFindByIdAchat() throws Exception {
        DMO monDmo = new DMO("BOUCHER","Pierre","pboucher","pboucher",new ArrayList<Achat>());
        Pharmacie maPharmacie = new Pharmacie("adresse",87,44444,"2.5","6.1","maPharmacie",new ArrayList<Achat>());
        maPharmacie.setId(0L);
        Client monClient = new Client("BOUCHER","Pierre","mail@mail.fr","0654478956",new ArrayList<Achat>());
        monClient.setId(0L);
        Produit monProduit = new Produit(5,"libelle",new ArrayList<Achat>());
        monProduit.setId(0L);
        Achat monAchatASave = new Achat(monDmo,maPharmacie,monClient,monProduit);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(monAchatASave);

        given(service.createAchat(monAchatASave)).willReturn(ResponseEntity.ok(HttpStatus.OK));

        ResponseEntity maReponse = service.createAchat(monAchatASave);
        Assert.assertEquals(maReponse,ResponseEntity.ok(HttpStatus.OK));

        Achat achatReturned = monAchatASave;
        given(service.findById(monAchatASave.getId())).willReturn(java.util.Optional.ofNullable(achatReturned));

        Optional<Achat> monAchatRetourne = service.findById(monAchatASave.getId());
        Assert.assertEquals(monAchatRetourne,java.util.Optional.ofNullable(achatReturned));

    }

}
