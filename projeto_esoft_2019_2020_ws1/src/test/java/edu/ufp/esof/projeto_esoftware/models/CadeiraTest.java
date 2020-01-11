package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadeiraTest {
    @Test
    public void addExplicacoesTeste() {
        Cadeira c1 = new Cadeira.CadeiraBuilder().nome("Engenharia de Sfotware").build();

        Explicacao explicacao = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020,1,11,16,0)).
                dataFim(LocalDateTime.of(2020,1,11,17,0)).build();

        assertEquals(0, c1.getExplicacoes().size());
        c1.addExplicacao(explicacao);
        assertEquals(1, c1.getExplicacoes().size());
        System.out.println(c1.getExplicacoes());
        System.out.println(c1);
    }

    @Test
    public void addExplicadoresTeste() {
        Cadeira c1 = new Cadeira.CadeiraBuilder().nome("Algoritmia").build();

        Explicador explicador = new Explicador.ExplicadorBuilder().nome("Jose").build();

        assertEquals(0, c1.getExplicadores().size());
        c1.addExplicador(explicador);
        assertEquals(1, c1.getExplicadores().size());
        System.out.println(c1.getExplicadores());
    }
}
