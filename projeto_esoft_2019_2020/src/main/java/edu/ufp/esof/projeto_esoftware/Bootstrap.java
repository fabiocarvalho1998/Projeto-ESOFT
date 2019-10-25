package edu.ufp.esof.projeto_esoftware;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AlunoRepoI alunoRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        a1.setNome("João Silva");
        a2.setNome("Vitor Lopes");

        alunoRepo.save(a1);
        alunoRepo.save(a2);
    }
}

