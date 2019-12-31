package edu.ufp.esof.projeto_esoftware.services.filters.cadeira;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class CadeiraFilterFaculdade implements FilterI<Cadeira> {
    private String nomeFaculdade;

    public CadeiraFilterFaculdade(String nome) {
        this.nomeFaculdade = nome;
    }


    @Override
    public Set<Cadeira> filter(Set<Cadeira> cadeiras) {
        if (this.nomeFaculdade == null)
            return cadeiras;

        Set<Cadeira> cadeiraHashSet = new HashSet<>();
        for (Cadeira ca : cadeiras)
            if (ca != null && ca.getCurso().getFaculdade().getNome().equals(nomeFaculdade))
                cadeiraHashSet.add(ca);
        return cadeiraHashSet;
    }
}
