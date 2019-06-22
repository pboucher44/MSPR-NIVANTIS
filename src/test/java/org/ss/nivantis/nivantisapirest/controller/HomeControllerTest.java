package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.dao.ProduitRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class HomeControllerTest {

    private HomeController homeControllerUnderTest;

    @Before
    public void setUp() {
        homeControllerUnderTest = new HomeController();
        homeControllerUnderTest.pharmacieRepository = mock(PharmacieRepository.class);
        homeControllerUnderTest.achatRepository = mock(AchatRepository.class);
        homeControllerUnderTest.produitRepository = mock(ProduitRepository.class);
    }

    @Test
    public void testGetMarco() {
        // Setup
        final String expectedResult = "Polo";

        // Run the test
        final String result = homeControllerUnderTest.getMarco();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetTauxDeRemise() {
        // Setup
        final float net = 5.0f;
        final float brut = 7.0f;
        final float expectedResult = 28.571426391601562f;

        // Run the test
        final float result = homeControllerUnderTest.getTauxDeRemise(net, brut);

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testGetPrixAchatNet() {
        // Setup
        final float brut = 5.0f;
        final float taux = 0.2f;
        final float expectedResult = 4.0f;

        // Run the test
        final float result = homeControllerUnderTest.getPrixAchatNet(brut, taux);

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testGetPrixVentetNet() {
        // Setup
        final float net = 5.0f;
        final float coef = 2.0f;
        final float expectedResult = 10.0f;

        // Run the test
        final float result = homeControllerUnderTest.getPrixVentetNet(net, coef);

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testGetCoefficientMultiplicateur() {
        // Setup
        final float vente = 1.0f;
        final float achat = 3.0f;
        final float expectedResult = 0.0f;

        // Run the test
        final float result = homeControllerUnderTest.getCoefficientMultiplicateur(vente, achat);

        // Verify the results
        assertEquals(0.3333333432674408, result, 0.0001);
    }
}
