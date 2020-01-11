package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Faculdade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest

public class FaculdadeRepoTest {
    @Autowired
    private FaculdadeRepoI faculdadeRepoI;

    @Test
    public void crud() {
        Faculdade f1 = new Faculdade();
        f1.setNome("Faculdade de São Miguel");
        Faculdade f2 = new Faculdade();
        f2.setNome("Faculdade de Ciências e Tecnologias");

        assertEquals(0, faculdadeRepoI.count());
        faculdadeRepoI.save(f1);
        assertEquals(1, faculdadeRepoI.count());
        faculdadeRepoI.delete(f1);
        assertEquals(0, faculdadeRepoI.count());
    }
}
