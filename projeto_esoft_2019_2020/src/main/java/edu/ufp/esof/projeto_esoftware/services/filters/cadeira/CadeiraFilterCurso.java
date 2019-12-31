package edu.ufp.esof.projeto_esoftware.services.filters.cadeira;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class CadeiraFilterCurso implements FilterI<Cadeira> {
    private String nomeCurso;

    public CadeiraFilterCurso(String nome) {
        this.nomeCurso = nome;
    }


    @Override
    public Set<Cadeira> filter(Set<Cadeira> cadeiras) {
        if (this.nomeCurso == null)
            return cadeiras;

        Set<Cadeira> cadeiraHashSet = new HashSet<>();
        for (Cadeira ca : cadeiras)
            if (ca != null && ca.getCurso().getNome().equals(nomeCurso))
                cadeiraHashSet.add(ca);
        return cadeiraHashSet;
    }


}



