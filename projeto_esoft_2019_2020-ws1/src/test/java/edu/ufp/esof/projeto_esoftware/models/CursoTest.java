package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoTest {
    @Test
    public void addCadeirasTeste() {
        Curso c1 = new Curso();
        c1.setNome("Engenharia Informática");

        Cadeira cadeira = new Cadeira();
        cadeira.setNome("Algoritmia");

        assertEquals(0, c1.getCadeiras().size());
        c1.addCadeira(cadeira);
        assertEquals(1, c1.getCadeiras().size());
    }
}
