package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaculdadeTest {
    @Test
    public void addCursoTeste() {
        Faculdade f1 = new Faculdade.FaculdadeBuilder().nome("Faculdade de Ciencias e Tecnologias").build();

        Curso curso = new Curso.CursoBuilder().nome("Fisioterapia").build();

        assertEquals(0, f1.getCursos().size());
        f1.addCurso(curso);
        assertEquals(1, f1.getCursos().size());
        System.out.println(f1.getCursos());
    }
}
