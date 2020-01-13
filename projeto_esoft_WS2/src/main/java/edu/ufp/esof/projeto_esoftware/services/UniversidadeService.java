package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicador;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.repositories.UniversidadeRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversidadeService {

    @Autowired
    private UniversidadeRepoI uniRepo;

    public Iterable<Universidade> getAllUniversidades() {
        return uniRepo.findAll();
    }
}
