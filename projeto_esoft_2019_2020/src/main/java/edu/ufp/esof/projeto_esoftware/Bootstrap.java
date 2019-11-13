package edu.ufp.esof.projeto_esoftware;

import edu.ufp.esof.projeto_esoftware.models.*;
import edu.ufp.esof.projeto_esoftware.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AlunoRepoI alunoRepo;

    @Autowired
    private ExplicadorRepoI explicadorRepo;

    @Autowired
    private CursoRepoI cursoRepo;

    @Autowired
    private CadeiraRepoI cadeiraRepo;

    @Autowired
    private FaculdadeRepoI faculdadeRepo;

    @Autowired
    private DisponibilidadeRepoI disponibilidadeRepo;

    @Autowired
    private IdiomaRepoI idiomaRepo;


    @Autowired
    private ExplicacaoRepoI explicacaoRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.setNome("João Silva");
        a2.setNome("Vitor Lopes");
        a3.setNome("Fábio Carvalho");

        alunoRepo.save(a1);
        alunoRepo.save(a2);
        alunoRepo.save(a3);

        Explicador e1 = new Explicador();
        Explicador e2 = new Explicador();

        e1.setNome("Alessandro Moreira");
        e2.setNome("Feliz Gouveia");

        explicadorRepo.save(e1);
        explicadorRepo.save(e2);

        Curso c1 = new Curso();
        Curso c2 = new Curso();

        c1.setNome("Engenharia Informática");
        c2.setNome("Fisioterapia");

        cursoRepo.save(c1);
        cursoRepo.save(c2);


        Cadeira ca1 = new Cadeira();
        Cadeira ca2 = new Cadeira();

        ca1.setNome("Engenharia de Software");
        ca2.setNome("Redes de Computadores I");

        cadeiraRepo.save(ca1);
        cadeiraRepo.save(ca2);


        Faculdade f1 = new Faculdade();
        Faculdade f2 = new Faculdade();

        f1.setNome("Faculdade de Ciências e Tecnologias");
        f2.setNome("Faculdade de Ciências da Saúde");

        faculdadeRepo.save(f1);
        faculdadeRepo.save(f2);


        Idioma i1 = new Idioma();
        Idioma i2 = new Idioma();

        i1.setIdioma("Português");
        i2.setIdioma("Inglês");

        idiomaRepo.save(i1);
        idiomaRepo.save(i2);


        Explicacao ex1=new Explicacao();
        //ex1.setAluno(a1);
        ex1.setExplicador(e1);
        ex1.setCadeira(ca1);
        ex1.setDataInicio(LocalDateTime.parse("2019-11-13T10:00:00"));
        a1.addExplicacao(ex1);
        alunoRepo.save(a1);

        Explicacao ex2=new Explicacao();
        ex2.setAluno(a3);
        ex2.setExplicador(e2);
        ex2.setCadeira(ca2);
        ex2.setDataInicio(LocalDateTime.parse("2019-11-13T11:00:00"));

        //explicacaoRepo.save(ex1);
        explicacaoRepo.save(ex2);
    }
}

