package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class ExplicadorFilterIdioma implements FilterI<Explicador> {
    private String nomeIdioma;

    public ExplicadorFilterIdioma(String nome) {
        this.nomeIdioma = nome;
    }

    @Override
    public Set<Explicador> filter(Set<Explicador> explicadores) {
        if (this.nomeIdioma == null)
            return explicadores;

        Set<Explicador> explicadorHashSet = new HashSet<>();
        for (Explicador ei : explicadores) {
            for (Idioma idioma : ei.getIdiomas())
                if (idioma != null && ei.getIdiomas() != null
                        && idioma.getIdioma().equals(nomeIdioma))
                    explicadorHashSet.add(ei);
        }
        return explicadorHashSet;
    }

}



