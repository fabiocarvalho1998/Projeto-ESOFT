package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplicacaoTest {

    @Test
    public void explicacaoOverlapsTeste() {
        Explicacao e1 = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020, 1, 1, 15, 0)).
                dataFim(LocalDateTime.of(2020, 1, 1, 16, 0)).build();

        Explicacao e2 = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020, 1, 1, 15, 0)).
                dataFim(LocalDateTime.of(2020, 1, 10, 18, 0)).build();

        assertEquals(true, e1.overlaps(e2));
        if(e1.overlaps(e2))
            System.out.println("Existe um overlap nas explicacoes!");
        else{
            System.out.println("Não existe overlap!");
        }
    }


}
