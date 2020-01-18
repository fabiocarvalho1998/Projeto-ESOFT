package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicador;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

public class DiaSemExplicacaoFilter {
    private DayOfWeek dow;

    public DiaSemExplicacaoFilter(int dayInteger) {
        this.dow = DayOfWeek.of(dayInteger);
    }

    public Set<Explicador> filter(Iterable<Explicador> explicadores) {
        if (this.dow == null)
            return null;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores) {
            for (Disponibilidade d : e.getDisponibilidades()) {
                if (d.getDiaSemana().getValue() == dow.getValue())
                    explicadorSet.add(e);
            }
        }
        return explicadorSet;
    }
}
