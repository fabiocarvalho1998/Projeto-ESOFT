package edu.ufp.esof.projeto_esoftware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.services.DisponibilidadeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DisponibilidadesController.class)
public class DisponibilidadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DisponibilidadeService disponibilidadeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createDisponibilidade() throws Exception {
        Disponibilidade disponibilidade = new Disponibilidade.DisponibilidadeBuilder().diaSemana(DayOfWeek.FRIDAY).
                horaInicio(LocalTime.of(10, 0)).horaFim(LocalTime.of(12, 0)).build();

        String jsonRequest = this.objectMapper.writeValueAsString(disponibilidade);

        doReturn(disponibilidade).when(disponibilidadeService).createDisponibilidade(disponibilidade);

        this.mockMvc.perform(
                post("/disponibilidade").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
        ).andExpect(
                status().isOk()
        );
    }

}
