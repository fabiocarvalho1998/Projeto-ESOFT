package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.CadeiraRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicacaoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class ExplicacaoService {
    @Autowired
    private ExplicacaoRepoI explicacaoRepo;

    @Autowired
    private ExplicadorRepoI explicadorRepo;

    @Autowired
    private AlunoRepoI alunoRepo;

    @Autowired
    private CadeiraRepoI cadeiraRepo;

    public Iterable<Explicacao> getAllExplicacoes(){
        return explicacaoRepo.findAll();
    }

    public Optional<Explicacao> createExplicacao(Explicacao explicacao) {
        Optional<Aluno> optionalAluno=alunoRepo.findByNome(explicacao.getAluno().getNome());
        if(optionalAluno.isPresent()){
            Aluno aluno=optionalAluno.get();
            Optional<Explicador> optionalExplicador=explicadorRepo.findByNome(explicacao.getExplicador().getNome());
            if(optionalExplicador.isPresent()){
                Explicador explicador=optionalExplicador.get();
                if(explicador.podeAtender(explicacao)){
                    explicador.addExplicacao(explicacao);
                    aluno.addExplicacao(explicacao);
                    explicadorRepo.save(explicador);
                    alunoRepo.save(aluno);

                }
                return Optional.of(explicacaoRepo.save(explicacao));
            }
        }
        return Optional.empty();
    }

    public boolean deleteExplicacao(Long id){
        Optional<Explicacao> e = explicacaoRepo.findById(id);
        if(!e.isPresent())return false;
        e.get().getExplicador().removeExplicacao(e.get());
        explicadorRepo.save(e.get().getExplicador());
        e.get().getAluno().removeExplicacao(e.get());
        alunoRepo.save(e.get().getAluno());
        e.get().getCadeira().removeExplicacao(e.get());
        cadeiraRepo.save(e.get().getCadeira());
        explicacaoRepo.delete(e.get());
        return true;
    }

    public Optional<Explicacao> updateExplicacao(Explicacao e){
        Optional<Explicacao> ex = explicacaoRepo.findById(e.getId());
        if (!ex.isPresent())return ex;
        ex.get().setDataInicio(e.getDataInicio());
        explicacaoRepo.save(ex.get());
        return ex;
    }

}
