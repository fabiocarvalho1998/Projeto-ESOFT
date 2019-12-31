package edu.ufp.esof.projeto_esoftware.services.filters.explicacao;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class ExplicacaoFilterAluno implements FilterI<Explicacao> {
    private String nomeAluno;

    public ExplicacaoFilterAluno(String nome) {
        this.nomeAluno = nome;
    }

    @Override
    public Set<Explicacao> filter(Set<Explicacao> explicacoes) {
        if (this.nomeAluno == null)
            return explicacoes;

        Set<Explicacao> explicacaoHashSet = new HashSet<>();
        for (Explicacao ei : explicacoes) {
            if (ei.getAluno().getNome().equals(nomeAluno))
                explicacaoHashSet.add(ei);
        }
        return explicacaoHashSet;
    }

}



