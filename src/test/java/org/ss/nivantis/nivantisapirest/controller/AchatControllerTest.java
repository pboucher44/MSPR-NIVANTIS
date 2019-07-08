package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AchatControllerTest {

    private AchatController achatControllerUnderTest;

    @Before
    public void setUp() {
        achatControllerUnderTest = new AchatController();
        achatControllerUnderTest.achatRepository = mock(AchatRepository.class);
    }

    @Test
    public void testFindById() {
        // Setup
        final Long id = 0L;
        final Optional<Achat> expectedResult = null;
        DMO monDmo = new DMO("BOUCHER","Pierre","pboucher","pboucher",new ArrayList<Achat>());
        Pharmacie maPharmacie = new Pharmacie("adresse","87","44444","2.5","6.1","maPharmacie",new ArrayList<Achat>());
        maPharmacie.setId(0L);
        Client monClient = new Client("BOUCHER","Pierre","mail@mail.fr","0654478956",new ArrayList<Achat>());
        monClient.setId(0L);
        Produit monProduit = new Produit("5","libelle",new ArrayList<Achat>());
        monProduit.setId(0L);
        Achat monAchatASave = new Achat(monDmo,maPharmacie,monClient,monProduit);

        when(achatControllerUnderTest.achatRepository.findById(0L)).thenReturn(Optional.of(monAchatASave));

        // Run the test
        final Optional<Achat> result = achatControllerUnderTest.findById(id);

        // Verify the results
        assertEquals(Optional.of(monAchatASave), result);
    }

    @Test
    public void testFindAll() {
        // Setup
        final Iterable<Achat> expectedResult = null;
        when(achatControllerUnderTest.achatRepository.findAll()).thenReturn(null);

        // Run the test
        final Iterable<Achat> result = achatControllerUnderTest.findAll();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCreateAchat() {
        // Setup
        final Achat achat = null;
        final ResponseEntity expectedResult = null;
        when(achatControllerUnderTest.achatRepository.save(null)).thenReturn(null);

        // Run the test
        final ResponseEntity result = achatControllerUnderTest.createAchat(achat);

        // Verify the results
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }
}
