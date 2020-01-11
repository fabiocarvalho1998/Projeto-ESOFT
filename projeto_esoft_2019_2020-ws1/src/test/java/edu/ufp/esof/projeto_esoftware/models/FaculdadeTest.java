package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaculdadeTest {
    @Test
    public void addCursoTeste() {
        Faculdade f1 = new Faculdade();
        f1.setNome("Faculdade de Moscovo");

        Curso curso = new Curso();
        curso.setNome("Psicologia");

        assertEquals(0, f1.getCursos().size());
        f1.addCurso(curso);
        assertEquals(1, f1.getCursos().size());
    }
}
