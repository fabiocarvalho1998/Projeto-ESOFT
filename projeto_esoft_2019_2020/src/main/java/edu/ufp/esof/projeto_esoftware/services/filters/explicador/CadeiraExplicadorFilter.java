package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicador;

import java.util.HashSet;
import java.util.Set;

public class CadeiraExplicadorFilter {
    private String cadeira;

    public CadeiraExplicadorFilter(String cadeira) {
        this.cadeira = cadeira;
    }


    public Set<Explicador> filter(Iterable<Explicador> explicadores) {
        if (this.cadeira == null)
            return null;

        Set<Explicador> explicadorSet = new HashSet<>();
        for (Explicador e : explicadores) {
            for (Cadeira c : e.getCadeiras()) {
                if (c.getNome().matches(cadeira))
                    explicadorSet.add(e);
            }
        }
        return explicadorSet;
    }
}
