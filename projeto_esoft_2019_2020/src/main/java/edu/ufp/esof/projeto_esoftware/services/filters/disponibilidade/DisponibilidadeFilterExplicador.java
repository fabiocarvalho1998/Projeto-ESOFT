package edu.ufp.esof.projeto_esoftware.services.filters.disponibilidade;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class DisponibilidadeFilterExplicador implements FilterI<Disponibilidade> {

    private String nomeExplicador;

    public DisponibilidadeFilterExplicador(String nome) {
        this.nomeExplicador = nome;
    }

    @Override
    public Set<Disponibilidade> filter(Set<Disponibilidade> disponibilidades) {
        if (this.nomeExplicador == null)
            return disponibilidades;

        Set<Disponibilidade> explicacaoHashSet = new HashSet<>();
        for (Disponibilidade di: disponibilidades) {
            if (di.getExplicador().getNome().equals(nomeExplicador))
                explicacaoHashSet.add(di);
        }
        return explicacaoHashSet;
    }
}

