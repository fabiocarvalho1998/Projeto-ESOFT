package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicacaoRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExplicacaoService {
    @Autowired
    private ExplicacaoRepoI explicacaoRepo;

    public Iterable<Explicacao> getAllExplicacoes(){
        return explicacaoRepo.findAll();
    }
}
