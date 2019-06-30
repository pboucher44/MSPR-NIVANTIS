package org.ss.nivantis.nivantisapirest;

import org.ss.nivantis.nivantisapirest.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public abstract class DatabaseLoader implements CommandLineRunner {

    private PharmacieRepository pharmacieRepository;
    private AchatRepository achatRepository;
    private ClientRepository clientRepository;
    private DMORepository dmoRepository;
    private ProduitRepository produitRepository;
    private QuestionRepository questionRepository;
    private ResponseRepository responseRepository;


    @Autowired
    public DatabaseLoader(PharmacieRepository pharmacieRepository,
                          AchatRepository achatRepository,
                          ClientRepository clientRepository,
                          DMORepository dmoRepository,
                          ProduitRepository produitRepository,
                          QuestionRepository questionRepository,
                          ResponseRepository responseRepository
                          ) {
        this.pharmacieRepository = pharmacieRepository;
        this.achatRepository = achatRepository;
        this.clientRepository = clientRepository;
        this.dmoRepository = dmoRepository;
        this.produitRepository = produitRepository;
        this.questionRepository = questionRepository;
        this.responseRepository = responseRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
