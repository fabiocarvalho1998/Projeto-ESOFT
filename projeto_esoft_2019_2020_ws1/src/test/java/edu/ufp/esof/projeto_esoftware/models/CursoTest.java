package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoTest {
    @Test
    public void addCadeirasTeste() {
        Curso c1 = new Curso.CursoBuilder().nome("Engenharia Informática").build();

        Cadeira cadeira = new Cadeira.CadeiraBuilder().nome("Bases de Dados").build();

        assertEquals(0, c1.getCadeiras().size());
        c1.addCadeira(cadeira);
        assertEquals(1, c1.getCadeiras().size());

        System.out.println(c1.getCadeiras());
        System.out.println(cadeira.getCurso());
    }
}
