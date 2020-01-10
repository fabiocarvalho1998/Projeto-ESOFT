package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AlunoRepoTest {

    @Autowired
    private AlunoRepoI alunoRepoI;

    @Test
    public void crud() {
        Aluno a = new Aluno();
        a.setNome("Rita Oliveira");

        assertEquals(0, alunoRepoI.count());
        alunoRepoI.save(a);
        assertEquals(1, alunoRepoI.count());
        alunoRepoI.delete(a);
        assertEquals(0, alunoRepoI.count());
    }
}
