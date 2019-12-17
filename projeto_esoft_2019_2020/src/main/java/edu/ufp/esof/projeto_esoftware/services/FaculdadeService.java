package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.models.Faculdade;
import edu.ufp.esof.projeto_esoftware.repositories.FaculdadeRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FaculdadeService {
    @Autowired
    private FaculdadeRepoI faculdadeRepo;

    public Iterable<Faculdade> getAllFaculdades(){
        return faculdadeRepo.findAll();
    }

    public Faculdade createFaculdade(Faculdade faculdade) {
        return faculdadeRepo.save(faculdade);
    }

    public Optional<Faculdade> updateFaculdade(Faculdade f){
        Optional<Faculdade> fa = faculdadeRepo.findById(f.getId());
        if (!fa.isPresent())return fa;
        fa.get().setNome(f.getNome());
        faculdadeRepo.save(fa.get());
        return fa;
    }
}
