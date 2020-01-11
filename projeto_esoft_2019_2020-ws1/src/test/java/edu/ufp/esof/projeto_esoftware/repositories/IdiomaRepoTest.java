package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Idioma;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class IdiomaRepoTest {
    @Autowired
    private IdiomaRepoI idiomaRepoI;

    @Test
    public void crud() {
        Idioma i = new Idioma();
        i.setIdioma("Espanhol");

        assertEquals(0, idiomaRepoI.count());
        idiomaRepoI.save(i);
        assertEquals(1, idiomaRepoI.count());
        idiomaRepoI.delete(i);
        assertEquals(0, idiomaRepoI.count());
    }
}
