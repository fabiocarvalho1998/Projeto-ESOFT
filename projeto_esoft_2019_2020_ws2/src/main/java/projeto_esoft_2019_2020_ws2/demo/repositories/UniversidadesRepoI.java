package projeto_esoft_2019_2020_ws2.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projeto_esoft_2019_2020_ws2.demo.universidadeAPI.Universidade;

import java.util.Optional;

@Repository
public interface UniversidadesRepoI extends CrudRepository<Universidade, Long> {
    Optional<Universidade> findByNome(String nome);
}
