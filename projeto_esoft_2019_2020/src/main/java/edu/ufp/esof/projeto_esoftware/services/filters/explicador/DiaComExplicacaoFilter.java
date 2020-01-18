package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicador;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

public class DiaComExplicacaoFilter {
    private DayOfWeek dow;

    public DiaComExplicacaoFilter(DayOfWeek dow) {
        this.dow = dow;
    }

    public Set<Explicador> filter(Set<Explicador> explicadores) {
        if (this.dow == null)
            return null;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores) {
            for (Disponibilidade d : e.getDisponibilidades()) {
                if (d.getDiaSemana().equals(dow))
                    explicadorSet.add(e);
            }
        }
        return explicadorSet;
    }
}
