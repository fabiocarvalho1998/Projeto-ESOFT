package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest

public class ExplicacaoRepoTest {
    @Autowired
    private ExplicacaoRepoI explicacaoRepoI;

    @Test
    public void crud() {
        Explicacao e = new Explicacao();
        LocalDateTime inicio1 = LocalDateTime.of(2020, 1, 1, 15, 0);
        LocalDateTime fim1 = LocalDateTime.of(2020, 1, 10, 18, 0);
        e.setDataInicio(inicio1);
        e.setDataFim(fim1);

        assertEquals(0, explicacaoRepoI.count());
        explicacaoRepoI.save(e);
        assertEquals(1, explicacaoRepoI.count());
        explicacaoRepoI.delete(e);
        assertEquals(0, explicacaoRepoI.count());
    }
}
