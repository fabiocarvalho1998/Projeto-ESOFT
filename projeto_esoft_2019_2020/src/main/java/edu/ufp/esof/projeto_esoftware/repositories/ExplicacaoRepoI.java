package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplicacaoRepoI extends CrudRepository<Explicacao,Long> {

}
