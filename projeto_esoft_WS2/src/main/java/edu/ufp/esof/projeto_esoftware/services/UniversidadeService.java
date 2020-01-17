package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicador;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.repositories.UniversidadeRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniversidadeService {

    @Autowired
    private UniversidadeRepoI uniRepo;

    public Iterable<Universidade> getAllUniversidades() {
        return uniRepo.findAll();
    }

    public Optional<Universidade> getUniversidadeById(Long id){
        if(uniRepo.existsById(id))
            return uniRepo.findById(id);
        return Optional.empty();
    }

    public void saveRepoUniversidade(Universidade u){
        this.uniRepo.save(u);
    }
}
