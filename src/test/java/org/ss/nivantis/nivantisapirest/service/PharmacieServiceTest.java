package org.ss.nivantis.nivantisapirest.service;

        import org.junit.Assert;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.ss.nivantis.nivantisapirest.Service.PharmacieService;
        import org.ss.nivantis.nivantisapirest.controller.AchatController;
        import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
        import org.ss.nivantis.nivantisapirest.model.Achat;
        import org.ss.nivantis.nivantisapirest.model.Pharmacie;

        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.Assert.*;
        import static org.mockito.BDDMockito.given;
        import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(PharmacieRepository.class)
public class PharmacieServiceTest {

    @MockBean
    private PharmacieService pharmacieService;

    @MockBean
    PharmacieRepository pharmacieRepository;

    @Test
    public void getdistance() {
        double maDistance = pharmacieService.distance(1d, 1d, 2d, 2d);
        assertEquals(maDistance,157.2178677858709d,0.0001);
    }

    @Test
    public void GetProche() {
        Pharmacie proche = new Pharmacie("adresse",87,44444,"2","2","proche",new ArrayList<Achat>());
        proche.setId(0L);
        Pharmacie loin = new Pharmacie("adresse",87,44444,"3","3","proche",new ArrayList<Achat>());
        proche.setId(1L);
        List<Pharmacie> lesPharmacieEnregistrees = new ArrayList<>();

        lesPharmacieEnregistrees.add(proche);
        lesPharmacieEnregistrees.add(loin);

        when(pharmacieRepository.findAll()).thenReturn(lesPharmacieEnregistrees);
        when(pharmacieRepository.findPharmacieById(0L)).thenReturn(proche);

        String laPlusProche = pharmacieService.GetProche("1","1");

        Assert.assertEquals(null,laPlusProche);
    }
}