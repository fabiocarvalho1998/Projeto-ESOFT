package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.repositories.CursoRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepoI cursoRepo;

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
}
