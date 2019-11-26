package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.repositories.DisponibilidadeRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadeService {
    @Autowired
    private DisponibilidadeRepoI disponibilidadeRepo;

    public Iterable<Disponibilidade> getAllDisponibilidades(){
        return disponibilidadeRepo.findAll();
    }

    public Disponibilidade createDisponibilidade(Disponibilidade d) {
        return disponibilidadeRepo.save(d);
    }
}
