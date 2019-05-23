package org.ss.nivantis.nivantisapirest;

import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public abstract class DatabaseLoader implements CommandLineRunner {

    private PharmacieRepository pharmacieRepository;

    @Autowired
    public DatabaseLoader(PharmacieRepository pharmacieRepository) {
        this.pharmacieRepository = pharmacieRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.pharmacieRepository.save(new Pharmacie("avenue de brocéliande", 3, 44300, 1, 1));
    }
}
