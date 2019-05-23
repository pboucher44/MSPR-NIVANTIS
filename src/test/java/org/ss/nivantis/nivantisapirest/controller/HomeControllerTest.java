package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {
    HomeController homeController = new HomeController();

    @Test
    public void getMarco() {
        String polo = homeController.getMarco();
        assertEquals(polo,"Polo");
    }

    @Test
    public void getTauxDeRemise() {
        Float monTaux = homeController.getTauxDeRemise(20,25);
        Float tauxTest = ((1-20f/25f)*100);
        assertEquals(monTaux,tauxTest);
    }

    @Test
    public void getPrixAchatNet() {
        Float monPrixNet = homeController.getPrixAchatNet(25,23);
        Float prixTest = 25f*(1-23f);
        assertEquals(monPrixNet,prixTest);
    }

    @Test
    public void getPrixVentetNet() {
        Float monPrixNet = homeController.getPrixVentetNet(25,23);
        Float prixTest = 25f*23f;
        assertEquals(monPrixNet,prixTest);
    }

    @Test
    public void getCoefficientMultiplicateur() {
        Float monCoef = homeController.getCoefficientMultiplicateur(25,23);
        Float coefTest = 25f/23f;
        assertEquals(monCoef,coefTest);
    }

    @Test
    public void createPharmacie() {
    }
}