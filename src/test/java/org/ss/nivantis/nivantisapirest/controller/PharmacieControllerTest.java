package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.ss.nivantis.nivantisapirest.dao.AchatRepository;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.dao.ProduitRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PharmacieControllerTest {

    private PharmacieController pharmacieControllerUnderTest;

    @Before
    public void setUp() {
        pharmacieControllerUnderTest = new PharmacieController();
        pharmacieControllerUnderTest.pharmacieRepository = mock(PharmacieRepository.class);
        pharmacieControllerUnderTest.achatRepository = mock(AchatRepository.class);
        pharmacieControllerUnderTest.produitRepository = mock(ProduitRepository.class);
    }

    @Test
    public void testFindAllController() {
        // Setup
        final Collection<Pharmacie> expectedResult = Arrays.asList();
        when(pharmacieControllerUnderTest.pharmacieRepository.findAll()).thenReturn(Arrays.asList());

        // Run the test
        final Collection<Pharmacie> result = pharmacieControllerUnderTest.findAllController();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindById() {
        // Setup
        final Long id = 0L;
        Pharmacie maPharmacie = new Pharmacie("adresse","87","44444","2.5","6.1","maPharmacie",new ArrayList<Achat>());
        final Optional<Pharmacie> expectedResult = Optional.of(maPharmacie);
        when(pharmacieControllerUnderTest.pharmacieRepository.findById(id)).thenReturn(Optional.of(maPharmacie));

        // Run the test
        final Optional<Pharmacie> result = pharmacieControllerUnderTest.findById(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindPositionOfPhamarcie() {
        // Setup
        final Long id = 0L;
        Pharmacie maPharmacie = new Pharmacie("adresse","87","44444","2.5","6.1","maPharmacie",new ArrayList<Achat>());
        final Optional<Pharmacie> expectedResult = Optional.of(maPharmacie);
        when(pharmacieControllerUnderTest.pharmacieRepository.findById(id)).thenReturn(Optional.of(maPharmacie));

        // Run the test
        final Optional<Pharmacie> result = pharmacieControllerUnderTest.findPositionOfPhamarcie(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCreatePharmacie() {
        // Setup
        final Pharmacie pharmacie = null;
        final ResponseEntity expectedResult = null;
        when(pharmacieControllerUnderTest.pharmacieRepository.save(null)).thenReturn(null);

        // Run the test
        final ResponseEntity result = pharmacieControllerUnderTest.createPharmacie(pharmacie);

        // Verify the results
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }
}
