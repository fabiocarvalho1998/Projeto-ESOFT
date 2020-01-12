package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.*;
import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.CadeiraRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicacaoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
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
       //exp.get().setIdiomas(e.getIdiomas());
        //exp.get().setDisponibilidades(e.getDisponibilidades());
        //exp.get().setCadeiras(e.getCadeiras());
        explicadorRepo.save(exp.get());
        return exp;
    }

    public Iterable<Explicador> getExplicadoresDisponiveisCadeiraData(Long idCadeira, DayOfWeek dia, LocalTime horaInicio, LocalTime horaFim){
        return explicadorRepo.getExplicadoresDisponiveisCadeiraData(idCadeira, dia, horaInicio, horaFim);
    }

    public Optional<Explicador> updateExplicadorComCadeira(Explicador explicador, Long idCadeira) {
        Optional<Cadeira> optionalCadeira=this.cadeiraRepo.findById(idCadeira);
        if(optionalCadeira.isPresent()){
            Cadeira c=optionalCadeira.get();
            c.addExplicador(explicador);
            //explicador.addCadeira(c);
            //this.cadeiraRepo.save(c);
            this.explicadorRepo.save(explicador);
            return Optional.of(explicador);
        }
        return Optional.empty();
    }

    public Optional<Explicador> getExplicadorByNome(String nome) {
        return explicadorRepo.findByNome(nome);
    }
}
