package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest

public class ExplicadorRepoTest {
    @Autowired
    private ExplicadorRepoI explicadorRepoI;

    public void crud() {
        Explicador e = new Explicador.ExplicadorBuilder().nome("Aaron").build();

        assertEquals(0, explicadorRepoI.count());
        explicadorRepoI.save(e);
        assertEquals(1, explicadorRepoI.count());
        explicadorRepoI.delete(e);
        assertEquals(0, explicadorRepoI.count());
    }
}
