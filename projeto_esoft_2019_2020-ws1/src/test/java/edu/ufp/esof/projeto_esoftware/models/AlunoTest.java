package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoTest {
    @Test
    public void addExplicacoesTeste() {
        Aluno a1 = new Aluno();
        a1.setNome("Roberto Sousa");

        Explicacao explicacao = new Explicacao();
        LocalDateTime inicio = LocalDateTime.of(2019, 3, 1, 14, 0);
        LocalDateTime fim = LocalDateTime.of(2020, 5, 1, 16, 0);
        explicacao.setDataInicio(inicio);
        explicacao.setDataFim(fim);

        assertEquals(0, a1.getExplicacoes().size());
        a1.addExplicacao(explicacao);
        assertEquals(1, a1.getExplicacoes().size());
    }
}
