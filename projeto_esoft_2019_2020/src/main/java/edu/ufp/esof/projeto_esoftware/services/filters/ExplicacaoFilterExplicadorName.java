package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;

import java.util.HashSet;
import java.util.Set;

public class ExplicacaoFilterExplicadorName implements FilterExplicacaoI {
    private String explicadorName;

    public ExplicacaoFilterExplicadorName(String explicadorName) {
        this.explicadorName = explicadorName;
    }

    @Override
    public Set<Explicacao> filter(Set<Explicacao> explicacoes) {
        //todo implementar -> || this.explicadorName.isBlank()
        if (this.explicadorName == null )
            return explicacoes;

        Set<Explicacao> explicacoesToBeReturned = new HashSet<>();
        for (Explicacao ei : explicacoes) {
            if (ei.getExplicador() != null && ei.getExplicador().getNome() != null && ei.getExplicador().getNome().equals(explicadorName))
                explicacoesToBeReturned.add(ei);
        }
        return explicacoesToBeReturned;
    }
}
