package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.explicador.ExplicadorDiaFilter;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExplicadorDiaFilterTest {

    @Test
    void filter() {
        Explicador explicador1 = new Explicador.ExplicadorBuilder().nome("exp1").build();
        explicador1.setId(1L);
        Explicador explicador2 = new Explicador.ExplicadorBuilder().nome("exp2").build();
        explicador1.setId(2L);

        Disponibilidade disponibilidade1 = new Disponibilidade.DisponibilidadeBuilder()
                .diaSemana(DayOfWeek.FRIDAY)
                .horaInicio(LocalTime.of(10, 0))
                .horaFim(LocalTime.of(12, 30))
                .build();
        disponibilidade1.setId(1L);
        disponibilidade1.setExplicador(explicador1);
        Disponibilidade disponibilidade2 = new Disponibilidade.DisponibilidadeBuilder()
                .diaSemana(DayOfWeek.MONDAY)
                .horaInicio(LocalTime.of(20, 0))
                .horaFim(LocalTime.of(22, 30))
                .build();
        disponibilidade2.setExplicador(explicador1);
        disponibilidade2.setId(2L);

        Set<Disponibilidade> disponibilidadesExplicador1 = new HashSet<>();
        Set<Disponibilidade> disponibilidadesExplicador2 = new HashSet<>();
        Set<Explicador> explicadorSet = new HashSet<>();

        disponibilidadesExplicador1.add(disponibilidade1);
        disponibilidadesExplicador1.add(disponibilidade2);
        disponibilidadesExplicador2.add(disponibilidade2);

        explicador1.setDisponibilidades(disponibilidadesExplicador1);
        explicador2.setDisponibilidades(disponibilidadesExplicador2);

        explicadorSet.add(explicador1);
        explicadorSet.add(explicador2);

        ExplicadorDiaFilter explicadorDiaFilter = new ExplicadorDiaFilter(disponibilidade2.getDiaSemana());
        assertEquals(2, explicadorDiaFilter.filter(explicadorSet).size());
        explicadorDiaFilter = new ExplicadorDiaFilter(disponibilidade1.getDiaSemana());
        assertEquals(1, explicadorDiaFilter.filter(explicadorSet).size());
        explicadorDiaFilter = new ExplicadorDiaFilter(DayOfWeek.SUNDAY);
        assertEquals(0, explicadorDiaFilter.filter(explicadorSet).size());
    }

}
