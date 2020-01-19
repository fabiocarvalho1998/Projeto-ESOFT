package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.models.Faculdade;
import edu.ufp.esof.projeto_esoftware.repositories.CursoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.FaculdadeRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepoI cursoRepo;

    @Autowired
    private FaculdadeRepoI faculdadeRepo;

    public Iterable<Curso> getAllCursos(){
        return cursoRepo.findAll();
    }

    public Curso createCurso(Curso curso) {
        return cursoRepo.save(curso);
    }

    public Optional<Curso> updateCurso(Curso c){
        Optional<Curso> cr = cursoRepo.findById(c.getId());
        if (!cr.isPresent())return cr;
        cr.get().setNome(c.getNome());
        cursoRepo.save(cr.get());
        return cr;
    }

    public Optional<Curso> createCurso(Curso curso, Long idFaculdade) {
        Optional<Faculdade> optionalFaculdade=this.faculdadeRepo.findById(idFaculdade);
        if(optionalFaculdade.isPresent()){
            Faculdade f=optionalFaculdade.get();
            f.addCurso(curso);
            curso.setFaculdade(f);
            this.faculdadeRepo.save(f);
            return Optional.of(curso);
        }
        return Optional.empty();
    }
}
