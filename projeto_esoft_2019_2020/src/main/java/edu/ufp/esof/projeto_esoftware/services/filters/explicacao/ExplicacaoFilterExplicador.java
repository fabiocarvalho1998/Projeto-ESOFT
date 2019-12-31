package edu.ufp.esof.projeto_esoftware.services.filters.explicacao;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class ExplicacaoFilterExplicador implements FilterI<Explicacao> {

    private String nomeExplicador;

    public ExplicacaoFilterExplicador(String nome) {
        this.nomeExplicador = nome;
    }

    @Override
    public Set<Explicacao> filter(Set<Explicacao> explicacoes) {
        if (this.nomeExplicador == null)
            return explicacoes;

        Set<Explicacao> explicacaoHashSet = new HashSet<>();
        for (Explicacao ei : explicacoes) {
            if (ei.getExplicador().getNome().equals(nomeExplicador))
                explicacaoHashSet.add(ei);
        }
        return explicacaoHashSet;
    }

}
