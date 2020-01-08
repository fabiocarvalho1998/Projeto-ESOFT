package edu.ufp.esof.projeto_esoftware;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.models.Faculdade;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.CadeiraRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.CursoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.DisponibilidadeRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicacaoRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.FaculdadeRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.IdiomaRepoI;

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
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){

        Faculdade f1 = new Faculdade();
        Faculdade f2 = new Faculdade();

        f1.setNome("Faculdade de Ciências e Tecnologias");
        f2.setNome("Faculdade de Ciências da Saúde");

        faculdadeRepo.save(f1);
        faculdadeRepo.save(f2);

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
        c1.setFaculdade(f1);
        c2.setFaculdade(f1);

        cursoRepo.save(c1);
        cursoRepo.save(c2);

        //MTX com CASCADE.MERGE, ao criar a cadeira cria as associacoes MAS NAO o explicador QUE TEM DE JA EXISTIR senao temos erro "save the transient befor flushin
        //mas se nao estiver na mesma sessao e criarmos com objetos que ja existem mas foram criados em sessao anterior,
        // o hibernate tenta usar esses objetos mas eles nao existem na sessao e temos erros de detached entity
        //https://stackoverflow.com/questions/40247030/detached-entity-passed-to-persist-in-spring-data/40250646
        //questiono-me se deve exitir CASCADE ALL em algum dos lados
        //MAS se estiver DENTRO da mesma sessao nao é um problema, com a @Transactional funciona
        Cadeira ca1 = new Cadeira();
        Cadeira ca2 = new Cadeira();
        Cadeira ca3 = new Cadeira();

        ca1.setNome("Engenharia de Software");
        ca1.addExplicador(e1);
        ca1.addExplicador(e2);
        ca1.setCurso(c1);

        ca2.setNome("Redes de Computadores I");
        ca2.addExplicador(e1);
        ca2.setCurso(c1);

        ca3.setNome("Anatomia");
        ca3.setCurso(c2);

        cadeiraRepo.save(ca1);
        cadeiraRepo.save(ca2);
        cadeiraRepo.save(ca3);



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
        ex1.setDataFim(LocalDateTime.parse("2019-11-13T10:30:00"));
        a1.addExplicacao(ex1);
        alunoRepo.save(a1);

        Explicacao ex2=new Explicacao();
        ex2.setAluno(a3);
        ex2.setExplicador(e2);
        ex2.setCadeira(ca2);
        ex2.setDataInicio(LocalDateTime.parse("2019-11-13T11:00:00"));
        ex2.setDataFim(LocalDateTime.parse("2019-11-13T11:30:00"));

        Disponibilidade d1 = new Disponibilidade();
        d1.setDiaSemana(DayOfWeek.MONDAY);
        d1.setHoraInicio(LocalTime.of(10, 0));
        d1.setHoraFim(LocalTime.of(12, 0));
        d1.setExplicador(e1);
        disponibilidadeRepo.save(d1);

        Disponibilidade d2 = new Disponibilidade();
        d2.setDiaSemana(DayOfWeek.MONDAY);
        d2.setHoraInicio(LocalTime.of(11, 0));
        d2.setHoraFim(LocalTime.of(12, 0));
        d2.setExplicador(e2);
        disponibilidadeRepo.save(d2);

        Disponibilidade d3 = new Disponibilidade();
        d3.setDiaSemana(DayOfWeek.FRIDAY);
        d3.setHoraInicio(LocalTime.of(11, 0));
        d3.setHoraFim(LocalTime.of(12, 0));
        d3.setExplicador(e2);
        disponibilidadeRepo.save(d3);


        //explicacaoRepo.save(ex1);
        explicacaoRepo.save(ex2);

        e1.addIdioma(i1);
        e1.addIdioma(i2);
        e2.addIdioma(i1);
        e2.addIdioma(i2);
        explicadorRepo.save(e1);
        explicadorRepo.save(e2);
    }
}

