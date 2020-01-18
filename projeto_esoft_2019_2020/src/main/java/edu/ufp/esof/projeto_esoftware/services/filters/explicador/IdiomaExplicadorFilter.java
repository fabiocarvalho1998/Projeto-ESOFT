package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.models.Idioma;

import java.util.HashSet;
import java.util.Set;

public class IdiomaExplicadorFilter {
    private String idioma;

    public IdiomaExplicadorFilter(String idioma) {
        this.idioma = idioma;
    }

    public Set<Explicador> filter(Iterable<Explicador> explicadores) {
        if (this.idioma == null)
            return null;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores) {
            for (Idioma i : e.getIdiomas()) {
                if (i.getIdioma().matches(idioma))
                    explicadorSet.add(e);
            }
        }
        return explicadorSet;
    }
}
