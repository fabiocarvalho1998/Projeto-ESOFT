package edu.ufp.esof.projeto_esoftware.services.filters;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.filters.explicador.CadeiraExplicadorFilter;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CadeiraExplicadorFilterTest {

    @Test
    void filter(){
        Explicador explicador1 = new Explicador.ExplicadorBuilder().nome("exp1").build();
        Explicador explicador2 = new Explicador.ExplicadorBuilder().nome("exp2").build();
        explicador1.setId(1L);
        explicador2.setId(2L);

        Cadeira cadeira1 = new Cadeira.CadeiraBuilder().nome("Bases de Dados").build();
        Cadeira cadeira2 = new Cadeira.CadeiraBuilder().nome("IAPG").build();

        Set<Explicador> explicadorSet = new HashSet<>();
        Set<Cadeira> cadeirasExplicador1 = new HashSet<>();
        Set<Cadeira> cadeirasExplicador2 = new HashSet<>();

        cadeirasExplicador1.add(cadeira1);
        cadeirasExplicador1.add(cadeira2);
        cadeirasExplicador2.add(cadeira1);

        explicador1.setCadeiras(cadeirasExplicador1);
        explicador2.setCadeiras(cadeirasExplicador2);

        explicadorSet.add(explicador1);
        explicadorSet.add(explicador2);

        CadeiraExplicadorFilter cadeiraExplicadorFilter = new CadeiraExplicadorFilter(cadeira1.getNome());
        assertEquals(2,cadeiraExplicadorFilter.filter(explicadorSet).size());
        cadeiraExplicadorFilter = new CadeiraExplicadorFilter(cadeira2.getNome());
        assertEquals(1,cadeiraExplicadorFilter.filter(explicadorSet).size());
        cadeiraExplicadorFilter = new CadeiraExplicadorFilter("Psicologia");
        assertEquals(0,cadeiraExplicadorFilter.filter(explicadorSet).size());
    }
}
