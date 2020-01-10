package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisponibilidadeTest {

    @Test
    public void temExplicacaoTeste() {
        Disponibilidade d1 = new Disponibilidade();
        LocalTime disponibilidadeInicio = LocalTime.of(10, 0);
        LocalTime disponibilidadeFim = LocalTime.of(12, 0);
        DayOfWeek dia = DayOfWeek.of(3);
        d1.setHoraInicio(disponibilidadeInicio);
        d1.setHoraFim(disponibilidadeFim);
        d1.setDiaSemana(dia);

        Explicacao explicacao = new Explicacao();
        LocalDateTime explicacaoInicio = LocalDateTime.of(2019, 10, 1, 16, 0);
        LocalDateTime explicacaoFim = LocalDateTime.of(2020, 2, 1, 18, 0);
        explicacao.setDataInicio(explicacaoInicio);
        explicacao.setDataFim(explicacaoFim);

        assertEquals(true, d1.contains(explicacao));
    }
}
