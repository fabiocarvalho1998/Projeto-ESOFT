package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

public class ExplicadorDiaFilter implements FilterI<Explicador> {

    private DayOfWeek dia;

    public ExplicadorDiaFilter(DayOfWeek dia) {
        this.dia = dia;
    }

    public Set<Explicador> filter(Set<Explicador> explicadores) {
        if (dia == null)
            return explicadores;

        Set<Explicador> explicadorSet = new HashSet<>();

        for (Explicador e : explicadores)
            for (Disponibilidade d : e.getDisponibilidades())
                if (d.getDiaSemana().equals(dia))
                    explicadorSet.add(e);

        return explicadorSet;
    }
}
