package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplicacaoTest {

    @Test
    public void explicacaoOverlapsTesteSucesso() {
        Explicacao e1 = new Explicacao();
        LocalDateTime inicio1 = LocalDateTime.of(2020, 1, 1, 15, 0);
        LocalDateTime fim1 = LocalDateTime.of(2020, 1, 10, 18, 0);
        e1.setDataInicio(inicio1);
        e1.setDataFim(fim1);

        Explicacao e2 = new Explicacao();
        LocalDateTime inicio2 = LocalDateTime.of(2020, 1, 1, 15, 0);
        LocalDateTime fim2 = LocalDateTime.of(2020, 1, 10, 18, 0);
        e2.setDataInicio(inicio2);
        e2.setDataFim(fim2);

        assertEquals(true, e1.overlaps(e2));
    }

    @Test
    public void explicacaoOverlapsTesteFalha() {
        Explicacao e1 = new Explicacao();
        LocalDateTime inicio1 = LocalDateTime.of(2020, 1, 1, 15, 0);
        LocalDateTime fim1 = LocalDateTime.of(2020, 1, 10, 18, 0);
        e1.setDataInicio(inicio1);
        e1.setDataFim(fim1);

        Explicacao e2 = new Explicacao();
        LocalDateTime inicio2 = LocalDateTime.of(2019, 10, 1, 16, 0);
        LocalDateTime fim2 = LocalDateTime.of(2020, 11, 1, 18, 0);
        e2.setDataInicio(inicio2);
        e2.setDataFim(fim2);

        assertEquals(false, e1.overlaps(e2));
    }

}
