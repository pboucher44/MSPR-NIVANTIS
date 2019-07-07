package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.ss.nivantis.nivantisapirest.dao.ResponseRepository;
import org.ss.nivantis.nivantisapirest.model.Response;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResponseControllerTest {

    private ResponseController responseControllerUnderTest;

    @Before
    public void setUp() {
        responseControllerUnderTest = new ResponseController();
        responseControllerUnderTest.responseRepository = mock(ResponseRepository.class);
    }

    @Test
    public void testGetResponse() {
        // Setup
        final long Id = 0L;
        final List<Response> expectedResult = Arrays.asList();
        when(responseControllerUnderTest.responseRepository.findAllByIdDmo(0L)).thenReturn(Arrays.asList());

        // Run the test
        final List<Response> result = responseControllerUnderTest.getResponse(Id);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetResponse1() {
        // Setup
        final Iterable<Response> expectedResult = null;
        when(responseControllerUnderTest.responseRepository.findAll()).thenReturn(null);

        // Run the test
        final Iterable<Response> result = responseControllerUnderTest.getResponse();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
