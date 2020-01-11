package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplicadorTest {

    @Test
    public void addIdiomaTeste() {
        Explicador e1 = new Explicador();
        e1.setNome("Josefim Castro");
        Idioma idioma = new Idioma();
        idioma.setIdioma("Espanhol");

        assertEquals(0, e1.getIdiomas().size());
        e1.addIdioma(idioma);
        assertEquals(1, e1.getIdiomas().size());
    }

    @Test
    public void addDisponibilidadeTeste() {
        Explicador e1 = new Explicador();
        e1.setNome("Josefim Castro");

        Disponibilidade disponibilidade = new Disponibilidade();
        LocalTime inicio = LocalTime.of(10, 0);
        LocalTime fim = LocalTime.of(12, 0);
        DayOfWeek dia = DayOfWeek.of(3);
        disponibilidade.setHoraInicio(inicio);
        disponibilidade.setHoraFim(fim);
        disponibilidade.setDiaSemana(dia);

        assertEquals(0, e1.getDisponibilidades().size());
        e1.addDisponibilidade(disponibilidade);
        assertEquals(1, e1.getDisponibilidades().size());
    }

    @Test
    public void addExplicacoesTeste() {
        Explicador e1 = new Explicador();
        e1.setNome("Josefim Castro");

        Explicacao explicacao = new Explicacao();
        LocalDateTime inicio = LocalDateTime.of(2019, 10, 1, 16, 0);
        LocalDateTime fim = LocalDateTime.of(2020, 2, 1, 18, 0);
        explicacao.setDataInicio(inicio);
        explicacao.setDataFim(fim);

        assertEquals(0, e1.getExplicacoes().size());
        e1.addExplicacao(explicacao);
        assertEquals(1, e1.getExplicacoes().size());
    }

    @Test
    public void addCadeirasTeste() {
        Explicador e1 = new Explicador();
        e1.setNome("Josefim Castro");

        Cadeira cadeira = new Cadeira();
        cadeira.setNome("Algoritmia");

        assertEquals(0, e1.getCadeiras().size());
        e1.addCadeira(cadeira);
        assertEquals(1, e1.getCadeiras().size());
    }

    @Test
    public void temHorarioTesteFalha() {
        Explicador e1 = new Explicador();
        e1.setNome("Josefim Castro");

        Disponibilidade d1 = new Disponibilidade();
        LocalTime inicio = LocalTime.of(10, 0);
        LocalTime fim = LocalTime.of(12, 0);
        DayOfWeek dia = DayOfWeek.of(3);
        d1.setHoraInicio(inicio);
        d1.setHoraFim(fim);
        d1.setDiaSemana(dia);

        e1.addDisponibilidade(d1);

        //dia errado
        assertEquals(false, e1.temhorario(1, inicio));

        //dia correto mas hora errada
        assertEquals(false, e1.temhorario(3, LocalTime.of(7, 0)));

        //ambos errados
        assertEquals(false, e1.temhorario(6, LocalTime.of(17, 0)));
    }

    @Test
    public void temExplicacaoTesteSucesso() {
        Explicador e1 = new Explicador();
        e1.setNome("Josefim Castro");

        Explicacao explicacao = new Explicacao();
        LocalDateTime inicio = LocalDateTime.of(2019, 10, 1, 16, 0);
        LocalDateTime fim = LocalDateTime.of(2020, 2, 1, 18, 0);
        explicacao.setDataInicio(inicio);
        explicacao.setDataFim(fim);

        e1.addExplicacao(explicacao);

        assertEquals(true, e1.temExplicacao(explicacao));
    }

    @Test
    public void temExplicacaoTesteFalha(){
        Explicador e1 = new Explicador();
        e1.setNome("Josefim Castro");

        Explicacao explicacao = new Explicacao();
        LocalDateTime inicio = LocalDateTime.of(2019, 10, 1, 16, 0);
        LocalDateTime fim = LocalDateTime.of(2020, 2, 1, 18, 0);
        explicacao.setDataInicio(inicio);
        explicacao.setDataFim(fim);

        assertEquals(false, e1.temExplicacao(explicacao));
    }
}
