package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.repositories.CursoRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    private CursoRepoI cursoRepo;

    public Iterable<Curso> getAllCursos(){
        return cursoRepo.findAll();
    }
}
