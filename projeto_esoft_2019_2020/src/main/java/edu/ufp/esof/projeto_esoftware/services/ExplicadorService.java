package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExplicadorService {
    @Autowired
    private ExplicadorRepoI explicadorRepo;

    public Iterable<Explicador> getAllExplicadores(){
        return explicadorRepo.findAll();
    }
}
