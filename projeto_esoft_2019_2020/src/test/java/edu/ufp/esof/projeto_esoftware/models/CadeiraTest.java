package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadeiraTest {
    @Test
    public void addExplicacoesTeste() {
        Cadeira c1 = new Cadeira();
        c1.setNome("Bases de Dados");

        Explicacao explicacao = new Explicacao();
        LocalDateTime inicio = LocalDateTime.of(2019, 10, 1, 16, 0);
        LocalDateTime fim = LocalDateTime.of(2020, 2, 1, 18, 0);
        explicacao.setDataInicio(inicio);
        explicacao.setDataFim(fim);

        assertEquals(0, c1.getExplicacoes().size());
        c1.addExplicacao(explicacao);
        assertEquals(1, c1.getExplicacoes().size());
    }

    @Test
    public void addExplicadoresTeste() {
        Cadeira c1 = new Cadeira();
        c1.setNome("Algoritmia");

        Explicador explicador = new Explicador();
        explicador.setNome("Josefim Castro");

        assertEquals(0, c1.getExplicadores().size());
        c1.addExplicador(explicador);
        assertEquals(1, c1.getExplicadores().size());
    }
}
