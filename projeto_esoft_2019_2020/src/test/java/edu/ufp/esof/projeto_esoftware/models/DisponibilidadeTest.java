package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisponibilidadeTest {

    @Test
    public void temExplicacaoTeste() {
        Explicador e=new Explicador.ExplicadorBuilder().nome("explicador teste").build();
        Disponibilidade d1 = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.MONDAY).
                horaInicio(LocalTime.of(10,0)).horaFim(LocalTime.of(12,0)).explicador(e).build();

        Aluno a= new Aluno.AlunoBuilder().nome("aluno teste").build();

        Cadeira c= new Cadeira.CadeiraBuilder().nome("cadeira teste").build();

        Explicacao explicacao = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020,1,11,16,0)).
                dataFim(LocalDateTime.of(2020,1,11,18,0)).explicador(e).aluno(a).cadeira(c).build();


        System.out.println(d1.contains((explicacao)));
        assertTrue(!d1.contains(explicacao));

        System.out.println(d1.getExplicador());
    }
}

