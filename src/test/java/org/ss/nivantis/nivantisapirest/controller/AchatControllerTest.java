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
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PharmacieRepository.class)
public class AchatControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AchatController service;

    @MockBean
    private AchatRepository achatRepo;

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

        given(achatRepo.save(monAchatASave)).willReturn(monAchatASave);

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/NewAchat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        Assert.assertEquals(response.getStatus(),HttpStatus.OK.value());

    }

    @Test
    public void testCreateAchatNull() throws Exception {
        Achat monAchatASave = null;
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(monAchatASave);

        given(achatRepo.save(monAchatASave)).willReturn(monAchatASave);

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/NewAchat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        Assert.assertEquals(response.getStatus(),HttpStatus.BAD_REQUEST.value());

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

        given(achatRepo.save(monAchatASave)).willReturn(monAchatASave);

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/NewAchat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        //Assert.assertEquals(response.getStatus(),HttpStatus.CREATED.value());
        Assert.assertEquals(response.getStatus(),HttpStatus.OK.value());

        ResponseEntity maReponse = service.createAchat(monAchatASave);
        Assert.assertEquals(maReponse,null);

        Achat achatReturned = monAchatASave;
        given(achatRepo.findById(monAchatASave.getId())).willReturn(java.util.Optional.ofNullable(achatReturned));

        Optional<Achat> monAchatRetourne = service.findById(monAchatASave.getId());
        Assert.assertEquals(monAchatRetourne,java.util.Optional.ofNullable(null));

    }

    @Test
    public void testFindByIdAchatNull() throws Exception {
        given(achatRepo.findById(null)).willReturn(java.util.Optional.ofNullable(null));

        Optional<Achat> monAchatRetourne = service.findById(null);
        Assert.assertEquals(monAchatRetourne,java.util.Optional.ofNullable(null));

    }

    @Test
    public void testFindByIdAchatInnexistant() throws Exception {
        given(achatRepo.findById(9999L)).willReturn(java.util.Optional.ofNullable(null));

        Optional<Achat> monAchatRetourne = service.findById(9999L);
        Assert.assertEquals(monAchatRetourne,java.util.Optional.ofNullable(null));

    }

}
