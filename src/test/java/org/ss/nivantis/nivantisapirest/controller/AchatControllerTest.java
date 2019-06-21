package org.ss.nivantis.nivantisapirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.ss.nivantis.nivantisapirest.model.*;

import java.util.ArrayList;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Optional;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        Pharmacie maPharmacie = new Pharmacie("adresse",87,44444,"2.5","6.1",new ArrayList<Achat>());
        maPharmacie.setId(0L);
        Client monClient = new Client("BOUCHER","Pierre","mail@mail.fr","0654478956",new ArrayList<Achat>());
        monClient.setId(0L);
        Produit monProduit = new Produit(5,"libelle",new ArrayList<Achat>());
        monProduit.setId(0L);
        Achat monAchatASave = new Achat(monDmo,maPharmacie,monClient,monProduit);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(monAchatASave);

        given(service.createAchat(monAchatASave)).willReturn(ResponseEntity.ok(HttpStatus.OK));

        mvc.perform(post("/NewAchat")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testFindByIdAchat() throws Exception {
        DMO monDmo = new DMO("BOUCHER","Pierre","pboucher","pboucher",new ArrayList<Achat>());
        Pharmacie maPharmacie = new Pharmacie("adresse",87,44444,"2.5","6.1",new ArrayList<Achat>());
        maPharmacie.setId(0L);
        Client monClient = new Client("BOUCHER","Pierre","mail@mail.fr","0654478956",new ArrayList<Achat>());
        monClient.setId(0L);
        Produit monProduit = new Produit(5,"libelle",new ArrayList<Achat>());
        monProduit.setId(0L);
        Achat monAchatASave = new Achat(monDmo,maPharmacie,monClient,monProduit);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(monAchatASave);

        given(service.createAchat(monAchatASave)).willReturn(ResponseEntity.ok(HttpStatus.OK));

        mvc.perform(post("/NewAchat")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        Achat achatReturned = monAchatASave;
        given(service.findById(monAchatASave.getId())).willReturn(java.util.Optional.ofNullable(achatReturned));

        mvc.perform(get("/get/AchatById")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

}
