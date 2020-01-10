package edu.ufp.esof.projeto_esoftware.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.ExplicadorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExplicadorController.class)
public class ExplicadorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExplicadorService explicadorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createExplicador() throws Exception {
        Explicador explicador = new Explicador();
        explicador.setNome("explicador1");

        String jsonRequest = this.objectMapper.writeValueAsString(explicador);

        doReturn(Optional.of(explicador)).when(explicadorService.createExplicador(explicador));

        this.mockMvc.perform(
                post("/explicador").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
        ).andExpect(
                status().isOk()
        );

        Explicador existingExplicador = new Explicador();
        explicador.setNome("explicador2");

        doReturn(Optional.empty()).when(this.explicadorService.createExplicador(existingExplicador));

        String existingExplicadorJson = this.objectMapper.writeValueAsString(existingExplicador);

        this.mockMvc.perform(
                post("/explicador").contentType(MediaType.APPLICATION_JSON).content(existingExplicadorJson)
        ).andExpect(
                status().isBadRequest()
        );
    }

    @Test
    void getAllExplicadores() {
    }

    @Test
    void getExplicadorByNome() throws Exception {
        Explicador explicador = new Explicador();
        explicador.setNome("explicador1");

        when(this.explicadorService.getExplicadorByNome("explicador1")).thenReturn(Optional.of(explicador));

        String responseJson = this.mockMvc.perform(
                get("/explicador/explicador1")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse().getContentAsString();

        Explicador responseExplicador = this.objectMapper.readValue(responseJson, Explicador.class);
        assertEquals(explicador, responseExplicador);

        this.mockMvc.perform(
                get("/explicador/explicador2")
        ).andExpect(
                status().isNotFound()
        );
    }

}
