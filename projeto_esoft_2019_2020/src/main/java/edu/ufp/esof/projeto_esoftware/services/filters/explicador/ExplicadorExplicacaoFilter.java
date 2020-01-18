package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Explicador;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ExplicadorExplicacaoFilter {
    private LocalTime horaInicio;
    private int diaSemana;

    public ExplicadorExplicacaoFilter(LocalTime horaInicio, int diaSemana) {
        this.horaInicio = horaInicio;
        this.diaSemana = diaSemana;
    }

    public Set<Explicador> filter(Iterable<Explicador> explicadores) {
        if (this.horaInicio == null || this.diaSemana > 7 || this.diaSemana < 0)
            return null;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores) {
            if (e.temhorario(diaSemana, horaInicio))
                explicadorSet.add(e);
        }
        return explicadorSet;
    }
}
