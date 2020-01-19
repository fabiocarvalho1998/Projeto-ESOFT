package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class ExplicadorIdiomaFilter implements FilterI<Explicador> {
    private String idioma;

    public ExplicadorIdiomaFilter(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public Set<Explicador> filter(Set<Explicador> explicadores) {
        if (this.idioma == null)
            return null;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores)
            for (Idioma i : e.getIdiomas())
                if (i.getIdioma().equals(idioma))
                    explicadorSet.add(e);


        return explicadorSet;
    }
}
