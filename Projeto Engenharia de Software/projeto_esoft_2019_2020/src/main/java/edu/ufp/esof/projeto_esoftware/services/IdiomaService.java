package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.repositories.IdiomaRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdiomaService {
    @Autowired
    private IdiomaRepoI idiomaRepo;

    public Iterable<Idioma> getAllIdiomas(){
        return idiomaRepo.findAll();
    }

    public Idioma createIdioma(Idioma idioma) {
        return idiomaRepo.save(idioma);
    }

    public Optional<Idioma> updateIdioma(Idioma i){
        Optional<Idioma> idi = idiomaRepo.findById(i.getId());
        if (!idi.isPresent())return idi;
        idi.get().setIdioma(i.getIdioma());
        idiomaRepo.save(idi.get());
        return idi;
    }
}
