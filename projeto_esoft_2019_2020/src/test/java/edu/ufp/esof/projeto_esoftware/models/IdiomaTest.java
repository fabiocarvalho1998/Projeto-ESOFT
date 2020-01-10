package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdiomaTest {
    @Test
    public void addExplicadorTeste() {
        Idioma i1 = new Idioma();
        i1.setIdioma("Espanhol");

        Explicador explicador = new Explicador();
        explicador.setNome("Josefim Castro");

        assertEquals(0, i1.getExplicadores().size());
        i1.addExplicador(explicador);
        assertEquals(1, i1.getExplicadores().size());
    }
}
