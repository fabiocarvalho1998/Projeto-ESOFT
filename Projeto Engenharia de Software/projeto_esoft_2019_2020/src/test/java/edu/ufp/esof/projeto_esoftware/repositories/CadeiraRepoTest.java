package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CadeiraRepoTest {
    @Autowired
    private CadeiraRepoI cadeiraRepoI;

    @Test
    public void crud() {
        Cadeira c = new Cadeira.CadeiraBuilder().nome("Multimédia").build();

        assertEquals(0, cadeiraRepoI.count());
        cadeiraRepoI.save(c);
        assertEquals(1,cadeiraRepoI.count());
        cadeiraRepoI.delete(c);
        assertEquals(0, cadeiraRepoI.count());
    }
}


