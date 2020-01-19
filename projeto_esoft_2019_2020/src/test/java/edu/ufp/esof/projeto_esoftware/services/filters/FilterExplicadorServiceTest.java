package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

class FilterExplicadorServiceTest {

    @Test
    void filter() {
        Cadeira cadeira = new Cadeira.CadeiraBuilder().nome("Bases de Dados").build();
        DayOfWeek dia = DayOfWeek.MONDAY;
        LocalTime fim = LocalTime.of(14,15);
        LocalTime inicio = LocalTime.of(9,30);
        Idioma idioma = new Idioma.IdiomaBuilder().idioma("Frances").build();
        Explicador explicador1 = new Explicador.ExplicadorBuilder().nome("Mariana").build();
        explicador1.setId(1L);

        //todo
    }

}
