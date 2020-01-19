package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplicadorTest {

    @Test
    public void addIdiomaTeste() {
        Explicador e1 = new Explicador.ExplicadorBuilder().nome("explicador teste").build();
        Idioma idioma = new Idioma.IdiomaBuilder().idioma("portugues").build();
        Idioma idioma2 = new Idioma.IdiomaBuilder().idioma("ingles").build();

        assertEquals(0, e1.getIdiomas().size());
        e1.addIdioma(idioma);
        e1.addIdioma(idioma2);
        assertEquals(2, e1.getIdiomas().size());
        System.out.println(e1.getIdiomas());
    }

    @Test
    public void addDisponibilidadeTeste() {
        Explicador e1 = new Explicador.ExplicadorBuilder().nome("explicador teste").build();

        Disponibilidade disponibilidade = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.TUESDAY).explicador(e1).
                horaInicio(LocalTime.of(10,0)).horaFim(LocalTime.of(12,0)).build();

        assertEquals(0, e1.getDisponibilidades().size());
        e1.addDisponibilidade(disponibilidade);
        assertEquals(1, e1.getDisponibilidades().size());
        System.out.println(e1.getDisponibilidades());
    }

    @Test
    public void addExplicacoesTeste() {
        Explicador e1 = new Explicador.ExplicadorBuilder().nome("explicador teste").build();

        Explicacao explicacao = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020,1,11,16,0)).
                dataFim(LocalDateTime.of(2020,1,11,17,0)).explicador(e1).build();

        assertEquals(0, e1.getExplicacoes().size());
        e1.addExplicacao(explicacao);
        assertEquals(1, e1.getExplicacoes().size());
        System.out.println(e1.getExplicacoes());
    }

    @Test
    public void addCadeirasTeste() {
        Explicador e1 = new Explicador.ExplicadorBuilder().nome("teste").build();

        Cadeira cadeira = new Cadeira.CadeiraBuilder().nome("cadeira teste").build();

        assertEquals(0, e1.getCadeiras().size());
        e1.addCadeira(cadeira);
        assertEquals(1, e1.getCadeiras().size());
        System.out.println(e1.getCadeiras());
    }

    @Test
    public void temHorarioTesteFalha() {
        Explicador e1 = new Explicador.ExplicadorBuilder().nome("exp teste").build();

        Disponibilidade d1 = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.TUESDAY).explicador(e1).
                horaInicio(LocalTime.of(10,0)).horaFim(LocalTime.of(12,0)).build();

        e1.addDisponibilidade(d1);

        //dia errado
        assertEquals(false, e1.temhorario(1, LocalTime.of(10,0)));

        //dia correto mas hora errada
        assertEquals(false, e1.temhorario(3, LocalTime.of(7, 0)));

        //ambos errados
        assertEquals(false, e1.temhorario(6, LocalTime.of(17, 0)));
    }

    @Test
    public void temExplicacaoTesteSucesso() {
        Explicador e1 = new Explicador.ExplicadorBuilder().nome("exp teste").build();

        Explicacao explicacao = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020,1,11,16,0)).
                dataFim(LocalDateTime.of(2020,1,11,17,0)).explicador(e1).build();

        assertEquals(false, e1.temExplicacao(explicacao));
    }

    @Test
    public void temExplicacaoTesteFalha(){
        Explicador e1 = new Explicador.ExplicadorBuilder().nome("exp teste").build();

        Explicacao explicacao = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020,1,11,16,0)).
                dataFim(LocalDateTime.of(2020,1,21,22,30)).explicador(e1).build();

        assertEquals(false, e1.temExplicacao(explicacao));
    }
}
