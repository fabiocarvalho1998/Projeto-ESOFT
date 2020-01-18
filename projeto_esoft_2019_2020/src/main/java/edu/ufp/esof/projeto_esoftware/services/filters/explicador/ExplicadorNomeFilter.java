package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class ExplicadorNomeFilter implements FilterI<Explicador> {
    private String nome;

    public ExplicadorNomeFilter(String nome) {
        this.nome = nome;
    }

    @Override
    public Set<Explicador> filter(Set<Explicador> explicadores) {
        if (nome == null)
            return explicadores;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores) {
            if (e.getNome().equals(nome))
                explicadorSet.add(e);
        }
        return explicadorSet;
    }
}
