package edu.ufp.esof.projeto_esoftware.services.filters.cadeira;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.HashSet;
import java.util.Set;

public class CadeiraFilterExplicador implements FilterI<Cadeira> {
    private String nomeExplicador;

    public CadeiraFilterExplicador(String nome) {
        this.nomeExplicador = nome;
    }


    @Override
    public Set<Cadeira> filter(Set<Cadeira> cadeiras) {
        if (this.nomeExplicador == null)
            return cadeiras;

        Set<Cadeira> cadeiraHashSet = new HashSet<>();
        for (Cadeira ca : cadeiras)
            for (Explicador ei : ca.getExplicadores())
                if (ei != null && ca.getExplicadores()!=null && ei.getCadeiras().contains(ca))
                    cadeiraHashSet.add(ca);
        return cadeiraHashSet;
    }

}