package edu.ufp.esof.projeto_esoftware.services.filters.explicacao;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ExplicacaoFilterStartDate implements FilterI<Explicacao> {
    private LocalDateTime startDate;

    public ExplicacaoFilterStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Set<Explicacao> filter(Set<Explicacao> explicacoes) {
        if (this.startDate == null)
            return explicacoes;
        Set<Explicacao> explicacaoHashSet = new HashSet<>();
        for (Explicacao ei : explicacoes) {
            if (ei != null && ei.getDataInicio() != null &&
                    (ei.getDataInicio().isAfter(this.startDate)) ||
                    (ei.getDataInicio().equals(this.startDate))) {
                explicacaoHashSet.add(ei);
            }
        }
        return explicacaoHashSet;
    }
}
