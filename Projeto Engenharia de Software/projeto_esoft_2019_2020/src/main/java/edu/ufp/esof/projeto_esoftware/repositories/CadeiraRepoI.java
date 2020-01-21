package edu.ufp.esof.projeto_esoftware.repositories;


import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadeiraRepoI extends CrudRepository<Cadeira,Long> {

}
