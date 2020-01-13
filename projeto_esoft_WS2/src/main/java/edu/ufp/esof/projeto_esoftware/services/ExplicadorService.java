package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicador;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.UniversidadeRepoI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ExplicadorService {
    @Autowired
    private UniversidadeRepoI uniRepo;

    @Autowired
    private ExplicadorRepoI explicadorRepo;


    public Optional<Explicador> createExplicador(Explicador exp, Long idUni) {
        Optional<Universidade> optionalUni=this.uniRepo.findById(idUni);
        if(optionalUni.isPresent()){
            Universidade u=optionalUni.get();
            u.addExplicador(exp);
            exp.setUniversidade(u);
            this.uniRepo.save(u);
            return Optional.of(exp);
        }
        return Optional.empty();
    }

    public Iterable<Explicador> getAllExplicadores(){
        return explicadorRepo.findAll();
    }
}
