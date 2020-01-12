package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversidadeRepoI extends CrudRepository<Universidade, Long> {
    Optional<Universidade> findByNome(String nome);
}
