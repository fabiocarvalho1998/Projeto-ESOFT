package edu.ufp.esof.projeto_esoftware.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoTest {
    @Test
    public void addExplicacoesTeste() {
        Aluno a = new Aluno.AlunoBuilder().nome("aluno teste").build();

        Explicador e=new Explicador.ExplicadorBuilder().nome("explicador teste").build();

        Cadeira c= new Cadeira.CadeiraBuilder().nome("cadeira teste").build();

        Explicacao explicacao = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020,1,11,16,0)).
                dataFim(LocalDateTime.of(2020,1,11,17,0)).explicador(e).aluno(a).cadeira(c).build();

        assertEquals(0, a.getExplicacoes().size());
        a.addExplicacao(explicacao);
        assertEquals(1, a.getExplicacoes().size());
        System.out.println(explicacao);
    }
}
