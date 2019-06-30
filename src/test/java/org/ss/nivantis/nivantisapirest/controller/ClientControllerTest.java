package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.ss.nivantis.nivantisapirest.dao.ClientRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.Client;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientControllerTest {

    private ClientController clientControllerUnderTest;

    @Before
    public void setUp() {
        clientControllerUnderTest = new ClientController();
        clientControllerUnderTest.clientRepository = mock(ClientRepository.class);
    }

    @Test
    public void testFindById() {
        // Setup
        final Long id = 0L;
        final Client monClient = new Client("BOUCHER","Pierre","mail@mail.fr","0654478956",new ArrayList<Achat>());
        final Optional<Client> expectedResult = Optional.of(monClient);
        when(clientControllerUnderTest.clientRepository.findById(id)).thenReturn(Optional.of(monClient));

        // Run the test
        final Optional<Client> result = clientControllerUnderTest.findById(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCreateClient() {
        // Setup
        final Client client = null;
        final ResponseEntity expectedResult = null;
        when(clientControllerUnderTest.clientRepository.save(null)).thenReturn(null);

        // Run the test
        final ResponseEntity result = clientControllerUnderTest.createClient(client);

        // Verify the results
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }
}
