package edu.ufp.esof.projeto_esoftware.repositories;

import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DisponibilidadeRepoTest {
    @Autowired
    private DisponibilidadeRepoI disponibilidadeRepoI;

    @Test
    public void crud() {
        Disponibilidade d = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.FRIDAY).
                horaInicio(LocalTime.of(10,0)).horaFim(LocalTime.of(12,0)).build();

        assertEquals(0, disponibilidadeRepoI.count());
        disponibilidadeRepoI.save(d);
        assertEquals(1,disponibilidadeRepoI.count());
        disponibilidadeRepoI.delete(d);
        assertEquals(0, disponibilidadeRepoI.count());
    }
}
