package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.ss.nivantis.nivantisapirest.dao.DMORepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.DMO;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DMOControllerTest {

    private DMOController dmoControllerUnderTest;

    @Before
    public void setUp() {
        dmoControllerUnderTest = new DMOController();
        dmoControllerUnderTest.dmoRepository = mock(DMORepository.class);
    }

    @Test
    public void testFindById() {
        // Setup
        final Long id = 0L;
        DMO monDmo = new DMO("BOUCHER","Pierre","pboucher","pboucher",new ArrayList<Achat>());
        final Optional<DMO> expectedResult = Optional.of(monDmo);
        when(dmoControllerUnderTest.dmoRepository.findById(id)).thenReturn(Optional.of(monDmo));

        // Run the test
        final Optional<DMO> result = dmoControllerUnderTest.findById(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCreateDMO() {
        // Setup
        final DMO dmo = null;
        final ResponseEntity expectedResult = null;
        when(dmoControllerUnderTest.dmoRepository.save(null)).thenReturn(null);

        // Run the test
        final ResponseEntity result = dmoControllerUnderTest.createDMO(dmo);

        // Verify the results
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }
}
