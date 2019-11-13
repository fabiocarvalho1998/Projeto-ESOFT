package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.repositories.IdiomaRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaService {
    @Autowired
    private IdiomaRepoI idiomaRepo;

    public Iterable<Idioma> getAllIdiomas(){
        return idiomaRepo.findAll();
    }
}
