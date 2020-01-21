package edu.ufp.esof.projeto_esoftware.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import edu.ufp.esof.projeto_esoftware.ProjetoEsoftwareApplication;
import edu.ufp.esof.projeto_esoftware.models.Aluno;


@ContextConfiguration(classes=ProjetoEsoftwareApplication.class)
@DataJpaTest
public class AlunoRepositoryIntegrationTest {

    @Autowired
    private AlunoRepoI alunoRepository;

    @Test
    public void whenFindById_thenReturnAluno() {
        // given
        Aluno aluno = new Aluno.AlunoBuilder().nome("Edward").build();
        alunoRepository.save(aluno);

        // when
        Optional<Aluno> result = alunoRepository.findById(aluno.getId());

        // then
        assertTrue(result.isPresent());

        assertEquals(result.get().getNome(),aluno.getNome());
    }


}
