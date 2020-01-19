package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExplicadorFilterDisponibilidadeEndTimeTest {
    @Test
    void Filter() {
        Disponibilidade disponibilidade1 = new Disponibilidade
                .DisponibilidadeBuilder().diaSemana(DayOfWeek.FRIDAY)
                .horaInicio(LocalTime.of(10, 0))
                .horaFim(LocalTime.of(12, 0)).build();
        Disponibilidade disponibilidade2 = new Disponibilidade
                .DisponibilidadeBuilder().diaSemana(DayOfWeek.TUESDAY)
                .horaInicio(LocalTime.of(17, 0))
                .horaFim(LocalTime.of(19, 30)).build();
        disponibilidade1.setId(1L);
        disponibilidade2.setId(2L);

        Explicador explicador1 = new Explicador.ExplicadorBuilder().nome("exp1").build();
        Explicador explicador2 = new Explicador.ExplicadorBuilder().nome("exp2").build();
        explicador1.setId(1L);
        explicador2.setId(2L);

        Set<Explicador> explicadorSet = new HashSet<>();
        Set<Disponibilidade> disponibilidadesExplicador1 = new HashSet<>();
        Set<Disponibilidade> disponibilidadesExplicador2 = new HashSet<>();

        disponibilidadesExplicador1.add(disponibilidade1);
        disponibilidadesExplicador1.add(disponibilidade2);
        disponibilidadesExplicador2.add(disponibilidade1);

        explicador1.setDisponibilidades(disponibilidadesExplicador1);
        explicador2.setDisponibilidades(disponibilidadesExplicador2);

        explicadorSet.add(explicador1);
        explicadorSet.add(explicador2);

        /*todo
        ExplicadorFilterDisponibilidadeStartTimeTest explicadorFilterExplicacaoStartTime = new ExplicadorFilterDisponibilidadeStartTimeTest();
        assertEquals(0, explicadorFilterExplicacaoStartTime.filter(explicadorSet).size);*/

    }
}
