package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface ExplicadorRepoI extends CrudRepository<Explicador,Long> {
    @Query("SELECT e FROM Explicador e join e.disponibilidades d join e.cadeiras ec where ec.id=?1 and d.diaSemana=?2 and  d.horaInicio<= ?3 and d.horaFim>= ?4")
    Iterable<Explicador> getExplicadoresDisponiveisCadeiraData(Long idCadeira, DayOfWeek dia, LocalTime horaInicio, LocalTime horaFim);

    Optional<Explicador> findByNome(String nome);
}