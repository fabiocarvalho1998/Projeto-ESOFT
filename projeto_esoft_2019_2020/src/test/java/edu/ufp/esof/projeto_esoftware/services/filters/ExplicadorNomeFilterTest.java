package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.explicador.ExplicadorNomeFilter;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ExplicadorNomeFilterTest {

    @Test
    void filter() {

        Explicador explicador = new Explicador();

        explicador.setNome("explicador");
        explicador.setId(1L);

        Set<Explicador> explicadorSet = new HashSet<>();

        explicadorSet.add(explicador);

        ExplicadorNomeFilter explicadorNomeFilter = new ExplicadorNomeFilter(explicador.getNome());
        assertEquals(1, explicadorNomeFilter.filter(explicadorSet).size());

        explicadorNomeFilter = new ExplicadorNomeFilter("explicador inexistente");
        assertEquals(0, explicadorNomeFilter.filter(explicadorSet).size());
    }
}
