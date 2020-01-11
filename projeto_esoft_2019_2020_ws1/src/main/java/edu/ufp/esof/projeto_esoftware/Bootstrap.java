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

        Faculdade f1 = new Faculdade.FaculdadeBuilder().nome("Faculdade de Ciencias e Tecnologias").build();
        Faculdade f2 = new Faculdade.FaculdadeBuilder().nome("Faculdade de Ciencias da Saúde").build();

        faculdadeRepo.save(f1);
        faculdadeRepo.save(f2);

        Aluno a1 = new Aluno.AlunoBuilder().nome("Shin Lim").build();
        Aluno a2 = new Aluno.AlunoBuilder().nome("Aaron Ramsey").build();
        Aluno a3 = new Aluno.AlunoBuilder().nome("Jose").build();
        Aluno a4 = new Aluno.AlunoBuilder().nome("Fábio").build();
        Aluno a5 = new Aluno.AlunoBuilder().nome("Mariana").build();


        alunoRepo.save(a1);
        alunoRepo.save(a2);
        alunoRepo.save(a3);
        alunoRepo.save(a4);
        alunoRepo.save(a5);

        Explicador e1 = new Explicador.ExplicadorBuilder().nome("Alessandro Moreira").build();
        Explicador e2 = new Explicador.ExplicadorBuilder().nome("Feliz Gouveia").build();


        explicadorRepo.save(e1);
        explicadorRepo.save(e2);


        Curso c1 = new Curso.CursoBuilder().nome("Engenharia Informática").build();
        Curso c2 = new Curso.CursoBuilder().nome("Fisioterapia").build();

        c1.setFaculdade(f1);
        c2.setFaculdade(f1);

        cursoRepo.save(c1);
        cursoRepo.save(c2);

        Cadeira ca1 = new Cadeira.CadeiraBuilder().nome("Engenharia de Software").build();
        Cadeira ca2 = new Cadeira.CadeiraBuilder().nome("Redes de Computadores I").build();
        Cadeira ca3 = new Cadeira.CadeiraBuilder().nome("Anatomia").build();

        ca1.addExplicador(e1);
        ca1.addExplicador(e2);
        ca1.setCurso(c1);

        ca2.addExplicador(e1);
        ca2.setCurso(c1);

        ca3.setCurso(c2);

        cadeiraRepo.save(ca1);
        cadeiraRepo.save(ca2);
        cadeiraRepo.save(ca3);



        Idioma i1 = new Idioma.IdiomaBuilder().idioma("Português").build();
        Idioma i2 = new Idioma.IdiomaBuilder().idioma("Inglês").build();


        idiomaRepo.save(i1);
        idiomaRepo.save(i2);


        Explicacao ex1=new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.parse("2019-11-13T10:00:00")).
                dataFim(LocalDateTime.parse("2019-11-13T10:30:00")).aluno(a1).explicador(e1).cadeira(ca2).build();

        a1.addExplicacao(ex1);
        alunoRepo.save(a1);

        Explicacao ex2=new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.parse("2019-11-13T11:00:00")).
                dataFim(LocalDateTime.parse("2019-11-13T11:30:00")).aluno(a3).explicador(e2).cadeira(ca1).build();
        a3.addExplicacao(ex2);

        Disponibilidade d1 = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.MONDAY).
                horaInicio(LocalTime.of(10,0)).horaFim(LocalTime.of(12,0)).explicador(e1).build();

        disponibilidadeRepo.save(d1);

        Disponibilidade d2 = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.MONDAY).
                horaInicio(LocalTime.of(11,0)).horaFim(LocalTime.of(12,0)).explicador(e2).build();

        disponibilidadeRepo.save(d2);

        Disponibilidade d3 = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.FRIDAY).
                horaInicio(LocalTime.of(11,0)).horaFim(LocalTime.of(12,0)).explicador(e2).build();

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

