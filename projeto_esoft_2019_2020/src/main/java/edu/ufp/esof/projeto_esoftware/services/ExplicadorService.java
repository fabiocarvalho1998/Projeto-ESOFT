package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.CadeiraRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicacaoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExplicadorService {
    @Autowired
    private ExplicadorRepoI explicadorRepo;

    @Autowired
    private AlunoRepoI alunoRepo;

    @Autowired
    private ExplicacaoRepoI explicacaoRepo;

    @Autowired
    private CadeiraRepoI cadeiraRepo;

    public Iterable<Explicador> getAllExplicadores(){
        return explicadorRepo.findAll();
    }

    public Explicador createExplicador(Explicador explicador) {
        return explicadorRepo.save(explicador);
    }

    public Optional<Explicador> updateExplicador(Explicador e){
        Optional<Explicador> exp = explicadorRepo.findById(e.getId());
        if (!exp.isPresent())return exp;
        exp.get().setNome(e.getNome());
        explicadorRepo.save(exp.get());
        return exp;
    }

}
