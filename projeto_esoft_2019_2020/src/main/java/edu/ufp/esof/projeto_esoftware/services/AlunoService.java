package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicacaoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepoI alunoRepo;

    @Autowired
    private ExplicadorRepoI explicadorRepo;

    @Autowired
    private ExplicacaoRepoI explicacaoRepo;


    public Iterable<Aluno> getAllAlunos(){
        return alunoRepo.findAll();
    }

    /*Todo*/
    /**Verificar se funciona como quero*/
    public Aluno createAluno(Aluno aluno) {
        return alunoRepo.save(aluno);
        /*Iterable<Aluno> alunos=alunoRepo.findAll();
        for(Aluno a: alunos){
            if(aluno.sameName(a.getNome())){
                System.out.println("O aluno que pretende inserir já existe!\n");
                return null;
            }else{
                return alunoRepo.save(aluno);
            }
        }*/
        //return null;
    }

    public boolean deleteAluno(Long aid){
        Optional<Aluno> a = alunoRepo.findById(aid);
        if(!a.isPresent())return false;
        for(Explicacao e : a.get().getExplicacoes()){
            e.getExplicador().removeExplicacao(e);
            explicadorRepo.save(e.getExplicador());
            e.setExplicador(null);
            e.setAluno(null);
            explicacaoRepo.delete(e);
        }
        alunoRepo.delete(a.get());
        return true;
    }

    public Optional<Aluno> updateAluno(Aluno a){
        Optional<Aluno> al = alunoRepo.findById(a.getId());
        if (!al.isPresent())return al;
        al.get().setNome(a.getNome());
        alunoRepo.save(al.get());
        return al;
    }
}
