package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;

import java.util.Set;

public interface FilterExplicacaoI {
    Set<Explicacao> filter(Set<Explicacao> explicacoes);
}
