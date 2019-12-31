package edu.ufp.esof.projeto_esoftware.services.filters.explicacao;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class ExplicacaoFilterCadeira implements FilterI<Explicacao> {
    private String nomeCadeira;

    public ExplicacaoFilterCadeira(String nome) {
        this.nomeCadeira = nome;
    }

    @Override
    public Set<Explicacao> filter(Set<Explicacao> explicacoes) {
        if (this.nomeCadeira == null)
            return explicacoes;

        Set<Explicacao> explicacaoHashSet = new HashSet<>();
        for (Explicacao ei : explicacoes) {
            if (ei.getCadeira().getNome().equals(nomeCadeira))
                explicacaoHashSet.add(ei);
        }
        return explicacaoHashSet;
    }
}

