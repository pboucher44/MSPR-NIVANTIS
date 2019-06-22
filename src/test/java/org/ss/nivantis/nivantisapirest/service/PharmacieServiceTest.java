package org.ss.nivantis.nivantisapirest.service;

import org.junit.Before;
import org.junit.Test;
import org.ss.nivantis.nivantisapirest.Service.PharmacieService;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PharmacieServiceTest {

    private PharmacieService pharmacieServiceUnderTest;

    @Before
    public void setUp() {
        pharmacieServiceUnderTest = new PharmacieService();
        pharmacieServiceUnderTest.pharmacieRepository = mock(PharmacieRepository.class);
    }

    @Test
    public void testDistance() {
        // Setup
        final double lat1 = 0.0;
        final double lon1 = 0.0;
        final double lat2 = 0.0;
        final double lon2 = 0.0;
        final double expectedResult = 0.0;

        // Run the test
        final double result = PharmacieService.distance(lat1, lon1, lat2, lon2);

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }
}
