package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepoI alunoRepo;

    public Iterable<Aluno> getAllAlunos(){
        return alunoRepo.findAll();
    }

    /*Todo*/
    /**Verificar se funciona como quero*/
    public Aluno createAluno(Aluno aluno) {

        /*Iterable<Aluno> alunos=alunoRepo.findAll();
        for(Aluno a: alunos){
            if(aluno.sameName(a.getNome())){
                System.out.println("O aluno que pretende inserir já existe!\n");
                return null;
            }else{
                return alunoRepo.save(aluno);
            }
        }*/
        return null;
    }
}
