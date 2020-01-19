package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ExplicadorFilterDisponibilidadeEndTime implements FilterI<Explicador> {
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

    public ExplicadorFilterDisponibilidadeEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public Set<Explicador> filter(Set<Explicador> explicadores) {

        if (this.endTime == null)
            return explicadores;

        Set<Explicador> explicadorSet = new HashSet<>();

        for (Explicador e : explicadores)
            for (Disponibilidade d : e.getDisponibilidades())
                if (endTime.isAfter(d.getHoraFim()) || endTime.equals(d.getHoraFim()))
                    explicadorSet.add(e);

        return explicadorSet;
    }
}
