package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdiomaTest {
    @Test
    public void addExplicadorTeste() {
        Idioma i1 = new Idioma.IdiomaBuilder().idioma("Frances").build();

        Explicador explicador = new Explicador.ExplicadorBuilder().nome("Franklin").build();

        assertEquals(0, i1.getExplicadores().size());
        i1.addExplicador(explicador);
        assertEquals(1, i1.getExplicadores().size());
        System.out.println(explicador.getIdiomas());
        System.out.println(i1.getExplicadores());
    }
}
