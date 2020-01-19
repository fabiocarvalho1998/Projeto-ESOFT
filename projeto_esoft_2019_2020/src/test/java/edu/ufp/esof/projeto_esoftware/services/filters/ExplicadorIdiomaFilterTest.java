package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.services.filters.explicador.ExplicadorIdiomaFilter;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExplicadorIdiomaFilterTest {

    @Test
    void filter() {
        Explicador explicador1 = new Explicador();
        Explicador explicador2 = new Explicador();
        explicador1.setId(1L);
        explicador2.setId(2L);

        Set<Idioma> idiomasExplicador1 = new HashSet<>();
        Set<Idioma> idiomasExplicador2 = new HashSet<>();
        Set<Explicador> explicadorSet = new HashSet<>();

        Idioma idioma1 = new Idioma();
        Idioma idioma2 = new Idioma();
        Idioma idioma3 = new Idioma();
        idioma1.setIdioma("Espanhol");
        idioma2.setIdioma("Swahili");
        idioma3.setIdioma("Russo");

        idiomasExplicador1.add(idioma1);
        idiomasExplicador1.add(idioma3);
        idiomasExplicador2.add(idioma1);
        idiomasExplicador2.add(idioma2);

        explicador1.setIdiomas(idiomasExplicador1);
        explicador2.setIdiomas(idiomasExplicador2);

        explicadorSet.add(explicador1);
        explicadorSet.add(explicador2);

        ExplicadorIdiomaFilter explicadorIdiomaFilter = new ExplicadorIdiomaFilter(idioma1.getIdioma());
        assertEquals(2, explicadorIdiomaFilter.filter(explicadorSet).size());
        explicadorIdiomaFilter = new ExplicadorIdiomaFilter("Swahili");
        assertEquals(1, explicadorIdiomaFilter.filter(explicadorSet).size());
        explicadorIdiomaFilter = new ExplicadorIdiomaFilter("Russo");
        assertEquals(1, explicadorIdiomaFilter.filter(explicadorSet).size());
        explicadorIdiomaFilter = new ExplicadorIdiomaFilter("Chinês");
        assertEquals(0, explicadorIdiomaFilter.filter(explicadorSet).size());
    }
}
