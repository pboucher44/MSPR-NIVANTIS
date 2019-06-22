package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.ss.nivantis.nivantisapirest.dao.ProduitRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.Produit;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProduitControllerTest {

    private ProduitController produitControllerUnderTest;

    @Before
    public void setUp() {
        produitControllerUnderTest = new ProduitController();
        produitControllerUnderTest.produitRepository = mock(ProduitRepository.class);
    }

    @Test
    public void testFindById() {
        // Setup
        final Long id = 0L;
        Produit monProduit = new Produit(5,"libelle",new ArrayList<Achat>());
        final Optional<Produit> expectedResult = Optional.of(monProduit);
        when(produitControllerUnderTest.produitRepository.findById(id)).thenReturn(Optional.of(monProduit));

        // Run the test
        final Optional<Produit> result = produitControllerUnderTest.findById(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCreateProduit() {
        // Setup
        final Produit produit = null;
        final ResponseEntity expectedResult = null;
        when(produitControllerUnderTest.produitRepository.save(null)).thenReturn(null);

        // Run the test
        final ResponseEntity result = produitControllerUnderTest.createProduit(produit);

        // Verify the results
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }
}
