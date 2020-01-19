package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.AndFilter;
import edu.ufp.esof.projeto_esoftware.services.filters.FilterI;

import java.util.Set;

public class FilterExplicadorService {
    public Set<Explicador> filter(Set<Explicador> explicadores, FilterExplicadorObject filterExplicadorObject) {

        FilterI<Explicador> cadeiraFilter = new CadeiraExplicadorFilter(filterExplicadorObject.getCadeira());
        FilterI<Explicador> diaFilter = new ExplicadorDiaFilter(filterExplicadorObject.getDia().getDayOfWeek());
        FilterI<Explicador> fimFilter = new ExplicadorFilterDisponibilidadeEndTime(filterExplicadorObject.getFim());
        FilterI<Explicador> inicioFilter = new ExplicadorFilterDisponibilidadeStartTime(filterExplicadorObject.getInicio());
        FilterI<Explicador> idiomaFilter = new ExplicadorIdiomaFilter(filterExplicadorObject.getIdioma());
        FilterI<Explicador> nomeFilter = new ExplicadorNomeFilter(filterExplicadorObject.getNome());

        FilterI<Explicador> nomeCadeiraFilter = new AndFilter<>(nomeFilter, cadeiraFilter);
        FilterI<Explicador> nomeCadeiraIdiomaFilter = new AndFilter<>(nomeCadeiraFilter, idiomaFilter);
        FilterI<Explicador> diaInicioFilter = new AndFilter<>(diaFilter, inicioFilter);
        FilterI<Explicador> diaInicioFimFilter = new AndFilter<>(diaInicioFilter, fimFilter);

        return new AndFilter<>(nomeCadeiraIdiomaFilter, diaInicioFimFilter).filter(explicadores);
    }
}
