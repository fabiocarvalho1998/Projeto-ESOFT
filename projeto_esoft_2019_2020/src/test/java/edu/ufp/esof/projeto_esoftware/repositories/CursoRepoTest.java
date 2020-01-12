package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CursoRepoTest {
    @Autowired
    private CursoRepoI cursoRepoI;

    @Test
    public void crud() {
        Curso c = new Curso.CursoBuilder().nome("Fisioterapia").build();

        assertEquals(0, cursoRepoI.count());
        cursoRepoI.save(c);
        assertEquals(1, cursoRepoI.count());
        cursoRepoI.delete(c);
        assertEquals(0, cursoRepoI.count());
    }
}
