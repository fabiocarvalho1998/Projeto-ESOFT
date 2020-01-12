package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.repositories.DisponibilidadeRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisponibilidadeService {
    @Autowired
    private DisponibilidadeRepoI disponibilidadeRepo;

    public Iterable<Disponibilidade> getAllDisponibilidades(){
        return disponibilidadeRepo.findAll();
    }

    public Disponibilidade createDisponibilidade(Disponibilidade d) {
        return disponibilidadeRepo.save(d);
    }

    public Optional<Disponibilidade> updateDisponibilidade(Disponibilidade d){
        Optional<Disponibilidade> dis = disponibilidadeRepo.findById(d.getId());
        if (!dis.isPresent())return dis;
        dis.get().setDiaSemana(d.getDiaSemana());
        dis.get().setHoraInicio(d.getHoraInicio());
        dis.get().setHoraFim(d.getHoraFim());
        dis.get().setExplicador(d.getExplicador());
        disponibilidadeRepo.save(dis.get());
        return dis;
    }
}
