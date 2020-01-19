package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.repositories.CadeiraRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.CursoRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadeiraService {
    @Autowired
    private CadeiraRepoI cadeiraRepo;

    @Autowired
    private CursoRepoI cursoRepo;

    public Iterable<Cadeira> getAllCadeiras(){
        return cadeiraRepo.findAll();
    }

    public Optional<Cadeira> createCadeira(Cadeira cadeira, Long idCurso) {
        Optional<Curso> optionalCurso=this.cursoRepo.findById(idCurso);
        if(optionalCurso.isPresent()){
            Curso curso=optionalCurso.get();
            curso.addCadeira(cadeira);
            this.cursoRepo.save(curso);
            return Optional.of(cadeira);
        }
        return Optional.empty();
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
