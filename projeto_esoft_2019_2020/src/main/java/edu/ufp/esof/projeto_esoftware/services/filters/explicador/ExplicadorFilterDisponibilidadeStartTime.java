package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ExplicadorFilterDisponibilidadeStartTime implements FilterI<Explicador> {

    private LocalTime startTime;

    public ExplicadorFilterDisponibilidadeStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public Set<Explicador> filter(Set<Explicador> explicadores) {

        if (this.startTime == null)
            return explicadores;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores)
            for (Disponibilidade d : e.getDisponibilidades())
                if (startTime.isAfter(d.getHoraInicio()) || startTime.equals(d.getHoraInicio()))
                    explicadorSet.add(e);

        return explicadorSet;
    }
}
