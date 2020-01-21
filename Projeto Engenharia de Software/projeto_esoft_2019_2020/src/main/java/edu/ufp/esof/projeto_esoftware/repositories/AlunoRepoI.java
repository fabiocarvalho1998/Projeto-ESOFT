package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepoI extends CrudRepository<Aluno,Long> {
    Optional<Aluno> findByNome(String nome);
    //Optional<Aluno> findByNome
}
