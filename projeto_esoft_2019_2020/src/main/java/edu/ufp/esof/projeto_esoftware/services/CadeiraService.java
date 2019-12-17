package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.repositories.CadeiraRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadeiraService {
    @Autowired
    private CadeiraRepoI cadeiraRepo;

    public Iterable<Cadeira> getAllCadeiras(){
        return cadeiraRepo.findAll();
    }

    public Cadeira createCadeira(Cadeira cadeira) {
        return cadeiraRepo.save(cadeira);
    }

    public Optional<Cadeira> updateCadeira(Cadeira c){
        Optional<Cadeira> ca = cadeiraRepo.findById(c.getId());
        if (!ca.isPresent())return ca;
        ca.get().setNome(c.getNome());
        //ca.get().setCurso(c.getCurso());
        cadeiraRepo.save(ca.get());
        return ca;
    }
}
