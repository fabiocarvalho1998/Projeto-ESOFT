package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ExplicadorFilterExplicacaoStartTime implements FilterI<Explicador> {
    private LocalTime startTime;
    private DayOfWeek dow;

    public ExplicadorFilterExplicacaoStartTime(LocalTime startTime, DayOfWeek dow) {
        this.startTime = startTime;
        this.dow = dow;
    }

    @Override
    public Set<Explicador> filter(Set<Explicador> explicadores) {
        if (this.startTime == null || this.dow == null)
            return explicadores;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores)
            if (e.temhorario(dow.getValue(), startTime))
                explicadorSet.add(e);

        return explicadorSet;
    }
}
